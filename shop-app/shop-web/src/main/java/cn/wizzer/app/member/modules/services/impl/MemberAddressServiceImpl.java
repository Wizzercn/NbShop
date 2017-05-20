package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.member.modules.models.Member_address;
import cn.wizzer.app.member.modules.services.MemberAddressService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class MemberAddressServiceImpl extends BaseServiceImpl<Member_address> implements MemberAddressService {
    public MemberAddressServiceImpl(Dao dao) {
        super(dao);
    }
}
