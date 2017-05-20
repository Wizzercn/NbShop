package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.member.modules.models.Member_cart;
import cn.wizzer.app.member.modules.services.MemberCartService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class MemberCartServiceImpl extends BaseServiceImpl<Member_cart> implements MemberCartService {
    public MemberCartServiceImpl(Dao dao) {
        super(dao);
    }
}
