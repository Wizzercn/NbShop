package cn.wizzer.app.web.modules.controllers.front.pc;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * Created by wizzer on 2017/6/14.
 */
@IocBean
@At("/")
public class PcIndexController {

    @At(value={"/", "/index"}, top=true)
    @Ok("beetl:/public/pc/index/index.html")
    public void index() {

    }
}
