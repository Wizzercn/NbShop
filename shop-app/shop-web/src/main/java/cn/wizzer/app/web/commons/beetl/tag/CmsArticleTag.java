package cn.wizzer.app.web.commons.beetl.tag;

import cn.wizzer.app.cms.modules.services.CmsArticleService;
import cn.wizzer.framework.page.Pagination;
import org.apache.commons.lang3.math.NumberUtils;
import org.beetl.core.GeneralVarTagBinding;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;

/**
 * Created by wizzer on 2017/5/22.
 */
@IocBean
public class CmsArticleTag extends GeneralVarTagBinding {
    @Inject
    private CmsArticleService cmsArticleService;

    @Override
    public void render() {
        String id = Strings.sNull(this.getAttributeValue("id"));
        this.binds(cmsArticleService.fetch(Cnd.where("id", "=", id).and("disabled", "=", false)));
        this.doBodyRender();
    }
}
