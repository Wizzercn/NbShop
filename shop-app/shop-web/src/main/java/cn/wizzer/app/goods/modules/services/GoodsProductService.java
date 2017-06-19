package cn.wizzer.app.goods.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.goods.modules.models.Goods_product;
import org.nutz.lang.util.NutMap;

public interface GoodsProductService extends BaseService<Goods_product> {
    String getSkuPrefix();

    NutMap getPrice(String goodsId, String productId, String memberId);
}
