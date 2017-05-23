package cn.wizzer.app.web.modules.controllers.platform.shop;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.shop.modules.models.Shop_express;
import cn.wizzer.app.shop.modules.services.ShopExpressService;
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
@At("/platform/shop/express")
public class ShopExpressController{
    private static final Log log = Logs.get();
    @Inject
    private ShopExpressService shopExpressService;

    @At("")
    @Ok("beetl:/platform/shop/express/index.html")
    @RequiresPermissions("platform.shop.express")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("platform.shop.express")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return shopExpressService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/shop/express/add.html")
    @RequiresPermissions("platform.shop.express")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.shop.express.add")
    @SLog(tag = "Shop_express", msg = "${args[0].id}")
    public Object addDo(@Param("..")Shop_express shopExpress, HttpServletRequest req) {
		try {
			shopExpressService.insert(shopExpress);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/shop/express/edit.html")
    @RequiresPermissions("platform.shop.express")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", shopExpressService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.shop.express.edit")
    @SLog(tag = "Shop_express", msg = "${args[0].id}")
    public Object editDo(@Param("..")Shop_express shopExpress, HttpServletRequest req) {
		try {
            shopExpress.setOpBy(StringUtil.getUid());
			shopExpress.setOpAt((int) (System.currentTimeMillis() / 1000));
			shopExpressService.updateIgnoreNull(shopExpress);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.shop.express.delete")
    @SLog(tag = "Shop_express", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				shopExpressService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				shopExpressService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/shop/express/detail.html")
    @RequiresPermissions("platform.shop.express")
	public void detail(String id, HttpServletRequest req) {
		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", shopExpressService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }
    }

}
