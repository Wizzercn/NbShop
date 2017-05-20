package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.goods.modules.models.Goods_type_params;
import cn.wizzer.app.goods.modules.services.GoodsTypeParamsService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsTypeParamsServiceImpl extends BaseServiceImpl<Goods_type_params> implements GoodsTypeParamsService {
    public GoodsTypeParamsServiceImpl(Dao dao) {
        super(dao);
    }
}
