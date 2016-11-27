package cn.wizzer.modules.controllers.platform.dec;

import cn.wizzer.common.annotation.SLog;
import cn.wizzer.common.base.Result;
import cn.wizzer.common.filter.PrivateFilter;
import cn.wizzer.common.page.DataTableColumn;
import cn.wizzer.common.page.DataTableOrder;
import cn.wizzer.modules.models.dec.Dec_template;
import cn.wizzer.modules.services.dec.DecTemplateService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/dec/template")
@Filters({@By(type = PrivateFilter.class)})
public class DecTemplateController {
    private static final Log log = Logs.get();
    @Inject
    private DecTemplateService decTemplateService;

    @At("/pc")
    @Ok("beetl:/platform/dec/template/pc/index.html")
    @RequiresAuthentication
    public Object index() {
        return decTemplateService.query(Cnd.orderBy().asc("location"));
    }

}
