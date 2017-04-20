package cn.wizzer.app.shop.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.shop.modules.models.Shop_goods_products;

public interface ShopGoodsProductsService extends BaseService<Shop_goods_products>{
    String getSkuPrefix();
}
