package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_member_level;
import cn.wizzer.app.shop.modules.services.ShopMemberLevelService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopMemberLevelServiceImpl extends BaseServiceImpl<Shop_member_level> implements ShopMemberLevelService {
    public ShopMemberLevelServiceImpl(Dao dao) {
        super(dao);
    }
}
