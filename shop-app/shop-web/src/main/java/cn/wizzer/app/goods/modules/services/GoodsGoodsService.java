package cn.wizzer.app.goods.modules.services;

import cn.wizzer.app.goods.modules.models.Goods_goods;
import cn.wizzer.app.goods.modules.models.Goods_product;
import cn.wizzer.framework.base.service.BaseService;

public interface GoodsGoodsService extends BaseService<Goods_goods> {
    String add(Goods_goods shopGoods, String products, String spec_values, String prop_values, String param_values, String images);

    String save(Goods_goods shopGoods, String products, String spec_values, String prop_values, String param_values, String images, String uid);

    void deleteProdcut(String id);

    void deleteProdcut(String[] ids);

    void updown(String goodsId, String ids, String uid);

    void updowns(String[] goodsIds, boolean disabled, String uid);

    Goods_goods getGoodsById(String id);

    Goods_product getDefaultProductById(String id);
}
