package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_lv_price;
import cn.wizzer.app.goods.modules.services.GoodsLvPriceService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.plugins.wkcache.annotation.CacheDefaults;
import org.nutz.plugins.wkcache.annotation.CacheRemoveAll;
import org.nutz.plugins.wkcache.annotation.CacheResult;

@IocBean(args = {"refer:dao"})
@CacheDefaults(cacheName = "goods_lv_price")
public class GoodsLvPriceServiceImpl extends BaseServiceImpl<Goods_lv_price> implements GoodsLvPriceService {
    public GoodsLvPriceServiceImpl(Dao dao) {
        super(dao);
    }

    @CacheResult
    public Goods_lv_price getLvPrice(Cnd cnd) {
        return this.fetch(cnd);
    }

    @CacheRemoveAll
    public void clearCache() {

    }
}
