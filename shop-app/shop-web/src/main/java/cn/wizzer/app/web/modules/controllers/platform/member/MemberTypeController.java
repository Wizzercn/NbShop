package cn.wizzer.app.web.modules.controllers.platform.member;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.member.modules.models.Member_type;
import cn.wizzer.app.member.modules.services.MemberTypeService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.lang.Strings;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/member/type")
public class MemberTypeController{
    @Inject
	private MemberTypeService memberTypeService;

    @At("")
	@Ok("beetl:/platform/member/type/index.html")
    @RequiresPermissions("member.config.type")
	public void index() {

	}

	@At("/data")
    @Ok("json")
    @RequiresPermissions("member.config.type")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return memberTypeService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/member/type/add.html")
    @RequiresPermissions("member.config.type")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("member.config.type.add")
    @SLog(tag = "Member_type", msg = "${args[0].id}")
    public Object addDo(@Param("..")Member_type memberType, HttpServletRequest req) {
		try {
			memberTypeService.insert(memberType);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/member/type/edit.html")
    @RequiresPermissions("member.config.type")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", memberTypeService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("member.config.type.edit")
    @SLog(tag = "Member_type", msg = "${args[0].id}")
    public Object editDo(@Param("..")Member_type memberType, HttpServletRequest req) {
		try {
            memberType.setOpBy(StringUtil.getUid());
			memberType.setOpAt((int) (System.currentTimeMillis() / 1000));
			memberTypeService.updateIgnoreNull(memberType);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("member.config.type.delete")
    @SLog(tag = "Member_type", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				memberTypeService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				memberTypeService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/member/type/detail.html")
    @RequiresPermissions("member.config.type")
	public void detail(String id, HttpServletRequest req) {
		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", memberTypeService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }
    }

}
