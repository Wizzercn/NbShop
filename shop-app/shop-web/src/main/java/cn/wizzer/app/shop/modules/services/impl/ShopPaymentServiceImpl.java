package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_payment;
import cn.wizzer.app.shop.modules.services.ShopPaymentService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopPaymentServiceImpl extends BaseServiceImpl<Shop_payment> implements ShopPaymentService {
    public ShopPaymentServiceImpl(Dao dao) {
        super(dao);
    }
}
