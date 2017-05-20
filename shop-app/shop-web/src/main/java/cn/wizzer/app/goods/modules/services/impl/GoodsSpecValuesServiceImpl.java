package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_spec_values;
import cn.wizzer.app.goods.modules.services.GoodsSpecValuesService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsSpecValuesServiceImpl extends BaseServiceImpl<Goods_spec_values> implements GoodsSpecValuesService {
    public GoodsSpecValuesServiceImpl(Dao dao) {
        super(dao);
    }
}
