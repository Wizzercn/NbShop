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
public class CmsChannelListTag extends GeneralVarTagBinding {
    @Inject
    private CmsChannelService cmsChannelService;

    @Override
    public void render() {
        String parentId = Strings.sNull(this.getAttributeValue("parentId"));
        String parentName = Strings.sNull(this.getAttributeValue("parentName"));
        List<Cms_channel> list = new ArrayList<>();
        if (Strings.isNotBlank(parentName)) {
            Cms_channel channel = cmsChannelService.fetch(Cnd.where("name", "=", parentName));
            if (channel != null)
                list = cmsChannelService.query(Cnd.where("parentId", "=", channel.getId()).and("disabled", "=", false).asc("location"));
        } else {
            list = cmsChannelService.query(Cnd.where("parentId", "=", parentId).and("disabled", "=", false).asc("location"));
        }
        for (Cms_channel channel : list) {
            this.binds(channel);
            this.doBodyRender();
        }
    }
}
