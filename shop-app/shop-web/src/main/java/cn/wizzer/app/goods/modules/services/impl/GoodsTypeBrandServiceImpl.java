package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_type_brand;
import cn.wizzer.app.goods.modules.services.GoodsTypeBrandService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsTypeBrandServiceImpl extends BaseServiceImpl<Goods_type_brand> implements GoodsTypeBrandService {
    public GoodsTypeBrandServiceImpl(Dao dao) {
        super(dao);
    }
}
