package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_goods;
import cn.wizzer.app.goods.modules.models.Goods_images;
import cn.wizzer.app.goods.modules.models.Goods_lv_price;
import cn.wizzer.app.goods.modules.services.GoodsImagesService;
import cn.wizzer.app.goods.modules.services.GoodsLvPriceService;
import cn.wizzer.app.goods.modules.services.GoodsProductService;
import cn.wizzer.app.goods.modules.services.GoodsGoodsService;
import cn.wizzer.app.member.modules.services.MemberLevelService;
import cn.wizzer.app.goods.modules.models.Goods_product;
import cn.wizzer.app.shop.modules.models.Shop_estemp;
import cn.wizzer.app.shop.modules.services.ShopEstempService;
import cn.wizzer.app.web.commons.ext.es.EsService;
import cn.wizzer.app.web.commons.utils.MoneyUtil;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.framework.page.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.integration.jedis.pubsub.PubSubService;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.ArrayList;
import java.util.List;

@IocBean(args = {"refer:dao"})
public class GoodsGoodsServiceImpl extends BaseServiceImpl<Goods_goods> implements GoodsGoodsService {
    public GoodsGoodsServiceImpl(Dao dao) {
        super(dao);
    }

    private static final Log log = Logs.get();
    @Inject
    private GoodsProductService shopGoodsProductsService;
    @Inject
    private MemberLevelService memberLevelService;
    @Inject
    private GoodsLvPriceService shopGoodsLvPriceService;
    @Inject
    private GoodsImagesService shopGoodsImagesService;
    @Inject
    private PubSubService pubSubService;
    @Inject
    private ShopEstempService shopEstempService;
    @Inject
    private EsService esService;

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
    public String add(Goods_goods shopGoods, String products, String spec_values, String prop_values, String param_values, String images) {
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
                Goods_product product = new Goods_product();
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
                product.setPrice(MoneyUtil.yuanToFen(Strings.sNull(productArr[i].getString("price"))));
                product.setPriceMarket(MoneyUtil.yuanToFen(Strings.sNull(productArr[i].getString("priceMarket"))));
                shopGoodsProductsService.insert(product);
                //会员价
                NutMap[] lvPrice = productArr[i].getArray("lvprice", NutMap.class);
                if (lvPrice != null) {
                    for (int k = 0; k < lvPrice.length; k++) {
                        Goods_lv_price lv = new Goods_lv_price();
                        lv.setGoodsId(shopGoods.getId());
                        lv.setProductId(product.getId());
                        lv.setLvId(Strings.sNull(lvPrice[k].getString("lvId")));
                        lv.setLvPrice(MoneyUtil.yuanToFen(Strings.sNull(lvPrice[k].getString("lvPrice"))));
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
                Goods_images goodsImage = new Goods_images();
                goodsImage.setGoodsId(shopGoods.getId());
                goodsImage.setLocation(i);
                goodsImage.setImgurl(Strings.sNull(imgArr[i].getString("url")));
                shopGoodsImagesService.insert(goodsImage);
            }
            this.update(Chain.make("imgurl", defaultImge), Cnd.where("id", "=", shopGoods.getId()));
        }
        Shop_estemp estemp = new Shop_estemp();
        estemp.setAction("create");
        estemp.setGoodsId(shopGoods.getId());
        shopEstempService.insert(estemp);
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
    public String save(Goods_goods shopGoods, String products, String spec_values, String prop_values, String param_values, String images, String uid) {
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
                Goods_product product = new Goods_product();
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
                product.setPrice(MoneyUtil.yuanToFen(Strings.sNull(productArr[i].getString("price"))));
                product.setPriceMarket(MoneyUtil.yuanToFen(Strings.sNull(productArr[i].getString("priceMarket"))));
                shopGoodsProductsService.insert(product);
                //会员价
                NutMap[] lvPrice = productArr[i].getArray("lvprice", NutMap.class);
                if (lvPrice != null) {
                    for (int k = 0; k < lvPrice.length; k++) {
                        Goods_lv_price lv = new Goods_lv_price();
                        lv.setGoodsId(shopGoods.getId());
                        lv.setProductId(product.getId());
                        lv.setLvId(Strings.sNull(lvPrice[k].getString("lvId")));
                        lv.setLvPrice(MoneyUtil.yuanToFen(Strings.sNull(lvPrice[k].getString("lvPrice"))));
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
                Goods_images goodsImage = new Goods_images();
                goodsImage.setGoodsId(shopGoods.getId());
                goodsImage.setLocation(i);
                goodsImage.setImgurl(Strings.sNull(imgArr[i].getString("url")));
                shopGoodsImagesService.insert(goodsImage);
            }
            this.update(Chain.make("imgurl", defaultImge), Cnd.where("id", "=", shopGoods.getId()));
        }
        Shop_estemp estemp = new Shop_estemp();
        estemp.setAction("update");
        estemp.setGoodsId(shopGoods.getId());
        shopEstempService.insert(estemp);
        shopGoodsLvPriceService.clearCache();
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
        shopGoodsLvPriceService.update(Chain.make("delFlag", true), Cnd.where("goodsId", "=", id));
        //删除商品相册信息
        shopGoodsImagesService.update(Chain.make("delFlag", true), Cnd.where("goodsId", "=", id));
        //删除商品货品信息
        shopGoodsProductsService.update(Chain.make("delFlag", true), Cnd.where("goodsId", "=", id));
        //清除标签关联表数据
        this.dao().clear("goods_tag_link", Cnd.where("goodsId", "=", id));
        //删除商品
        this.vDelete(id);
        Shop_estemp estemp = new Shop_estemp();
        estemp.setAction("delete");
        estemp.setGoodsId(id);
        shopEstempService.insert(estemp);
        shopGoodsLvPriceService.clearCache();
    }

    /**
     * 删除规类型
     *
     * @param ids
     */
    @Aop(TransAop.READ_COMMITTED)
    public void deleteProdcut(String[] ids) {
        //删除商品会员价格信息
        shopGoodsLvPriceService.update(Chain.make("delFlag", true), Cnd.where("goodsId", "in", ids));
        //删除商品相册信息
        shopGoodsImagesService.update(Chain.make("delFlag", true), Cnd.where("goodsId", "in", ids));
        //删除商品货品信息
        shopGoodsProductsService.update(Chain.make("delFlag", true), Cnd.where("goodsId", "in", ids));
        //清除标签关联表数据
        this.dao().clear("goods_tag_link", Cnd.where("goodsId", "in", ids));
        //删除商品
        this.vDelete(ids);
        for (String id : ids) {
            Shop_estemp estemp = new Shop_estemp();
            estemp.setAction("delete");
            estemp.setGoodsId(id);
            shopEstempService.insert(estemp);
        }
        shopGoodsLvPriceService.clearCache();
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
        List<Goods_product> list = shopGoodsProductsService.query(Cnd.where("goodsId", "=", goodsId).desc("location"));
        for (Goods_product product : list) {
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
        Shop_estemp estemp = new Shop_estemp();
        estemp.setAction("update");
        estemp.setGoodsId(goodsId);
        shopEstempService.insert(estemp);
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
        for (String id : goodsIds) {
            Shop_estemp estemp = new Shop_estemp();
            estemp.setAction("update");
            estemp.setGoodsId(id);
            shopEstempService.insert(estemp);
        }
    }

    /*
   从redis里获取商品信息
    */
    public Goods_goods getGoodsById(String id) {
        Goods_goods goods = this.fetch(id);
        this.fetchLinks(goods, null, Cnd.orderBy().asc("location"));
        return goods;
    }

    /*
    从redis里获取缺省货品信息
     */
    public Goods_product getDefaultProductById(String id) {

        return shopGoodsProductsService.fetch(Cnd.where("goodsId", "=", id).and("isDefault", "=", true));

    }

    public Pagination essearch(int pageNumber, int pageSize, String keyword) {
        List<NutMap> list = new ArrayList<>();
        Pagination pagination = new Pagination();
        pagination.setPageNo(pageNumber);
        pagination.setPageSize(pageSize);
        pagination.setList(list);
        esService.getClient();
        return pagination;
    }
}
