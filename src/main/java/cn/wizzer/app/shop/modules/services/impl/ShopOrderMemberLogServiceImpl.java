package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_order_member_log;
import cn.wizzer.app.shop.modules.services.ShopOrderMemberLogService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopOrderMemberLogServiceImpl extends BaseServiceImpl<Shop_order_member_log> implements ShopOrderMemberLogService {
    public ShopOrderMemberLogServiceImpl(Dao dao) {
        super(dao);
    }
}
