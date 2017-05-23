package cn.wizzer.app.web.modules.controllers.platform.shop;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.shop.modules.models.Shop_config;
import cn.wizzer.app.shop.modules.services.ShopConfigService;
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
@At("/platform/shop/config")
public class ShopConfigController{
    private static final Log log = Logs.get();
    @Inject
    private ShopConfigService shopConfigService;

    @At("")
    @Ok("beetl:/platform/shop/config/index.html")
    @RequiresPermissions("platform.shop.config")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("platform.shop.config")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return shopConfigService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/shop/config/add.html")
    @RequiresPermissions("platform.shop.config")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.shop.config.add")
    @SLog(tag = "Shop_config", msg = "${args[0].id}")
    public Object addDo(@Param("..")Shop_config shopConfig, HttpServletRequest req) {
		try {
			shopConfigService.insert(shopConfig);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/shop/config/edit.html")
    @RequiresPermissions("platform.shop.config")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", shopConfigService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.shop.config.edit")
    @SLog(tag = "Shop_config", msg = "${args[0].id}")
    public Object editDo(@Param("..")Shop_config shopConfig, HttpServletRequest req) {
		try {
            shopConfig.setOpBy(StringUtil.getUid());
			shopConfig.setOpAt((int) (System.currentTimeMillis() / 1000));
			shopConfigService.updateIgnoreNull(shopConfig);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.shop.config.delete")
    @SLog(tag = "Shop_config", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				shopConfigService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				shopConfigService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/shop/config/detail.html")
    @RequiresPermissions("platform.shop.config")
	public void detail(String id, HttpServletRequest req) {
		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", shopConfigService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }
    }

}
