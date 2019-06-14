package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_member_cart;
import cn.wizzer.app.shop.modules.services.ShopMemberCartService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopMemberCartServiceImpl extends BaseServiceImpl<Shop_member_cart> implements ShopMemberCartService {
    public ShopMemberCartServiceImpl(Dao dao) {
        super(dao);
    }
}
