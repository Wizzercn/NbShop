package cn.wizzer.app.web.modules.controllers.platform.shop;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.shop.modules.models.Shop_area;
import cn.wizzer.app.shop.modules.services.ShopAreaService;
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
@At("/platform/shop/area")
public class ShopAreaController{
    private static final Log log = Logs.get();
    @Inject
    private ShopAreaService shopAreaService;

    @At("")
    @Ok("beetl:/platform/shop/area/index.html")
    @RequiresPermissions("platform.shop.area")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("platform.shop.area")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return shopAreaService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/shop/area/add.html")
    @RequiresPermissions("platform.shop.area")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.shop.area.add")
    @SLog(tag = "Shop_area", msg = "${args[0].id}")
    public Object addDo(@Param("..")Shop_area shopArea, HttpServletRequest req) {
		try {
			shopAreaService.insert(shopArea);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/shop/area/edit.html")
    @RequiresPermissions("platform.shop.area")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", shopAreaService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.shop.area.edit")
    @SLog(tag = "Shop_area", msg = "${args[0].id}")
    public Object editDo(@Param("..")Shop_area shopArea, HttpServletRequest req) {
		try {
            shopArea.setOpBy(StringUtil.getUid());
			shopArea.setOpAt((int) (System.currentTimeMillis() / 1000));
			shopAreaService.updateIgnoreNull(shopArea);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.shop.area.delete")
    @SLog(tag = "Shop_area", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				shopAreaService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				shopAreaService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/shop/area/detail.html")
    @RequiresPermissions("platform.shop.area")
	public void detail(String id, HttpServletRequest req) {
		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", shopAreaService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }
    }

}
