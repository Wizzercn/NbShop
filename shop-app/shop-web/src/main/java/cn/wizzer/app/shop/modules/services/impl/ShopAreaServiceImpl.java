package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_area;
import cn.wizzer.app.shop.modules.services.ShopAreaService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopAreaServiceImpl extends BaseServiceImpl<Shop_area> implements ShopAreaService {
    public ShopAreaServiceImpl(Dao dao) {
        super(dao);
    }
}
