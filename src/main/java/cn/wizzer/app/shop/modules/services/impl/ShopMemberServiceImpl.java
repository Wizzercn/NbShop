package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_member;
import cn.wizzer.app.shop.modules.services.ShopMemberService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopMemberServiceImpl extends BaseServiceImpl<Shop_member> implements ShopMemberService {
    public ShopMemberServiceImpl(Dao dao) {
        super(dao);
    }
}
