package cn.wizzer.app.web.modules.controllers.platform.goods;

import cn.wizzer.app.goods.modules.models.Goods_spec;
import cn.wizzer.app.goods.modules.models.Goods_type_spec;
import cn.wizzer.app.goods.modules.services.GoodsSpecService;
import cn.wizzer.app.goods.modules.services.GoodsSpecValuesService;
import cn.wizzer.app.goods.modules.services.GoodsTypeService;
import cn.wizzer.app.goods.modules.services.GoodsTypeSpecService;
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
@At("/platform/goods/spec")
public class GoodsSpecController {
    private static final Log log = Logs.get();
    @Inject
    private GoodsSpecService shopGoodsSpecService;
    @Inject
    private GoodsSpecValuesService shopGoodsSpecValuesService;
    @Inject
    private GoodsTypeSpecService shopGoodsTypeSpecService;
    @Inject
    private GoodsTypeService shopGoodsTypeService;

    @At("/image")
    @Ok("beetl:/platform/goods/spec/image.html")
    @RequiresAuthentication
    public void index(@Param("w") int w, @Param("h") int h, HttpServletRequest req) {
        req.setAttribute("w", w);
        req.setAttribute("h", h);
    }

    @At("")
    @Ok("beetl:/platform/goods/spec/index.html")
    @RequiresAuthentication
    public void index() {

    }

    @At
    @Ok("json:full")
    @RequiresAuthentication
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        return shopGoodsSpecService.data(length, start, draw, order, columns, cnd, null);
    }

    @At
    @Ok("beetl:/platform/goods/spec/add.html")
    @RequiresAuthentication
    public void add() {

    }

    @At
    @Ok("json")
    @RequiresPermissions("goods.conf.spec.add")
    @SLog(tag = "新建商品规格", msg = "规格名称:${args[0].name}")
    public Object addDo(@Param("..") Goods_spec shopGoodsSpec, @Param("spec_value") String[] spec_value, @Param("spec_picurl") String[] spec_picurl, HttpServletRequest req) {
        try {
            shopGoodsSpecService.add(shopGoodsSpec, spec_value, spec_picurl);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/edit/?")
    @Ok("beetl:/platform/goods/spec/edit.html")
    @RequiresAuthentication
    public Object edit(String id) {
        return shopGoodsSpecService.fetchLinks(shopGoodsSpecService.fetch(id), "specValues", Cnd.orderBy().asc("location"));
    }

    @At
    @Ok("json")
    @RequiresPermissions("goods.conf.spec.edit")
    @SLog(tag = "修改商品规格", msg = "规格名称:${args[0].name}")
    public Object editDo(@Param("..") Goods_spec shopGoodsSpec, @Param("spec_value") String[] spec_value, @Param("spec_picurl") String[] spec_picurl, @Param("spec_value_id") String[] spec_value_id, HttpServletRequest req) {
        try {
            shopGoodsSpecService.update(shopGoodsSpec, spec_value, spec_picurl, spec_value_id, Strings.sNull(req.getAttribute("uid")));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }


    @At({"/delete/?"})
    @Ok("json")
    @RequiresPermissions("goods.conf.spec.delete")
    @SLog(tag = "删除商品规格", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String id, HttpServletRequest req) {
        try {
            List<Goods_type_spec> templist = shopGoodsTypeSpecService.query(Cnd.where("specId", "=", id));
            if (templist.size() > 0) {
                StringBuilder errMsg = new StringBuilder();
                for (Goods_type_spec goodsSpecTemp : templist) {
                    errMsg.append(" " + shopGoodsTypeService.fetch(goodsSpecTemp.getTypeId()).getName());
                }
                return Result.error("在" + errMsg.toString() + " 类型中已使用，不允许删除");
            }
            shopGoodsSpecService.deleteSpec(id);
            req.setAttribute("id", id);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

}
