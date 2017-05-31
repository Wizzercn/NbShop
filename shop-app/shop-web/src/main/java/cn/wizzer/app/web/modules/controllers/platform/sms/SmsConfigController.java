package cn.wizzer.app.web.modules.controllers.platform.sms;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.sms.modules.models.Sms_config;
import cn.wizzer.app.sms.modules.services.SmsConfigService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/sms/config")
public class SmsConfigController{
    private static final Log log = Logs.get();
    @Inject
    private SmsConfigService smsConfigService;

    @At("")
    @Ok("beetl:/platform/sms/config/index.html")
    @RequiresPermissions("shop.sms.config")
    public void index(HttpServletRequest req) {
        req.setAttribute("obj", smsConfigService.fetch("alidayu"));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("shop.sms.config")
    @SLog(tag = "Sms_config", msg = "${args[0].id}")
    public Object editDo(@Param("..")Sms_config smsConfig, HttpServletRequest req) {
		try {
            smsConfig.setOpBy(StringUtil.getUid());
			smsConfig.setOpAt((int) (System.currentTimeMillis() / 1000));
			smsConfigService.updateIgnoreNull(smsConfig);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

}
