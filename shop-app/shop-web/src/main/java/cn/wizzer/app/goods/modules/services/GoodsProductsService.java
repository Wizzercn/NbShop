package cn.wizzer.app.goods.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.goods.modules.models.Goods_products;

public interface GoodsProductsService extends BaseService<Goods_products>{
    String getSkuPrefix();
}
