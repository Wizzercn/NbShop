package cn.wizzer.app.shop.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.shop.modules.models.Shop_goods_class;

public interface ShopGoodsClassService extends BaseService<Shop_goods_class> {
    void save(Shop_goods_class goodsClass, String pid);

    void deleteAndChild(Shop_goods_class goodsClass);
}
