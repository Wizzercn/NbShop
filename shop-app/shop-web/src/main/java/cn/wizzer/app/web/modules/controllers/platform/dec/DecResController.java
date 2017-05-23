package cn.wizzer.app.web.modules.controllers.platform.dec;

import cn.wizzer.app.web.commons.base.Globals;
import cn.wizzer.framework.base.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
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
@At("/platform/dec/res")
public class DecResController {
    private static final Log log = Logs.get();

    @At("")
    @Ok("beetl:/platform/dec/res/index.html")
    @RequiresPermissions("dec.manger.res")
    public void index() {

    }

    @At("/tree")
    @Ok("json")
    @RequiresPermissions("dec.manger.res")
    public Object tree(@Param("path") String path) {
        List<Map<String, Object>> tree = new ArrayList<>();
        try {
            File f;
            if (Strings.isNotBlank(path)) {
                f = new File(Globals.AppRoot + path);
            } else {
                f = new File(Globals.AppRoot + "/assets/public/");
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

    @At("/load")
    @Ok("json")
    @RequiresPermissions("dec.manger.res")
    public Object load(@Param("path") String path) {
        try {
            String p = Globals.AppRoot.replaceAll("\\\\", "/") + path;
            File f = new File(p);
            NutMap map = NutMap.NEW();
            map.addv("filepath", path);
            map.addv("filename", f.getName());
            map.addv("filedata", Files.read(f));
            return Result.success("system.success", map);
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/save")
    @Ok("json")
    @RequiresPermissions("dec.manger.res")
    public Object save(@Param("filepath") String filepath, @Param("filedata") String filedata) {
        try {
            String p = Globals.AppRoot.replaceAll("\\\\", "/") + filepath;
            File f = new File(p);
            Files.write(f, filedata);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }
}
