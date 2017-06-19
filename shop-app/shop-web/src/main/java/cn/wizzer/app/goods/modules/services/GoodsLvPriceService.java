package cn.wizzer.app.goods.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.goods.modules.models.Goods_lv_price;
import org.nutz.dao.Cnd;

public interface GoodsLvPriceService extends BaseService<Goods_lv_price> {
    Goods_lv_price getLvPrice(Cnd cnd);

    void clearCache();
}
