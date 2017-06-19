package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.app.member.modules.models.Member_level;
import cn.wizzer.app.member.modules.services.MemberLevelService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.framework.util.StringUtil;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.plugins.wkcache.annotation.CacheDefaults;
import org.nutz.plugins.wkcache.annotation.CacheRemoveAll;
import org.nutz.plugins.wkcache.annotation.CacheResult;

/**
 * Created by wizzer on 2017/4/20.
 */
@IocBean(args = {"refer:dao"})
@CacheDefaults(cacheName = "member_level")
public class MemberLevelServiceImpl extends BaseServiceImpl<Member_level> implements MemberLevelService {
    public MemberLevelServiceImpl(Dao dao) {
        super(dao);
    }

    @Aop(TransAop.READ_COMMITTED)
    public void add(Member_level level) {
        if (level.isDefaultValue()) {
            this.update(Chain.make("defaultValue", false), Cnd.NEW());
        }
        this.insert(level);
    }

    @Aop(TransAop.READ_COMMITTED)
    public void edit(Member_level level) {
        level.setOpBy(StringUtil.getUid());
        level.setOpAt((int) (System.currentTimeMillis() / 1000));
        if (level.isDefaultValue()) {
            this.update(Chain.make("defaultValue", false), Cnd.NEW());
        }
        this.updateIgnoreNull(level);
    }

    @CacheResult
    public Member_level getLevel(Cnd cnd) {
        return this.fetch(cnd);
    }

    @CacheRemoveAll
    public void clearCache() {

    }
}

