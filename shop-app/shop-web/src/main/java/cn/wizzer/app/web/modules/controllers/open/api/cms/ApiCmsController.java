package cn.wizzer.app.web.modules.controllers.open.api.cms;

import cn.wizzer.app.cms.modules.models.Cms_channel;
import cn.wizzer.app.cms.modules.services.CmsArticleService;
import cn.wizzer.app.cms.modules.services.CmsChannelService;
import cn.wizzer.app.web.commons.filter.TokenFilter;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.Pagination;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.*;

/**
 * Created by wizzer on 2016/8/11.
 */
@IocBean
@At("/open/api/cms")
@Filters({@By(type = TokenFilter.class)})
public class ApiCmsController {
    private static final Log log = Logs.get();
    @Inject
    private CmsArticleService cmsArticleService;
    @Inject
    private CmsChannelService cmsChannelService;

    @At("/list")
    @Ok("json")
    @AdaptBy(type = JsonAdaptor.class)
    @POST
    public Object list(@Param("..") NutMap params) {
        try {
            int pageSize = params.getInt("pageSize", 5);
            int pageNum = params.getInt("pageNum", 1);
            Cnd cnd = Cnd.NEW();
            Cms_channel channel = cmsChannelService.fetch(Cnd.where("name", "=", "首页"));
            if (channel != null) {
                cnd.and("channelId", "=", channel.getId());
            } else {
                cnd.and("1", "=", 2);
            }
            cnd.and("disabled", "=", false);
            cnd.desc("publishAt");
            Pagination pagination = cmsArticleService.listPage(pageNum, pageSize, cnd);
            return Result.success("ok", pagination);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return Result.error("fail");
        }
    }
}
