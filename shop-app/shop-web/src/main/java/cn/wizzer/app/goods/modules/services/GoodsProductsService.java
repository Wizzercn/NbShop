package cn.wizzer.app.goods.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.goods.modules.models.Goods_product;

public interface GoodsProductsService extends BaseService<Goods_product>{
    String getSkuPrefix();
}
