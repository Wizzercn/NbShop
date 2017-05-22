package cn.wizzer.app.web.commons.beetl.tag;

import cn.wizzer.app.cms.modules.models.Cms_channel;
import cn.wizzer.app.cms.modules.services.CmsChannelService;
import org.beetl.core.GeneralVarTagBinding;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wizzer on 2017/5/22.
 */
@IocBean
public class CmsChannelTag extends GeneralVarTagBinding {
    @Inject
    private CmsChannelService cmsChannelService;

    @Override
    public void render() {
        String id = Strings.sNull(this.getAttributeValue("id"));
        Cms_channel channel = cmsChannelService.fetch(id);
        this.binds(channel);
        this.doBodyRender();
    }
}
