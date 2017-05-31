package cn.wizzer.app.web.modules.controllers.open.test;

import cn.wizzer.app.sms.commons.service.SmsService;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
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
    @Inject
    private SmsService smsService;

    @At("/tag")
    @Ok("beetl:/test/tag.html")
    public void tag() {
    }

    @At("/sms")
    @Ok("json")
    public Object sms() {
        return smsService.send("SMS_69305052", "13359011952", NutMap.NEW().addv("code", "12345").addv("product", "NutzShop"));
    }
}
