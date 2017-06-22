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
@At("/cms")
public class PcCmsController {
    private final static Log log = Logs.get();
    @Inject
    private CmsChannelService cmsChannelService;
    @Inject
    private CmsArticleService cmsArticleService;

    @At("/channel/?")
    @Ok("beetl:/public/pc/cms/channel.html")
    public void channel(String code, @Param(value = "pageSize", df = "10") int pageSize, @Param(value = "pageNumber", df = "1") int pageNumber, HttpServletRequest req) {
        String channelId = "", channelName = "", pchannelId = "", pchannelName = "";
        Cms_channel cmsChannel = cmsChannelService.getChannel("", code);
        if (cmsChannel != null) {
            channelName = cmsChannel.getName();
            channelId = cmsChannel.getId();
            Cms_channel pcmsChannel = cmsChannelService.getChannel(cmsChannel.getParentId(), "");
            if (pcmsChannel != null) {
                pchannelId = pcmsChannel.getId();
                pchannelName = pcmsChannel.getName();
            }
        }
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("pageNumber", pageNumber);
        req.setAttribute("channelId", channelId);
        req.setAttribute("channelCode", code);
        req.setAttribute("channelName", channelName);
        req.setAttribute("pchannelId", pchannelId);
        req.setAttribute("pchannelName", pchannelName);
    }

    @At("/article/?")
    @Ok("beetl:/public/pc/cms/article.html")
    public void article(String id, HttpServletRequest req) {
        String channelId = "", channelCode = "", channelName = "", pchannelId = "", pchannelName = "";
        Cms_article article = cmsArticleService.getArticle(Cnd.where("id", "=", id));
        if (article != null) {
            channelId = article.getChannelId();
        }
        Cms_channel cmsChannel = cmsChannelService.getChannel(channelId, "");
        if (cmsChannel != null) {
            channelName = cmsChannel.getName();
            channelId = cmsChannel.getId();
            channelCode = cmsChannel.getCode();
            Cms_channel pcmsChannel = cmsChannelService.getChannel(cmsChannel.getParentId(), "");
            if (pcmsChannel != null) {
                pchannelId = pcmsChannel.getId();
                pchannelName = pcmsChannel.getName();
            }
        }
        req.setAttribute("channelId", channelId);
        req.setAttribute("channelCode", channelCode);
        req.setAttribute("channelName", channelName);
        req.setAttribute("pchannelId", pchannelId);
        req.setAttribute("pchannelName", pchannelName);
        req.setAttribute("obj", article);
    }
}
