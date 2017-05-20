package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.member.modules.models.Member_user;
import cn.wizzer.app.member.modules.services.MemberUserService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class MemberUserServiceImpl extends BaseServiceImpl<Member_user> implements MemberUserService {
    public MemberUserServiceImpl(Dao dao) {
        super(dao);
    }
}
