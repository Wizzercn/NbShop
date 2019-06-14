package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_sales_coupon;
import cn.wizzer.app.shop.modules.services.ShopSalesCouponService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopSalesCouponServiceImpl extends BaseServiceImpl<Shop_sales_coupon> implements ShopSalesCouponService {
    public ShopSalesCouponServiceImpl(Dao dao) {
        super(dao);
    }

}
