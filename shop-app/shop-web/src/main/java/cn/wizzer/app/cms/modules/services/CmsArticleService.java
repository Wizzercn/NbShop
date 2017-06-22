package cn.wizzer.app.cms.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.cms.modules.models.Cms_article;
import cn.wizzer.framework.page.Pagination;
import org.nutz.dao.Condition;

public interface CmsArticleService extends BaseService<Cms_article> {
    Pagination getListPage(int pageNumber, int pageSize, Condition cnd);

    Cms_article getArticle(Condition cnd);

    void clearCache();
}
