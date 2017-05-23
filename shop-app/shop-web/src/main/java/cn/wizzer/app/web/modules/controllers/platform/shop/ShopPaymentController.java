package cn.wizzer.app.web.modules.controllers.platform.shop;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.shop.modules.models.Shop_payment;
import cn.wizzer.app.shop.modules.services.ShopPaymentService;
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
@At("/platform/shop/payment")
public class ShopPaymentController{
    private static final Log log = Logs.get();
    @Inject
    private ShopPaymentService shopPaymentService;

    @At("")
    @Ok("beetl:/platform/shop/payment/index.html")
    @RequiresPermissions("platform.shop.payment")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("platform.shop.payment")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return shopPaymentService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/shop/payment/add.html")
    @RequiresPermissions("platform.shop.payment")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.shop.payment.add")
    @SLog(tag = "Shop_payment", msg = "${args[0].id}")
    public Object addDo(@Param("..")Shop_payment shopPayment, HttpServletRequest req) {
		try {
			shopPaymentService.insert(shopPayment);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/shop/payment/edit.html")
    @RequiresPermissions("platform.shop.payment")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", shopPaymentService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.shop.payment.edit")
    @SLog(tag = "Shop_payment", msg = "${args[0].id}")
    public Object editDo(@Param("..")Shop_payment shopPayment, HttpServletRequest req) {
		try {
            shopPayment.setOpBy(StringUtil.getUid());
			shopPayment.setOpAt((int) (System.currentTimeMillis() / 1000));
			shopPaymentService.updateIgnoreNull(shopPayment);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.shop.payment.delete")
    @SLog(tag = "Shop_payment", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				shopPaymentService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				shopPaymentService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/shop/payment/detail.html")
    @RequiresPermissions("platform.shop.payment")
	public void detail(String id, HttpServletRequest req) {
		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", shopPaymentService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }
    }

}
