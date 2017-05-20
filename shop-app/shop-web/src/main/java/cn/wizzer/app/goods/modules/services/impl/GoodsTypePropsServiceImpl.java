package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.goods.modules.models.Goods_type_props;
import cn.wizzer.app.goods.modules.services.GoodsTypePropsService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsTypePropsServiceImpl extends BaseServiceImpl<Goods_type_props> implements GoodsTypePropsService {
    public GoodsTypePropsServiceImpl(Dao dao) {
        super(dao);
    }
}
