package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.member.modules.models.Member_bind;
import cn.wizzer.app.member.modules.services.MemberBindService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class MemberBindServiceImpl extends BaseServiceImpl<Member_bind> implements MemberBindService {
    public MemberBindServiceImpl(Dao dao) {
        super(dao);
    }
}
