package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.goods.modules.models.Goods_type_props_values;
import cn.wizzer.app.goods.modules.services.GoodsTypePropsValuesService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsTypePropsValuesServiceImpl extends BaseServiceImpl<Goods_type_props_values> implements GoodsTypePropsValuesService {
    public GoodsTypePropsValuesServiceImpl(Dao dao) {
        super(dao);
    }
}
