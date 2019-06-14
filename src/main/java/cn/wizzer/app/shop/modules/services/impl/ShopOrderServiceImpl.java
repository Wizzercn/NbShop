package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_order;
import cn.wizzer.app.shop.modules.services.ShopOrderService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopOrderServiceImpl extends BaseServiceImpl<Shop_order> implements ShopOrderService {
    public ShopOrderServiceImpl(Dao dao) {
        super(dao);
    }
}
