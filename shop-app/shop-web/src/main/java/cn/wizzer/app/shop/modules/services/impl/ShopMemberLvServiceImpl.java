package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_member_lv;
import cn.wizzer.app.shop.modules.services.ShopMemberLvService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopMemberLvServiceImpl extends BaseServiceImpl<Shop_member_lv> implements ShopMemberLvService {
    public ShopMemberLvServiceImpl(Dao dao) {
        super(dao);
    }
}
