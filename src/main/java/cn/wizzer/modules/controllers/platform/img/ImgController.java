package cn.wizzer.modules.controllers.platform.img;

import cn.wizzer.common.filter.PrivateFilter;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wizzer on 2016/10/18.
 */
@IocBean
@At("/platform/img")
@Filters({@By(type = PrivateFilter.class)})
public class ImgController {
    private static final Log log = Logs.get();

    @At("/image")
    @Ok("beetl:/platform/img/image.html")
    @RequiresAuthentication
    public void index(@Param("w") int w, @Param("h") int h, HttpServletRequest req) {
        req.setAttribute("w", w);
        req.setAttribute("h",h);
    }
}
