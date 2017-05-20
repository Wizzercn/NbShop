package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.member.modules.models.Member_user_money;
import cn.wizzer.app.member.modules.services.MemberUserMoneyService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class MemberUserMoneyServiceImpl extends BaseServiceImpl<Member_user_money> implements MemberUserMoneyService {
    public MemberUserMoneyServiceImpl(Dao dao) {
        super(dao);
    }
}
