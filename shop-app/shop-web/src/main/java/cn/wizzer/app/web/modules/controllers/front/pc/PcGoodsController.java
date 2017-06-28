package cn.wizzer.app.web.modules.controllers.front.pc;

import cn.wizzer.app.cms.modules.models.Cms_article;
import cn.wizzer.app.cms.modules.models.Cms_channel;
import cn.wizzer.app.cms.modules.services.CmsArticleService;
import cn.wizzer.app.cms.modules.services.CmsChannelService;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wizzer on 2017/6/21.
 */
@IocBean
@At("/shop/goods")
public class PcGoodsController {
    private final static Log log = Logs.get();
    @Inject
    private CmsChannelService cmsChannelService;
    @Inject
    private CmsArticleService cmsArticleService;

    @At("/new")
    @Ok("beetl:/public/pc/goods/new.html")
    public void channel(@Param(value = "sortName", df = "upAt,numSaleWeek") String sortName, @Param(value = "sortType", df = "desc") String sortType, @Param(value = "pageSize", df = "10") int pageSize, @Param(value = "pageNumber", df = "1") int pageNumber, HttpServletRequest req) {
        req.setAttribute("sortName", sortName);
        req.setAttribute("sortType", sortType);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("pageNumber", pageNumber);
    }

}
