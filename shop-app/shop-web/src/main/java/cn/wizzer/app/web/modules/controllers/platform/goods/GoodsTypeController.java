package cn.wizzer.app.web.modules.controllers.platform.goods;

import cn.wizzer.app.goods.modules.models.Goods_type;
import cn.wizzer.app.goods.modules.services.*;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/goods/type")
public class GoodsTypeController {
    private static final Log log = Logs.get();
    @Inject
    private GoodsTypeService shopGoodsTypeService;
    @Inject
    private GoodsBrandService shopGoodsBrandService;
    @Inject
    private GoodsTypePropsService shopGoodsTypePropsService;
    @Inject
    private GoodsSpecService shopGoodsSpecService;
    @Inject
    private GoodsSpecValuesService shopGoodsSpecValuesService;

    @At("")
    @Ok("beetl:/platform/goods/type/index.html")
    @RequiresAuthentication
    public void index() {

    }

    @At("/spec")
    @Ok("beetl:/platform/goods/type/spec.html")
    @RequiresAuthentication
    public Object spec() {
        return shopGoodsSpecService.query(Cnd.orderBy().asc("location"));
    }

    @At("/spec_val/?")
    @Ok("json")
    @RequiresAuthentication
    public Object spec_val(String id) {
        return Result.success("", shopGoodsSpecValuesService.query(Cnd.where("specId", "=", id).asc("location")));
    }

    @At("/next/?")
    @Ok("beetl:/platform/goods/type/next.html")
    @RequiresAuthentication
    public Object next(String id, HttpServletRequest req) {
        return shopGoodsTypeService.fetch(id);
    }

    @At
    @Ok("json:full")
    @RequiresAuthentication
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        return shopGoodsTypeService.data(length, start, draw, order, columns, cnd, null);
    }

    @At
    @Ok("beetl:/platform/goods/type/add.html")
    @RequiresAuthentication
    public void add(@Param("isPhysical") int isPhysical, @Param("hasBrand") int hasBrand, @Param("hasProp") int hasProp, @Param("hasSpec") int hasSpec, @Param("hasParam") int hasParam, @Param("hasTab") int hasTab, HttpServletRequest req) {
        req.setAttribute("isPhysical", isPhysical);
        req.setAttribute("hasBrand", hasBrand);
        req.setAttribute("hasProp", hasProp);
        req.setAttribute("hasSpec", hasSpec);
        req.setAttribute("hasParam", hasParam);
        req.setAttribute("hasTab", hasTab);
        req.setAttribute("brandList", shopGoodsBrandService.query(Cnd.orderBy().asc("location")));
    }

    @At
    @Ok("json")
    @RequiresPermissions("goods.conf.type.add")
    @SLog(tag = "新建商品类型", msg = "类型名称:${args[0].name}")
    public Object addDo(@Param("..") Goods_type shopGoodsType, @Param("brand") String[] brand, @Param("props_name") String[] props_name, @Param("props_type") String[] props_type,
                        @Param("props_values") String[] props_values, @Param("specId") String[] specId,
                        @Param(value = "specValIds", array_auto_split = false) String[] specValIds, @Param(value = "specValText", array_auto_split = false) String[] specValText, @Param(value = "specValUrl", array_auto_split = false) String[] specValUrl,
                        @Param("group_name") String[] group_name, @Param("group_params") String[] group_params,
                        @Param("tab_name") String[] tab_name, @Param("tab_note") String[] tab_note, HttpServletRequest req) {
        try {
            shopGoodsTypeService.add(shopGoodsType, brand, props_name, props_type, props_values, specId, specValIds, specValText, specValUrl, group_name, group_params, tab_name, tab_note);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/edit/?")
    @Ok("beetl:/platform/goods/type/edit.html")
    @RequiresAuthentication
    public Object edit(String id, @Param("isPhysical") int isPhysical, @Param("hasBrand") int hasBrand, @Param("hasProp") int hasProp, @Param("hasSpec") int hasSpec, @Param("hasParam") int hasParam, @Param("hasTab") int hasTab, HttpServletRequest req) {
        Goods_type obj = shopGoodsTypeService.fetch(id);
        req.setAttribute("isPhysical", isPhysical);
        req.setAttribute("hasBrand", hasBrand);
        req.setAttribute("hasProp", hasProp);
        req.setAttribute("hasSpec", hasSpec);
        req.setAttribute("hasParam", hasParam);
        req.setAttribute("hasTab", hasTab);
        req.setAttribute("brandList", shopGoodsBrandService.query(Cnd.orderBy().asc("location")));
        shopGoodsTypeService.fetchLinks(obj, null, Cnd.orderBy().asc("location"));
        shopGoodsTypeService.fetchLinks(obj.getPropsList(), null, Cnd.orderBy().asc("location"));
        shopGoodsTypeService.fetchLinks(obj.getSpecList(), null, Cnd.orderBy().asc("location"));
        shopGoodsTypeService.fetchLinks(obj.getParamgList(), null, Cnd.orderBy().asc("location"));
        return obj;
    }

    @At
    @Ok("json")
    @RequiresPermissions("goods.conf.type.edit")
    @SLog(tag = "修改商品类型", msg = "类型名称:${args[0].name}")
    public Object editDo(@Param("..") Goods_type shopGoodsType, @Param("brand") String[] brand, @Param("props_name") String[] props_name, @Param("props_type") String[] props_type,
                         @Param("props_values") String[] props_values, @Param("specId") String[] specId,
                         @Param(value = "specValueIds", array_auto_split = false) String[] specValIds, @Param(value = "specValText", array_auto_split = false) String[] specValText, @Param(value = "specValUrl", array_auto_split = false) String[] specValUrl,
                         @Param("group_name") String[] group_name, @Param("group_params") String[] group_params,
                         @Param("tab_name") String[] tab_name, @Param("tab_note") String[] tab_note, HttpServletRequest req) {
        try {
            shopGoodsTypeService.update(shopGoodsType, brand, props_name, props_type, props_values, specId, specValIds, specValText, specValUrl, group_name, group_params, tab_name, tab_note, Strings.sNull(req.getAttribute("uid")));
            return Result.success("system.success");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("system.error");
        }
    }


    @At({"/delete", "/delete/?"})
    @Ok("json")
    @RequiresPermissions("goods.conf.type.delete")
    @SLog(tag = "删除商品类型", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids, HttpServletRequest req) {
        try {
            if (ids != null && ids.length > 0) {
                shopGoodsTypeService.deleteType(ids);
                req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
            } else {
                shopGoodsTypeService.deleteType(id);
                req.setAttribute("id", id);
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }


}
