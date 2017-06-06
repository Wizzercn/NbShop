package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.member.modules.models.Member_coupon;
import cn.wizzer.app.member.modules.services.MemberCouponService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class MemberCouponServiceImpl extends BaseServiceImpl<Member_coupon> implements MemberCouponService {
    public MemberCouponServiceImpl(Dao dao) {
        super(dao);
    }
}
