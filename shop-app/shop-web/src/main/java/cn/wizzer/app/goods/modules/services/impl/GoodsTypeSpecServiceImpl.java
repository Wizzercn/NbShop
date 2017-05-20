package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_type_spec;
import cn.wizzer.app.goods.modules.services.GoodsTypeSpecService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsTypeSpecServiceImpl extends BaseServiceImpl<Goods_type_spec> implements GoodsTypeSpecService {
    public GoodsTypeSpecServiceImpl(Dao dao) {
        super(dao);
    }
}
