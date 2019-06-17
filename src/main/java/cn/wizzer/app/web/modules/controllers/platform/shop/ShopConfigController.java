package cn.wizzer.app.web.modules.controllers.platform.shop;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * Created by wizzer on 2019/6/17
 */
@IocBean
@At("/platform/sys/shop/config")
public class ShopConfigController {
    private static final Log log = Logs.get();

    @At("")
    @Ok("beetl:/platform/shop/config/index.html")
    @RequiresPermissions("sys.shop.area")
    public void index() {

    }
}
