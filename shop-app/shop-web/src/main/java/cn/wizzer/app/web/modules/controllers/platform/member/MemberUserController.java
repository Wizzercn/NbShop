package cn.wizzer.app.web.modules.controllers.platform.member;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.member.modules.models.Member_user;
import cn.wizzer.app.member.modules.services.MemberUserService;
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
@At("/platform/member/user")
public class MemberUserController{
    private static final Log log = Logs.get();
    @Inject
    private MemberUserService memberUserService;

    @At("")
    @Ok("beetl:/platform/member/user/index.html")
    @RequiresPermissions("platform.member.user")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("platform.member.user")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return memberUserService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/member/user/add.html")
    @RequiresPermissions("platform.member.user")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.member.user.add")
    @SLog(tag = "Member_user", msg = "${args[0].id}")
    public Object addDo(@Param("..")Member_user memberUser, HttpServletRequest req) {
		try {
			memberUserService.insert(memberUser);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/member/user/edit.html")
    @RequiresPermissions("platform.member.user")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", memberUserService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.member.user.edit")
    @SLog(tag = "Member_user", msg = "${args[0].id}")
    public Object editDo(@Param("..")Member_user memberUser, HttpServletRequest req) {
		try {
            memberUser.setOpBy(StringUtil.getUid());
			memberUser.setOpAt((int) (System.currentTimeMillis() / 1000));
			memberUserService.updateIgnoreNull(memberUser);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.member.user.delete")
    @SLog(tag = "Member_user", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				memberUserService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				memberUserService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/member/user/detail.html")
    @RequiresPermissions("platform.member.user")
	public void detail(String id, HttpServletRequest req) {
		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", memberUserService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }
    }

}
