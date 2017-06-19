package cn.wizzer.app.member.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.member.modules.models.Member_user;
import org.nutz.dao.Cnd;

public interface MemberUserService extends BaseService<Member_user> {
    void money(String id, int money, String txt);

    void score(String id, int sorce, String txt);

    void coupon(String id, String couponId, String txt);

    Member_user getMember(Cnd cnd);

    void clearCache();
}
