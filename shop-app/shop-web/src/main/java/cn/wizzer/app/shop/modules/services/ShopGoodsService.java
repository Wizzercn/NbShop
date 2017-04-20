package cn.wizzer.app.shop.modules.services;

import cn.wizzer.app.shop.modules.models.Shop_goods_products;
import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.shop.modules.models.Shop_goods;

public interface ShopGoodsService extends BaseService<Shop_goods> {
    String add(Shop_goods shopGoods, String products, String spec_values, String prop_values, String param_values, String images);

    String save(Shop_goods shopGoods, String products, String spec_values, String prop_values, String param_values, String images, String uid);

    void deleteProdcut(String id);

    void deleteProdcut(String[] ids);

    void updown(String goodsId, String ids, String uid);

    void updowns(String[] goodsIds, boolean disabled, String uid);

    Shop_goods getGoodsById(String id);

    Shop_goods_products getDefaultProductById(String id);
}
