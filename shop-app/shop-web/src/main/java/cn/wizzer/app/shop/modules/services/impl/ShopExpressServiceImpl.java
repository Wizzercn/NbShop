package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_express;
import cn.wizzer.app.shop.modules.services.ShopExpressService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopExpressServiceImpl extends BaseServiceImpl<Shop_express> implements ShopExpressService {
    public ShopExpressServiceImpl(Dao dao) {
        super(dao);
    }
}
