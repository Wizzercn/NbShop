package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_order_admin_log;
import cn.wizzer.app.shop.modules.services.ShopOrderAdminLogService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopOrderAdminLogServiceImpl extends BaseServiceImpl<Shop_order_admin_log> implements ShopOrderAdminLogService {
    public ShopOrderAdminLogServiceImpl(Dao dao) {
        super(dao);
    }
}
