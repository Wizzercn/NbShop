package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_order_pay_payment;
import cn.wizzer.app.shop.modules.services.ShopOrderPayPaymentService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopOrderPayPaymentServiceImpl extends BaseServiceImpl<Shop_order_pay_payment> implements ShopOrderPayPaymentService {
    public ShopOrderPayPaymentServiceImpl(Dao dao) {
        super(dao);
    }
}
