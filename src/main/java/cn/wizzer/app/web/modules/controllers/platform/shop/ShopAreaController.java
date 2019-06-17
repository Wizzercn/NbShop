package cn.wizzer.app.web.modules.controllers.platform.shop;

import cn.wizzer.app.shop.modules.models.Shop_area;
import cn.wizzer.app.shop.modules.services.ShopAreaService;
import cn.wizzer.app.web.commons.utils.StringUtil;
import cn.wizzer.framework.base.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wizzer on 2019/6/17
 */
@IocBean
@At("/platform/sys/shop/area")
public class ShopAreaController {
    private static final Log log = Logs.get();
    @Inject
    private ShopAreaService shopAreaService;


    @At("")
    @Ok("beetl:/platform/shop/area/index.html")
    @RequiresPermissions("sys.shop.area")
    public Object index() {
        return shopAreaService.query(Cnd.where("parentId", "=", "").or("parentId", "is", null).asc("location").asc("path"));
    }


    @At("/child")
    @Ok("json")
    @RequiresAuthentication
    public Object child(@Param("pid") String pid, HttpServletRequest req) {
        List<Shop_area> list = new ArrayList<>();
        List<NutMap> treeList = new ArrayList<>();
        Cnd cnd = Cnd.NEW();
        if (Strings.isBlank(pid)) {
            cnd.and("parentId", "=", "").or("parentId", "is", null);
        } else {
            cnd.and("parentId", "=", pid);
        }
        cnd.asc("location").asc("path");
        list = shopAreaService.query(cnd);
        for (Shop_area shopArea : list) {
            if (shopAreaService.count(Cnd.where("parentId", "=", shopArea.getId())) > 0) {
                shopArea.setHasChildren(true);
            }
            NutMap map = Lang.obj2nutmap(shopArea);
            map.addv("expanded", false);
            map.addv("children", new ArrayList<>());
            treeList.add(map);
        }
        return Result.success().addData(treeList);
    }

    @At("/tree")
    @Ok("json")
    @RequiresAuthentication
    public Object tree(@Param("pid") String pid, HttpServletRequest req) {
        try {
            List<NutMap> treeList = new ArrayList<>();
            if (Strings.isBlank(pid)) {
                NutMap root = NutMap.NEW().addv("value", "root").addv("label", "不选择菜单");
                treeList.add(root);
            }
            Cnd cnd = Cnd.NEW();
            if (Strings.isBlank(pid)) {
                cnd.and("parentId", "=", "").or("parentId", "is", null);
            } else {
                cnd.and("parentId", "=", pid);
            }
            cnd.asc("location").asc("path");
            List<Shop_area> list = shopAreaService.query(cnd);
            for (Shop_area shopArea : list) {
                NutMap map = NutMap.NEW().addv("value", shopArea.getId()).addv("label", shopArea.getName());
                if (shopArea.isHasChildren()) {
                    map.addv("children", new ArrayList<>());
                }
                treeList.add(map);
            }
            return Result.success().addData(treeList);
        } catch (Exception e) {
            return Result.error();
        }
    }

    @At
    @Ok("json")
    @RequiresPermissions("sys.shop.area.add")
    public Object addDo(@Param("..") Shop_area shopArea, @Param(value = "parentId", df = "") String parentId, HttpServletRequest req) {
        try {
            shopArea.setHasChildren(false);
            shopArea.setOpBy(StringUtil.getPlatformUid());
            shopAreaService.save(shopArea, parentId);
            shopAreaService.clearCache();
            return Result.success();
        } catch (Exception e) {
            return Result.error();
        }
    }

    @At("/edit/?")
    @Ok("json")
    @RequiresPermissions("sys.shop.area")
    public Object edit(String id, HttpServletRequest req) {
        try {
            return Result.success().addData(shopAreaService.fetch(id));
        } catch (Exception e) {
            return Result.error();
        }
    }

    @At
    @Ok("json")
    @RequiresPermissions("sys.shop.area.edit")
    public Object editDo(@Param("..") Shop_area shopArea, @Param("parentId") String parentId, HttpServletRequest req) {
        try {
            shopArea.setOpBy(StringUtil.getPlatformUid());
            shopArea.setOpAt(Times.getTS());
            shopAreaService.updateIgnoreNull(shopArea);
            shopAreaService.clearCache();
            return Result.success();
        } catch (Exception e) {
            return Result.error();
        }
    }

    @At("/delete/?")
    @Ok("json")
    @RequiresPermissions("sys.shop.area.delete")
    public Object delete(String id, HttpServletRequest req) {
        try {
            Shop_area shopArea = shopAreaService.fetch(id);
            shopAreaService.deleteAndChild(shopArea);
            shopAreaService.clearCache();
            return Result.success();
        } catch (Exception e) {
            return Result.error();
        }
    }

    @At("/enable/?")
    @Ok("json")
    @RequiresPermissions("sys.shop.area.edit")
    public Object enable(String menuId, HttpServletRequest req) {
        try {
            shopAreaService.update(org.nutz.dao.Chain.make("disabled", false), Cnd.where("id", "=", menuId));
            shopAreaService.clearCache();
            return Result.success();
        } catch (Exception e) {
            return Result.error();
        }
    }

    @At("/disable/?")
    @Ok("json")
    @RequiresPermissions("sys.shop.area.edit")
    public Object disable(String menuId, HttpServletRequest req) {
        try {
            shopAreaService.update(org.nutz.dao.Chain.make("disabled", true), Cnd.where("id", "=", menuId));
            shopAreaService.clearCache();
            return Result.success();
        } catch (Exception e) {
            return Result.error();
        }
    }

    @At("/menuAll")
    @Ok("json")
    @RequiresPermissions("sys.shop.area")
    public Object menuAll(HttpServletRequest req) {
        try {
            List<Shop_area> list = shopAreaService.query(Cnd.NEW().asc("location").asc("path"));
            NutMap menuMap = NutMap.NEW();
            for (Shop_area shopArea : list) {
                List<Shop_area> list1 = menuMap.getList(shopArea.getParentId(), Shop_area.class);
                if (list1 == null) {
                    list1 = new ArrayList<>();
                }
                list1.add(shopArea);
                menuMap.put(shopArea.getParentId(), list1);
            }
            return Result.success().addData(getTree(menuMap, ""));
        } catch (Exception e) {
            return Result.error();
        }
    }

    private List<NutMap> getTree(NutMap menuMap, String pid) {
        List<NutMap> treeList = new ArrayList<>();
        List<Shop_area> subList = menuMap.getList(pid, Shop_area.class);
        for (Shop_area shopArea : subList) {
            NutMap map = Lang.obj2nutmap(shopArea);
            map.put("label", shopArea.getName());
            if (shopArea.isHasChildren() || (menuMap.get(shopArea.getId()) != null)) {
                map.put("children", getTree(menuMap, shopArea.getId()));
            }
            treeList.add(map);
        }
        return treeList;
    }

    @At
    @Ok("json")
    @RequiresPermissions("sys.shop.area.edit")
    public Object sortDo(@Param("ids") String ids, HttpServletRequest req) {
        try {
            String[] menuIds = StringUtils.split(ids, ",");
            int i = 0;
            shopAreaService.execute(Sqls.create("update shop_area set location=0"));
            for (String s : menuIds) {
                if (!Strings.isBlank(s)) {
                    shopAreaService.update(org.nutz.dao.Chain.make("location", i), Cnd.where("id", "=", s));
                    i++;
                }
            }
            shopAreaService.clearCache();
            return Result.success();
        } catch (Exception e) {
            return Result.error();
        }
    }
}
