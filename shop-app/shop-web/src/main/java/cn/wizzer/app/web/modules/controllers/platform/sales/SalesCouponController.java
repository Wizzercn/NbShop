package cn.wizzer.app.web.modules.controllers.platform.sales;

import cn.wizzer.app.web.commons.utils.MoneyUtil;
import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.sales.modules.models.Sales_coupon;
import cn.wizzer.app.sales.modules.services.SalesCouponService;
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
@At("/platform/sales/coupon")
public class SalesCouponController {
    private static final Log log = Logs.get();
    @Inject
    private SalesCouponService salesCouponService;

    @At("")
    @Ok("beetl:/platform/sales/coupon/index.html")
    @RequiresPermissions("sales.coupon.manager")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("sales.coupon.manager")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        return salesCouponService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/sales/coupon/add.html")
    @RequiresPermissions("sales.coupon.manager")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("sales.coupon.manager.add")
    @SLog(tag = "Sales_coupon", msg = "${args[0].id}")
    public Object addDo(@Param("..") Sales_coupon salesCoupon,@Param("moneys")String moneys, HttpServletRequest req) {
        try {
            salesCoupon.setMoney(MoneyUtil.yuanToFen(moneys));
            salesCouponService.insert(salesCoupon);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/edit/?")
    @Ok("beetl:/platform/sales/coupon/edit.html")
    @RequiresPermissions("sales.coupon.manager")
    public void edit(String id, HttpServletRequest req) {
        req.setAttribute("obj", salesCouponService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("sales.coupon.manager.edit")
    @SLog(tag = "Sales_coupon", msg = "${args[0].id}")
    public Object editDo(@Param("..") Sales_coupon salesCoupon,@Param("moneys")String moneys, HttpServletRequest req) {
        try {
            salesCoupon.setMoney(MoneyUtil.yuanToFen(moneys));
            salesCoupon.setOpBy(StringUtil.getUid());
            salesCoupon.setOpAt((int) (System.currentTimeMillis() / 1000));
            salesCouponService.updateIgnoreNull(salesCoupon);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("sales.coupon.manager.delete")
    @SLog(tag = "Sales_coupon", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids, HttpServletRequest req) {
        try {
            if (ids != null && ids.length > 0) {
                salesCouponService.delete(ids);
                req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
            } else {
                salesCouponService.delete(id);
                req.setAttribute("id", id);
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/enable/?")
    @Ok("json")
    @RequiresPermissions("sales.coupon.manager.edit")
    public Object enable(String id, HttpServletRequest req) {
        try {
            salesCouponService.update(org.nutz.dao.Chain.make("disabled", false), Cnd.where("id", "=", id));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/disable/?")
    @Ok("json")
    @RequiresPermissions("sales.coupon.manager.edit")
    public Object disable(String id, HttpServletRequest req) {
        try {
            salesCouponService.update(org.nutz.dao.Chain.make("disabled", true), Cnd.where("id", "=", id));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

}
