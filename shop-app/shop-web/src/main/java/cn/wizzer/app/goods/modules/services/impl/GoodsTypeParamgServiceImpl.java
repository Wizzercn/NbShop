package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.goods.modules.models.Goods_type_paramg;
import cn.wizzer.app.goods.modules.services.GoodsTypeParamgService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsTypeParamgServiceImpl extends BaseServiceImpl<Goods_type_paramg> implements GoodsTypeParamgService {
    public GoodsTypeParamgServiceImpl(Dao dao) {
        super(dao);
    }
}
