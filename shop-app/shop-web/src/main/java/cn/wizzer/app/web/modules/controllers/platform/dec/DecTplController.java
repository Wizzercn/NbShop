package cn.wizzer.app.web.modules.controllers.platform.dec;

import cn.wizzer.app.sys.modules.models.Sys_unit;
import cn.wizzer.app.web.commons.base.Globals;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wizzer on 2017/5/22.
 */
@IocBean
@At("/platform/dec/tpl")
public class DecTplController {
    private static final Log log = Logs.get();

    @At("")
    @Ok("beetl:/platform/dec/index.html")
    @RequiresPermissions("dec.manger.tpl")
    public void index() {

    }

    @At("/tree")
    @Ok("json")
    @RequiresPermissions("dec.manger.tpl")
    public Object tree(@Param("path") String path) {
        List<Map<String, Object>> tree = new ArrayList<>();
        try {
            File f;
            if (Strings.isNotBlank(path)) {
                f = new File(Globals.AppRoot + path);
            } else {
                f = new File(Globals.AppRoot + "/WEB-INF/views/public/shop/pc");
            }
            File[] files = Files.lsAll(f, null);
            Map<String, Object> obj;
            log.debug("files::" + Json.toJson(files));
            log.debug("Globals.AppRoot::" + Globals.AppRoot);
            if (files != null)
                for (File file : files) {
                    obj = new HashMap<>();
                    obj.put("id", file.getPath().replaceAll("\\\\", "/").replace(Globals.AppRoot.replaceAll("\\\\", "/"), ""));
                    obj.put("text", file.getName());
                    if (Files.isDirectory(file)) {
                        obj.put("children", true);

                    } else {
                        obj.put("children", file);
                        obj.put("icon", "jstree-file");
                    }
                    tree.add(obj);
                }
        } catch (Exception e) {
            log.error(e);
        }
        return tree;
    }
}
