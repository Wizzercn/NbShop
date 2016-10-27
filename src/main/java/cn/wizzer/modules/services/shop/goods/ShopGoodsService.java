package cn.wizzer.modules.services.shop.goods;

import cn.wizzer.common.base.Service;
import cn.wizzer.common.util.StringUtil;
import cn.wizzer.modules.models.shop.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Index;
import org.nutz.dao.entity.annotation.TableIndexes;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.Date;

@IocBean(args = {"refer:dao"})
public class ShopGoodsService extends Service<Shop_goods> {
    @Inject
    private ShopGoodsProductsService shopGoodsProductsService;
    @Inject
    private ShopMemberLvService shopMemberLvService;
    @Inject
    private ShopGoodsLvPriceService shopGoodsLvPriceService;
    @Inject
    private ShopGoodsImagesService shopGoodsImagesService;
    private static final Log log = Logs.get();

    public ShopGoodsService(Dao dao) {
        super(dao);
    }

    /**
     * 添加商品
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
                    product.setSku(productArr[i].getString("sku"));
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
        return shopGoods.getId();
    }

}

