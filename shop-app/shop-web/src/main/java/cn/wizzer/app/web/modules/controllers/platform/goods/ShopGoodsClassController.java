package cn.wizzer.app.web.modules.controllers.platform.goods;

import cn.wizzer.app.shop.modules.models.Shop_goods_class;
import cn.wizzer.app.shop.modules.services.ShopGoodsClassService;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypeService;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@IocBean
@At("/platform/shop/goods/class")
public class ShopGoodsClassController {
    private static final Log log = Logs.get();
    @Inject
    private ShopGoodsClassService shopGoodsClassService;
    @Inject
    private ShopGoodsTypeService shopGoodsTypeService;

    @At("")
    @Ok("beetl:/platform/shop/goods/class/index.html")
    @RequiresAuthentication
    public Object index(HttpServletRequest req) {
        List<Shop_goods_class> list = shopGoodsClassService.query(Cnd.where("parentId", "=", "").or("parentId", "is", null).asc("location").asc("path"));
        shopGoodsClassService.fetchLinks(list, "goodsType");
        return list;
    }

    @At
    @Ok("json:full")
    @RequiresAuthentication
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        return shopGoodsClassService.data(length, start, draw, order, columns, cnd, null);
    }

    @At
    @Ok("beetl:/platform/shop/goods/class/add.html")
    @RequiresAuthentication
    public void add(@Param("pid") String pid, HttpServletRequest req) {
        if (!Strings.isEmpty(pid)) {
            req.setAttribute("pobj", shopGoodsClassService.fetch(pid));
        }
        req.setAttribute("typeList", shopGoodsTypeService.query());
    }

    @At
    @Ok("json")
    @RequiresPermissions("shop.goods.conf.class.add")
    @SLog(tag = "新建商品分类", msg = "分类名称:${args[0].name}")
    public Object addDo(@Param("..") Shop_goods_class shopGoodsClass, @Param("parentId") String parentId, HttpServletRequest req) {
        try {
            shopGoodsClassService.save(shopGoodsClass, parentId);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/edit/?")
    @Ok("beetl:/platform/shop/goods/class/edit.html")
    @RequiresAuthentication
    public Object edit(String id, HttpServletRequest req) {
        Shop_goods_class obj = shopGoodsClassService.fetch(id);
        if (!Strings.isEmpty(obj.getParentId())) {
            req.setAttribute("pobj", shopGoodsClassService.fetch(obj.getParentId()));
        }
        req.setAttribute("typeList", shopGoodsTypeService.query());
        return obj;
    }

    @At
    @Ok("json")
    @RequiresPermissions("shop.goods.conf.class.edit")
    @SLog(tag = "修改商品分类", msg = "分类名称:${args[0].name}")
    public Object editDo(@Param("..") Shop_goods_class shopGoodsClass, HttpServletRequest req) {
        try {
            shopGoodsClass.setOpAt((int) (System.currentTimeMillis() / 1000));
            shopGoodsClassService.updateIgnoreNull(shopGoodsClass);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }


    @At("/delete/?")
    @Ok("json")
    @RequiresPermissions("shop.goods.conf.class.delete")
    @SLog(tag = "删除商品分类", msg = "分类名称:${args[1].getAttribute('name')}")
    public Object delete(String id, HttpServletRequest req) {
        try {
            Shop_goods_class obj = shopGoodsClassService.fetch(id);
            shopGoodsClassService.deleteAndChild(obj);
            req.setAttribute("name", obj.getName());
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/enable/?")
    @Ok("json")
    @RequiresPermissions("shop.goods.conf.class.edit")
    @SLog(tag = "启用商品分类", msg = "分类名称:${args[1].getAttribute('name')}")
    public Object enable(String id, HttpServletRequest req) {
        try {
            req.setAttribute("name", shopGoodsClassService.fetch(id).getName());
            shopGoodsClassService.update(org.nutz.dao.Chain.make("disabled", false), Cnd.where("id", "=", id));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/disable/?")
    @Ok("json")
    @RequiresPermissions("shop.goods.conf.class.edit")
    @SLog(tag = "禁用商品分类", msg = "分类名称:${args[1].getAttribute('name')}")
    public Object disable(String id, HttpServletRequest req) {
        try {
            req.setAttribute("name", shopGoodsClassService.fetch(id).getName());
            shopGoodsClassService.update(org.nutz.dao.Chain.make("disabled", true), Cnd.where("id", "=", id));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At
    @Ok("json")
    @RequiresAuthentication
    public Object tree(@Param("pid") String pid) {
        List<Shop_goods_class> list = shopGoodsClassService.query(Cnd.where("parentId", "=", Strings.sBlank(pid)).asc("location").asc("path"));
        List<Map<String, Object>> tree = new ArrayList<>();
        for (Shop_goods_class menu : list) {
            Map<String, Object> obj = new HashMap<>();
            obj.put("id", menu.getId());
            obj.put("text", menu.getName());
            obj.put("children", menu.isHasChildren());
            tree.add(obj);
        }
        return tree;
    }

    @At("/child/?")
    @Ok("beetl:/platform/shop/goods/class/child.html")
    @RequiresAuthentication
    public Object child(String id) {
        List<Shop_goods_class> list = shopGoodsClassService.query(Cnd.where("parentId", "=", id).asc("location").asc("path"));
        for (Shop_goods_class goodsClass : list) {
            shopGoodsClassService.fetchLinks(goodsClass, "goodsType");
        }
        return list;
    }

    @At
    @Ok("beetl:/platform/shop/goods/class/sort.html")
    @RequiresAuthentication
    public void sort(HttpServletRequest req) {
        List<Shop_goods_class> list = shopGoodsClassService.query(Cnd.orderBy().asc("location").asc("path"));
        List<Shop_goods_class> firstMenus = new ArrayList<>();
        Map<String, List<Shop_goods_class>> secondMenus = new HashMap<>();
        for (Shop_goods_class menu : list) {
            if (menu.getPath().length() > 4) {
                List<Shop_goods_class> s = secondMenus.get(StringUtil.getParentId(menu.getPath()));
                if (s == null) s = new ArrayList<>();
                s.add(menu);
                secondMenus.put(StringUtil.getParentId(menu.getPath()), s);
            } else if (menu.getPath().length() == 4) {
                firstMenus.add(menu);
            }
        }
        req.setAttribute("firstMenus", firstMenus);
        req.setAttribute("secondMenus", secondMenus);
    }

    @At
    @Ok("json")
    @RequiresPermissions("shop.goods.conf.class.edit")
    public Object sortDo(@Param("ids") String ids, HttpServletRequest req) {
        try {
            String[] menuIds = StringUtils.split(ids, ",");
            int i = 0;
            shopGoodsClassService.dao().execute(Sqls.create("update shop_goods_class set location=0"));
            for (String s : menuIds) {
                if (!Strings.isBlank(s)) {
                    shopGoodsClassService.update(org.nutz.dao.Chain.make("location", i), Cnd.where("id", "=", s));
                    i++;
                }
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }
}
