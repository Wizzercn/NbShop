package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_logistics;
import cn.wizzer.app.shop.modules.services.ShopLogisticsService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopLogisticsServiceImpl extends BaseServiceImpl<Shop_logistics> implements ShopLogisticsService {
    public ShopLogisticsServiceImpl(Dao dao) {
        super(dao);
    }
}
