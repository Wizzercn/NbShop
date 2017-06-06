package cn.wizzer.app.web.modules.controllers.platform.member;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.member.modules.models.Member_coupon;
import cn.wizzer.app.member.modules.services.MemberCouponService;
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
@At("/platform/member/coupon")
public class MemberCouponController{
    private static final Log log = Logs.get();
    @Inject
    private MemberCouponService memberCouponService;

    @At("")
    @Ok("beetl:/platform/member/coupon/index.html")
    @RequiresPermissions("platform.member.coupon")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("platform.member.coupon")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return memberCouponService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/member/coupon/add.html")
    @RequiresPermissions("platform.member.coupon")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.member.coupon.add")
    @SLog(tag = "Member_coupon", msg = "${args[0].id}")
    public Object addDo(@Param("..")Member_coupon memberCoupon, HttpServletRequest req) {
		try {
			memberCouponService.insert(memberCoupon);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/member/coupon/edit.html")
    @RequiresPermissions("platform.member.coupon")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", memberCouponService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.member.coupon.edit")
    @SLog(tag = "Member_coupon", msg = "${args[0].id}")
    public Object editDo(@Param("..")Member_coupon memberCoupon, HttpServletRequest req) {
		try {
            memberCoupon.setOpBy(StringUtil.getUid());
			memberCoupon.setOpAt((int) (System.currentTimeMillis() / 1000));
			memberCouponService.updateIgnoreNull(memberCoupon);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.member.coupon.delete")
    @SLog(tag = "Member_coupon", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				memberCouponService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				memberCouponService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/member/coupon/detail.html")
    @RequiresPermissions("platform.member.coupon")
	public void detail(String id, HttpServletRequest req) {
		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", memberCouponService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }
    }

}
