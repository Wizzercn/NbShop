package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_shipping;
import cn.wizzer.app.shop.modules.services.ShopShippingService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopShippingServiceImpl extends BaseServiceImpl<Shop_shipping> implements ShopShippingService {
    public ShopShippingServiceImpl(Dao dao) {
        super(dao);
    }
}
