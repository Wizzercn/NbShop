package cn.wizzer.app.member.modules.services;

import cn.wizzer.app.member.modules.models.Member_level;
import cn.wizzer.framework.base.service.BaseService;
import org.nutz.dao.Cnd;

/**
 * Created by wizzer on 2017/4/20.
 */
public interface MemberLevelService extends BaseService<Member_level> {
    void add(Member_level level);

    void edit(Member_level level);

    Member_level getLevel(Cnd cnd);

    void clearCache();
}
