package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.app.member.modules.models.Member_level;
import cn.wizzer.app.member.modules.services.MemberLevelService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2017/4/20.
 */
@IocBean(args = {"refer:dao"})
public class MemberLevelServiceImpl extends BaseServiceImpl<Member_level> implements MemberLevelService {
    public MemberLevelServiceImpl(Dao dao) {
        super(dao);
    }
}

