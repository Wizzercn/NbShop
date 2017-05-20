package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.member.modules.models.Member_user_score;
import cn.wizzer.app.member.modules.services.MemberUserScoreService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class MemberUserScoreServiceImpl extends BaseServiceImpl<Member_user_score> implements MemberUserScoreService {
    public MemberUserScoreServiceImpl(Dao dao) {
        super(dao);
    }
}
