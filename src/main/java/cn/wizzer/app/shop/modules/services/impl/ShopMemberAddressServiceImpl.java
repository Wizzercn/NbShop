package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_member_address;
import cn.wizzer.app.shop.modules.services.ShopMemberAddressService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopMemberAddressServiceImpl extends BaseServiceImpl<Shop_member_address> implements ShopMemberAddressService {
    public ShopMemberAddressServiceImpl(Dao dao) {
        super(dao);
    }
}
