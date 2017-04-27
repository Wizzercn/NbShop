package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.member.modules.models.Member_type;
import cn.wizzer.app.member.modules.services.MemberTypeService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class MemberTypeServiceImpl extends BaseServiceImpl<Member_type> implements MemberTypeService {
    public MemberTypeServiceImpl(Dao dao) {
        super(dao);
    }
}
