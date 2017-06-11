package cn.wizzer.app.web.modules.controllers.platform.member;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.app.member.modules.models.Member_level;
import cn.wizzer.app.member.modules.services.MemberLevelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.lang.Strings;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.adaptor.WhaleAdaptor;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/member/level")
public class MemberLevelController {
    @Inject
    private MemberLevelService memberLevelService;

    @At("")
    @Ok("beetl:/platform/member/level/index.html")
    @RequiresPermissions("member.config.level")
    public void index() {

    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("member.config.level")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        return memberLevelService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/member/level/add.html")
    @RequiresPermissions("member.config.level")
    public void add(HttpServletRequest req) {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("member.config.level.add")
    @SLog(tag = "Member_level", msg = "${args[0].id}")
    @AdaptBy(type = WhaleAdaptor.class)
    public Object addDo(@Param("..") Member_level memberLevel, HttpServletRequest req) {
        try {
            memberLevelService.add(memberLevel);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/edit/?")
    @Ok("beetl:/platform/member/level/edit.html")
    @RequiresPermissions("member.config.level")
    public void edit(String id, HttpServletRequest req) {
        req.setAttribute("obj", memberLevelService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("member.config.level.edit")
    @SLog(tag = "Member_level", msg = "${args[0].id}")
    @AdaptBy(type = WhaleAdaptor.class)
    public Object editDo(@Param("..") Member_level memberLevel, HttpServletRequest req) {
        try {
            memberLevelService.edit(memberLevel);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("member.config.level.delete")
    @SLog(tag = "Member_level", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids, HttpServletRequest req) {
        try {
            if (ids != null && ids.length > 0) {
                memberLevelService.delete(ids);
                req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
            } else {
                memberLevelService.delete(id);
                req.setAttribute("id", id);
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/member/level/detail.html")
    @RequiresPermissions("member.config.level")
    public void detail(String id, HttpServletRequest req) {
        if (!Strings.isBlank(id)) {
            req.setAttribute("obj", memberLevelService.fetch(id));
        } else {
            req.setAttribute("obj", null);
        }
    }

}
