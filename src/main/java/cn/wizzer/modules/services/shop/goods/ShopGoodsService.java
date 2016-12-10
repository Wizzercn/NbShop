package cn.wizzer.modules.services.shop.goods;

import cn.wizzer.common.base.Globals;
import cn.wizzer.common.base.Service;
import cn.wizzer.common.services.pubsub.PubSub;
import cn.wizzer.common.services.pubsub.PubSubService;
import cn.wizzer.common.services.redis.RedisKey;
import cn.wizzer.common.util.StringUtil;
import cn.wizzer.modules.models.shop.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.List;

import static cn.wizzer.common.services.redis.RedisInterceptor.jedis;

@IocBean(args = {"refer:dao"}, create = "init")
public class ShopGoodsService extends Service<Shop_goods> implements RedisKey, PubSub {
    @Inject
    private ShopGoodsProductsService shopGoodsProductsService;
    @Inject
    private ShopMemberLvService shopMemberLvService;
    @Inject
    private ShopGoodsLvPriceService shopGoodsLvPriceService;
    @Inject
    private ShopGoodsImagesService shopGoodsImagesService;
    @Inject
    private PubSubService pubSubService;

    private static final Log log = Logs.get();

    public ShopGoodsService(Dao dao) {
        super(dao);
    }

    /**
     * 添加商品
     *
     * @param shopGoods
     * @param products
     * @param spec_values
     * @param prop_values
     * @param param_values
     * @param images
     * @return
     */
    @Aop(TransAop.READ_COMMITTED)
    public String add(Shop_goods shopGoods, String products, String spec_values, String prop_values, String param_values, String images) {
        shopGoods.setParam(param_values);
        shopGoods.setSpec(spec_values);
        shopGoods.setProp(prop_values);
        if (!shopGoods.isDisabled()) {//上架时间
            shopGoods.setUpAt((int) (System.currentTimeMillis() / 1000));
        }
        this.insert(shopGoods);
        //商品货品
        NutMap[] productArr = Json.fromJsonAsArray(NutMap.class, products);
        if (productArr != null) {
            if (!shopGoods.isHasSpec() && Strings.isBlank(productArr[0].getString("sku"))) {
                //如果没有启用规格，并且第一个货品SKU为null或空白字符则自动生成SKU
                productArr[0].setv("sku", shopGoodsProductsService.getSkuPrefix());
            }
            for (int i = 0; i < productArr.length; i++) {
                String name = "";
                String spec = Strings.sNull(productArr[i].getString("spec"));
                Shop_goods_products product = new Shop_goods_products();
                product.setGoodsId(shopGoods.getId());
                product.setLocation(i);
                product.setSpec(spec);
                product.setUnit(shopGoods.getUnit());
                //如果SKU为null或空白字符则自动生成SKU
                if (Strings.isBlank(productArr[i].getString("sku"))) {
                    product.setSku(shopGoodsProductsService.getSkuPrefix() + "-" + i);
                } else {
                    product.setSku(productArr[i].getString("sku").toUpperCase());
                }
                //通过规格获取名称
                if (spec.contains("*") && spec.contains(":")) {
                    String[] str = StringUtils.split(spec, "*");
                    for (String temp : str) {
                        String[] s = StringUtils.split(temp, ":");
                        name += s[1] + " ";
                    }
                } else if (spec.contains(":")) {
                    String[] s = StringUtils.split(spec, ":");
                    name = s[1];
                }
                product.setName(name);
                product.setIsDefault(productArr[i].getBoolean("isDefault"));
                product.setDisabled(productArr[i].getBoolean("disabled"));
                if (!product.isDisabled()) {//上架时间
                    product.setUpAt((int) (System.currentTimeMillis() / 1000));
                }
                product.setStock(NumberUtils.toInt(productArr[i].getString("stock"), 0));
                product.setBuyMin(NumberUtils.toInt(productArr[i].getString("buyMin"), 0));
                product.setBuyMax(NumberUtils.toInt(productArr[i].getString("buyMax"), 0));
                product.setWeight(NumberUtils.toInt(productArr[i].getString("weight"), 0));
                product.setPrice(StringUtil.yuanToFen(Strings.sNull(productArr[i].getString("price"))));
                product.setPriceMarket(StringUtil.yuanToFen(Strings.sNull(productArr[i].getString("priceMarket"))));
                shopGoodsProductsService.insert(product);
                //会员价
                NutMap[] lvPrice = productArr[i].getArray("lvprice", NutMap.class);
                if (lvPrice != null) {
                    for (int k = 0; k < lvPrice.length; k++) {
                        Shop_goods_lv_price lv = new Shop_goods_lv_price();
                        lv.setGoodsId(shopGoods.getId());
                        lv.setProductId(product.getId());
                        lv.setLvId(Strings.sNull(lvPrice[k].getString("lvId")));
                        lv.setLvPrice(StringUtil.yuanToFen(Strings.sNull(lvPrice[k].getString("lvPrice"))));
                        shopGoodsLvPriceService.insert(lv);
                    }
                }
            }
        }
        //商品相册
        NutMap[] imgArr = Json.fromJsonAsArray(NutMap.class, images);
        if (imgArr != null) {
            String defaultImge = "";
            for (int i = 0; i < imgArr.length; i++) {
                if (i == 0 || imgArr[i].getBoolean("d")) defaultImge = imgArr[i].getString("url");
                Shop_goods_images goodsImage = new Shop_goods_images();
                goodsImage.setGoodsId(shopGoods.getId());
                goodsImage.setLocation(i);
                goodsImage.setImgurl(Strings.sNull(imgArr[i].getString("url")));
                shopGoodsImagesService.insert(goodsImage);
            }
            this.update(Chain.make("imgurl", defaultImge), Cnd.where("id", "=", shopGoods.getId()));
        }
        return shopGoods.getId();
    }

    /**
     * 修改商品
     *
     * @param shopGoods
     * @param products
     * @param spec_values
     * @param prop_values
     * @param param_values
     * @param images
     * @return
     */
    @Aop(TransAop.READ_COMMITTED)
    public String save(Shop_goods shopGoods, String products, String spec_values, String prop_values, String param_values, String images, String uid) {
        shopGoods.setParam(param_values);
        shopGoods.setSpec(spec_values);
        shopGoods.setProp(prop_values);
        shopGoods.setOpAt((int) (System.currentTimeMillis() / 1000));
        shopGoods.setOpBy(uid);
        this.updateIgnoreNull(shopGoods);
        //删除商品会员价格信息
        shopGoodsLvPriceService.clear(Cnd.where("goodsId", "=", shopGoods.getId()));
        //删除商品相册信息
        shopGoodsImagesService.clear(Cnd.where("goodsId", "=", shopGoods.getId()));
        //删除商品货品信息
        shopGoodsProductsService.clear(Cnd.where("goodsId", "=", shopGoods.getId()));
        //商品货品
        NutMap[] productArr = Json.fromJsonAsArray(NutMap.class, products);
        if (productArr != null) {
            if (!shopGoods.isHasSpec() && Strings.isBlank(productArr[0].getString("sku"))) {
                //如果没有启用规格，并且第一个货品SKU为null或空白字符则自动生成SKU
                productArr[0].setv("sku", shopGoodsProductsService.getSkuPrefix());
            }
            for (int i = 0; i < productArr.length; i++) {
                String name = "";
                String spec = Strings.sNull(productArr[i].getString("spec"));
                Shop_goods_products product = new Shop_goods_products();
                product.setGoodsId(shopGoods.getId());
                product.setLocation(i);
                product.setSpec(spec);
                product.setUnit(shopGoods.getUnit());
                //如果SKU为null或空白字符则自动生成SKU
                if (Strings.isBlank(productArr[i].getString("sku"))) {
                    product.setSku(shopGoodsProductsService.getSkuPrefix() + "-" + i);
                } else {
                    product.setSku(productArr[i].getString("sku").toUpperCase());
                }
                //通过规格获取名称
                if (spec.contains("*") && spec.contains(":")) {
                    String[] str = StringUtils.split(spec, "*");
                    for (String temp : str) {
                        String[] s = StringUtils.split(temp, ":");
                        name += s[1] + " ";
                    }
                } else if (spec.contains(":")) {
                    String[] s = StringUtils.split(spec, ":");
                    name = s[1];
                }
                product.setName(name);
                product.setIsDefault(productArr[i].getBoolean("isDefault"));
                product.setDisabled(productArr[i].getBoolean("disabled"));
                product.setStock(NumberUtils.toInt(productArr[i].getString("stock"), 0));
                product.setBuyMin(NumberUtils.toInt(productArr[i].getString("buyMin"), 0));
                product.setBuyMax(NumberUtils.toInt(productArr[i].getString("buyMax"), 0));
                product.setWeight(NumberUtils.toInt(productArr[i].getString("weight"), 0));
                product.setPrice(StringUtil.yuanToFen(Strings.sNull(productArr[i].getString("price"))));
                product.setPriceMarket(StringUtil.yuanToFen(Strings.sNull(productArr[i].getString("priceMarket"))));
                shopGoodsProductsService.insert(product);
                //会员价
                NutMap[] lvPrice = productArr[i].getArray("lvprice", NutMap.class);
                if (lvPrice != null) {
                    for (int k = 0; k < lvPrice.length; k++) {
                        Shop_goods_lv_price lv = new Shop_goods_lv_price();
                        lv.setGoodsId(shopGoods.getId());
                        lv.setProductId(product.getId());
                        lv.setLvId(Strings.sNull(lvPrice[k].getString("lvId")));
                        lv.setLvPrice(StringUtil.yuanToFen(Strings.sNull(lvPrice[k].getString("lvPrice"))));
                        shopGoodsLvPriceService.insert(lv);
                    }
                }
            }
        }
        //商品相册
        NutMap[] imgArr = Json.fromJsonAsArray(NutMap.class, images);
        if (imgArr != null) {
            String defaultImge = "";
            for (int i = 0; i < imgArr.length; i++) {
                if (i == 0 || imgArr[i].getBoolean("d")) defaultImge = imgArr[i].getString("url");
                Shop_goods_images goodsImage = new Shop_goods_images();
                goodsImage.setGoodsId(shopGoods.getId());
                goodsImage.setLocation(i);
                goodsImage.setImgurl(Strings.sNull(imgArr[i].getString("url")));
                shopGoodsImagesService.insert(goodsImage);
            }
            this.update(Chain.make("imgurl", defaultImge), Cnd.where("id", "=", shopGoods.getId()));
        }
        //从redis删除缓存
        if (Globals.ShopRedisOn) {
            jedis().del(RDKEY_SHOP_GOODS + shopGoods.getId());
            jedis().del(RDKEY_SHOP_PRODUCT + shopGoods.getId());
        }
        return shopGoods.getId();
    }

    /**
     * 删除商品
     *
     * @param id
     */
    @Aop(TransAop.READ_COMMITTED)
    public void deleteProdcut(String id) {
        //删除商品会员价格信息
        shopGoodsLvPriceService.clear(Cnd.where("goodsId", "=", id));
        //删除商品相册信息
        shopGoodsImagesService.clear(Cnd.where("goodsId", "=", id));
        //删除商品货品信息
        shopGoodsProductsService.clear(Cnd.where("goodsId", "=", id));
        //清除标签关联表数据
        this.dao().clear("shop_goods_tag_link", Cnd.where("goodsId", "=", id));
        //从redis删除缓存
        if (Globals.ShopRedisOn) {
            jedis().del(RDKEY_SHOP_GOODS + id);
            jedis().del(RDKEY_SHOP_PRODUCT + id);
        }
        //删除商品
        this.delete(id);
    }

    /**
     * 删除规类型
     *
     * @param ids
     */
    @Aop(TransAop.READ_COMMITTED)
    public void deleteProdcut(String[] ids) {
        //删除商品会员价格信息
        shopGoodsLvPriceService.clear(Cnd.where("goodsId", "in", ids));
        //删除商品相册信息
        shopGoodsImagesService.clear(Cnd.where("goodsId", "in", ids));
        //删除商品货品信息
        shopGoodsProductsService.clear(Cnd.where("goodsId", "in", ids));
        //清除标签关联表数据
        this.dao().clear("shop_goods_tag_link", Cnd.where("goodsId", "in", ids));
        //删除缓存
        if (Globals.ShopRedisOn) {
            for (String id : ids) {
                //从redis删除缓存
                jedis().del(RDKEY_SHOP_GOODS + id);
                jedis().del(RDKEY_SHOP_PRODUCT + id);
            }
        }
        //删除商品
        this.delete(ids);
    }

    /**
     * 上下架货品
     *
     * @param goodsId
     * @param ids
     * @param uid
     */
    @Aop(TransAop.READ_COMMITTED)
    public void updown(String goodsId, String ids, String uid) {
        List<Shop_goods_products> list = shopGoodsProductsService.query(Cnd.where("goodsId", "=", goodsId).desc("location"));
        for (Shop_goods_products product : list) {
            if (!product.isDisabled() && !ids.contains(product.getId())) {
                //下架
                shopGoodsProductsService.update(Chain.make("disabled", true).add("downAt", (int) (System.currentTimeMillis() / 1000)).add("opAt", (int) (System.currentTimeMillis() / 1000)).add("opBy", uid), Cnd.where("id", "=", product.getId()));
            } else if (product.isDisabled() && ids.contains(product.getId())) {
                //上架
                shopGoodsProductsService.update(Chain.make("disabled", false).add("upAt", (int) (System.currentTimeMillis() / 1000)).add("opAt", (int) (System.currentTimeMillis() / 1000)).add("opBy", uid), Cnd.where("id", "=", product.getId()));
            }
        }
        int upNum = shopGoodsProductsService.count(Cnd.where("goodsId", "=", goodsId).and("disabled", "=", false));
        if (upNum == 0) {
            this.update(Chain.make("disabled", true).add("downAt", (int) (System.currentTimeMillis() / 1000)).add("opAt", (int) (System.currentTimeMillis() / 1000)).add("opBy", uid), Cnd.where("id", "=", goodsId));
        } else {
            this.update(Chain.make("disabled", false).add("upAt", (int) (System.currentTimeMillis() / 1000)).add("opAt", (int) (System.currentTimeMillis() / 1000)).add("opBy", uid), Cnd.where("id", "=", goodsId));
        }
    }

    /**
     * 批量上下架
     *
     * @param goodsIds
     * @param disabled
     * @param uid
     */
    @Aop(TransAop.READ_COMMITTED)
    public void updowns(String[] goodsIds, boolean disabled, String uid) {
        if (disabled) {
            this.update(Chain.make("disabled", true).add("downAt", (int) (System.currentTimeMillis() / 1000)).add("opAt", (int) (System.currentTimeMillis() / 1000)).add("opBy", uid), Cnd.where("id", "in", goodsIds));
            shopGoodsProductsService.update(Chain.make("disabled", true).add("downAt", (int) (System.currentTimeMillis() / 1000)).add("opAt", (int) (System.currentTimeMillis() / 1000)).add("opBy", uid), Cnd.where("goodsId", "in", goodsIds));
        } else {
            this.update(Chain.make("disabled", false).add("upAt", (int) (System.currentTimeMillis() / 1000)).add("opAt", (int) (System.currentTimeMillis() / 1000)).add("opBy", uid), Cnd.where("id", "in", goodsIds));
            shopGoodsProductsService.update(Chain.make("disabled", false).add("upAt", (int) (System.currentTimeMillis() / 1000)).add("opAt", (int) (System.currentTimeMillis() / 1000)).add("opBy", uid), Cnd.where("goodsId", "in", goodsIds));
        }
    }

    /*
   从redis里获取商品信息
    */
    @Aop("redis")
    public Shop_goods getGoodsById(String id) {
        if (Globals.ShopRedisOn) {
            if (jedis().exists(RDKEY_SHOP_GOODS + id)) {
                return Json.fromJson(Shop_goods.class, jedis().get(RDKEY_SHOP_GOODS + id));
            } else {
                Shop_goods goods = this.fetch(id);
                this.fetchLinks(goods, null, Cnd.orderBy().asc("location"));
                jedis().set(RDKEY_SHOP_GOODS + id, Json.toJson(goods));
                return goods;
            }
        } else {
            Shop_goods goods = this.fetch(id);
            this.fetchLinks(goods, null, Cnd.orderBy().asc("location"));
            return goods;
        }
    }

    /*
    从redis里获取缺省货品信息
     */
    @Aop("redis")
    public Shop_goods_products getDefaultProductById(String id) {
        if (Globals.ShopRedisOn) {
            if (jedis().exists(RDKEY_SHOP_PRODUCT + id)) {
                return Json.fromJson(Shop_goods_products.class, jedis().get(RDKEY_SHOP_PRODUCT + id));
            } else {
                Shop_goods_products product = shopGoodsProductsService.fetch(Cnd.where("goodsId", "=", id).and("isDefault", "=", true));
                jedis().set(RDKEY_SHOP_PRODUCT + id, Json.toJson(product));
                return product;
            }
        } else {
            return shopGoodsProductsService.fetch(Cnd.where("goodsId", "=", id).and("isDefault", "=", true));
        }
    }

    /**
     * 初始化注册事件
     */
    public void init() {
        pubSubService.reg("ps:goods:*", this);
    }

    /**
     * 监听事件
     *
     * @param channel
     * @param message
     */
    @Override
    public void onMessage(String channel, String message) {
        log.debugf("channel=%s, msg=%s", channel, message);
        switch (channel) {
            // TODO 数据库集群的delay会导致
            case "ps:goods:add":

                break;
            case "ps:goods:update":

                break;
            default:
                break;
        }
    }
}

