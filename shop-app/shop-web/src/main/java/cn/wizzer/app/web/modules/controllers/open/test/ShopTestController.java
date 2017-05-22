package cn.wizzer.app.web.modules.controllers.open.test;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * Created by wizzer on 2017/5/22.
 */
@IocBean
@At("/test")
public class ShopTestController {
    private static final Log log = Logs.get();
    @At("/tag")
    @Ok("beetl:/test/tag.html")
    public void tag(){
    }
}
