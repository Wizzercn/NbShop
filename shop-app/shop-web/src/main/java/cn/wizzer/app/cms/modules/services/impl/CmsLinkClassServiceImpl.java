package cn.wizzer.app.cms.modules.services.impl;

import cn.wizzer.app.cms.modules.services.CmsLinkService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.cms.modules.models.Cms_link_class;
import cn.wizzer.app.cms.modules.services.CmsLinkClassService;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class CmsLinkClassServiceImpl extends BaseServiceImpl<Cms_link_class> implements CmsLinkClassService {
    public CmsLinkClassServiceImpl(Dao dao) {
        super(dao);
    }

    @Inject
    private CmsLinkService cmsLinkService;

    @Aop(TransAop.READ_COMMITTED)
    public void deleteAndLink(String id) {
        cmsLinkService.clear(Cnd.where("classId", "=", id));
        cmsLinkService.clearCache();//删除分类时清除链接缓存
        this.delete(id);
    }
}
