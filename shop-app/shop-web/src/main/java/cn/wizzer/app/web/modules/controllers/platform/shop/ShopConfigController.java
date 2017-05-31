package cn.wizzer.app.web.modules.controllers.platform.shop;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.shop.modules.models.Shop_config;
import cn.wizzer.app.shop.modules.services.ShopConfigService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/shop/config")
public class ShopConfigController {
    private static final Log log = Logs.get();
    @Inject
    private ShopConfigService shopConfigService;

    @At("")
    @Ok("beetl:/platform/shop/config/index.html")
    @RequiresPermissions("shop.config.config")
    public void index(HttpServletRequest req) {
        Shop_config config = shopConfigService.fetch("system");
        req.setAttribute("logistics_info", Json.fromJson(NutMap.class, Strings.sNull(config.getLogistics_info())));
        req.setAttribute("oauth_qq_info", Json.fromJson(NutMap.class, Strings.sNull(config.getOauth_qq_info())));
        req.setAttribute("oauth_wechat_info", Json.fromJson(NutMap.class, Strings.sNull(config.getOauth_wechat_info())));
        req.setAttribute("obj", config);
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("shop.config.config")
    @SLog(tag = "Shop_config", msg = "${args[0].id}")
    public Object editDo(@Param("..") Shop_config shopConfig, HttpServletRequest req) {
        try {
            shopConfig.setOpBy(StringUtil.getUid());
            shopConfig.setOpAt((int) (System.currentTimeMillis() / 1000));
            shopConfigService.updateIgnoreNull(shopConfig);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

}
