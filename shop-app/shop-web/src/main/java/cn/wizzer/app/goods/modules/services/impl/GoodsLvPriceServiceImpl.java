package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_lv_price;
import cn.wizzer.app.goods.modules.services.GoodsLvPriceService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsLvPriceServiceImpl extends BaseServiceImpl<Goods_lv_price> implements GoodsLvPriceService {
    public GoodsLvPriceServiceImpl(Dao dao) {
        super(dao);
    }
}
