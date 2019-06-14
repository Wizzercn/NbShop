package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_sales_coupon_log;
import cn.wizzer.app.shop.modules.services.ShopSalesCouponLogService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopSalesCouponLogServiceImpl extends BaseServiceImpl<Shop_sales_coupon_log> implements ShopSalesCouponLogService {
    public ShopSalesCouponLogServiceImpl(Dao dao) {
        super(dao);
    }

}
