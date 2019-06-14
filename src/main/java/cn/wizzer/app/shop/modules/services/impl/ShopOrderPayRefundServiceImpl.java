package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_order_pay_refund;
import cn.wizzer.app.shop.modules.services.ShopOrderPayRefundService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopOrderPayRefundServiceImpl extends BaseServiceImpl<Shop_order_pay_refund> implements ShopOrderPayRefundService {
    public ShopOrderPayRefundServiceImpl(Dao dao) {
        super(dao);
    }
}
