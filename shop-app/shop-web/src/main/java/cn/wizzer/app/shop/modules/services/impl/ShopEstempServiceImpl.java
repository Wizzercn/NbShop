package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_estemp;
import cn.wizzer.app.shop.modules.services.ShopEstempService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopEstempServiceImpl extends BaseServiceImpl<Shop_estemp> implements ShopEstempService {
    public ShopEstempServiceImpl(Dao dao) {
        super(dao);
    }
}
