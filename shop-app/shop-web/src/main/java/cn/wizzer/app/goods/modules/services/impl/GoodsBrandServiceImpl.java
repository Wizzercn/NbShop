package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_brand;
import cn.wizzer.app.goods.modules.services.GoodsBrandService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsBrandServiceImpl extends BaseServiceImpl<Goods_brand> implements GoodsBrandService {
    public GoodsBrandServiceImpl(Dao dao) {
        super(dao);
    }
}
