package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_payment;
import cn.wizzer.app.shop.modules.services.ShopPaymentService;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopPaymentServiceImpl extends BaseServiceImpl<Shop_payment> implements ShopPaymentService {
    public ShopPaymentServiceImpl(Dao dao) {
        super(dao);
    }

    @Aop(TransAop.READ_COMMITTED)
    public void setDefault(String id) {
        this.update(Chain.make("defaultValue", false), Cnd.NEW());
        this.update(Chain.make("defaultValue", true), Cnd.where("id", "=", id));
    }
}
