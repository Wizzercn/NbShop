package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_type_tab;
import cn.wizzer.app.goods.modules.services.GoodsTypeTabService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsTypeTabServiceImpl extends BaseServiceImpl<Goods_type_tab> implements GoodsTypeTabService {
    public GoodsTypeTabServiceImpl(Dao dao) {
        super(dao);
    }
}
