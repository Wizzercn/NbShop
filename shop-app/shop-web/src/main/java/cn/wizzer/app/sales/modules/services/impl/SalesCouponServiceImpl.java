package cn.wizzer.app.sales.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.sales.modules.models.Sales_coupon;
import cn.wizzer.app.sales.modules.services.SalesCouponService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class SalesCouponServiceImpl extends BaseServiceImpl<Sales_coupon> implements SalesCouponService {
    public SalesCouponServiceImpl(Dao dao) {
        super(dao);
    }
}
