package cn.wizzer.app.web.modules.controllers.platform.sales;

import cn.wizzer.app.member.modules.services.MemberCouponService;
import cn.wizzer.app.sales.modules.models.Sales_coupon;
import cn.wizzer.app.sales.modules.services.SalesCouponService;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.app.web.commons.utils.MoneyUtil;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.DateUtil;
import cn.wizzer.framework.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/sales/couponlog")
public class SalesCouponLogController {
    private static final Log log = Logs.get();
    @Inject
    private SalesCouponService salesCouponService;
    @Inject
    private MemberCouponService memberCouponService;

    @At("")
    @Ok("beetl:/platform/sales/couponlog/index.html")
    @RequiresPermissions("sales.coupon.log")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("sales.coupon.log")
    public Object data(@Param("orderId")String orderId,@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        if(Strings.isNotBlank(orderId)){
            cnd.and("orderId","=",orderId);
        }
        return memberCouponService.data(length, start, draw, order, columns, cnd, "memberUser");
    }

}
