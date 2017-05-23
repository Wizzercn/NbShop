package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.services.ShopConfigService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_config;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopConfigServiceImpl extends BaseServiceImpl<Shop_config> implements ShopConfigService {
    public ShopConfigServiceImpl(Dao dao) {
        super(dao);
    }
}
