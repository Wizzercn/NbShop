package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_order_service;
import cn.wizzer.app.shop.modules.services.ShopOrderServiceService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopOrderServiceServiceImpl extends BaseServiceImpl<Shop_order_service> implements ShopOrderServiceService {
    public ShopOrderServiceServiceImpl(Dao dao) {
        super(dao);
    }
}
