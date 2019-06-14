package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_area;
import cn.wizzer.app.shop.modules.services.ShopAreaService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopAreaServiceImpl extends BaseServiceImpl<Shop_area> implements ShopAreaService {
    public ShopAreaServiceImpl(Dao dao) {
        super(dao);
    }

}
