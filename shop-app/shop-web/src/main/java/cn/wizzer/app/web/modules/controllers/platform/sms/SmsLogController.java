package cn.wizzer.app.web.modules.controllers.platform.sms;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.sms.modules.models.Sms_log;
import cn.wizzer.app.sms.modules.services.SmsLogService;
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
@At("/platform/sms/log")
public class SmsLogController {
    private static final Log log = Logs.get();
    @Inject
    private SmsLogService smsLogService;

    @At("")
    @Ok("beetl:/platform/sms/log/index.html")
    @RequiresPermissions("shop.sms.log")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("shop.sms.log")
    public Object data(@Param("mobile") String mobile, @Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        if (Strings.isNotBlank(mobile)) {
            cnd.and("mobile", "like", "%" + mobile + "%");
        }
        return smsLogService.data(length, start, draw, order, columns, cnd, null);
    }

    @At
    @Ok("json")
    @RequiresPermissions("shop.sms.log.delete")
    @SLog(tag = "Sms_log", msg = "清除短信日志")
    public Object delete(HttpServletRequest req) {
        try {
            smsLogService.clear();
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }
}
