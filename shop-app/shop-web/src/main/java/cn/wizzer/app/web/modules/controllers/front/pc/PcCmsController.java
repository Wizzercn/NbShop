package cn.wizzer.app.web.modules.controllers.front.pc;

import cn.wizzer.app.cms.modules.models.Cms_channel;
import cn.wizzer.app.cms.modules.services.CmsChannelService;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wizzer on 2017/6/21.
 */
@IocBean
@At("/cms")
public class PcCmsController {
    @Inject
    private CmsChannelService cmsChannelService;

    @At("/channel/?")
    @Ok("beetl:/public/pc/cms/channel.html")
    public void channel(String code, HttpServletRequest req) {
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
        req.setAttribute("channelId", channelId);
        req.setAttribute("channelCode", code);
        req.setAttribute("channelName", channelName);
        req.setAttribute("pchannelId", pchannelId);
        req.setAttribute("pchannelName", pchannelName);
    }
}
