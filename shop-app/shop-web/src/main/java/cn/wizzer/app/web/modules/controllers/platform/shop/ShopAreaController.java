package cn.wizzer.app.web.modules.controllers.platform.shop;

import cn.wizzer.app.web.commons.base.Globals;
import cn.wizzer.app.web.commons.utils.PinyinUtil;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.shop.modules.models.Shop_area;
import cn.wizzer.app.shop.modules.services.ShopAreaService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.*;
import org.nutz.dao.Chain;
import org.nutz.lang.Files;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@IocBean
@At("/platform/shop/area")
public class ShopAreaController {
    private static final Log log = Logs.get();
    @Inject
    private ShopAreaService shopAreaService;

    @At("")
    @RequiresPermissions("shop.logistics.area")
    @Ok("beetl:/platform/shop/area/index.html")
    public void index(HttpServletRequest req) {
        req.setAttribute("obj", shopAreaService
                .query(Cnd.where("parentId", "=", "").or("parentId", "is", null).asc("location").asc("path")));
    }

    @At(value = {"/add/?", "/add"})
    @RequiresPermissions("shop.logistics.area")
    @Ok("beetl:/platform/shop/area/add.html")
    public void add(String id, HttpServletRequest req) throws IOException {
        req.setAttribute("obj", Strings.isBlank(id) ? null : shopAreaService.fetch(id));
    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("shop.logistics.area.add")
    public Object addDo(@Param("..") Shop_area shoparea, @Param("parentId") String parentId) {
        try {
            shopAreaService.save(shoparea, parentId);
            return Result.success("system.success");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("system.error");
        }
    }

    @At("/child/?")
    @Ok("beetl:/platform/shop/area/child.html")
    @RequiresPermissions("shop.logistics.area")
    public void child(String id, HttpServletRequest req) {
        req.setAttribute("obj", shopAreaService.query(Cnd.where("parentId", "=", id).asc("location").asc("path")));
    }

    @At("/edit/?")
    @RequiresPermissions("shop.logistics.area")
    @Ok("beetl:/platform/shop/area/edit.html")
    public void edit(String id, HttpServletRequest req) {
        Shop_area shoparea = shopAreaService.fetch(id);
        req.setAttribute("obj", shoparea);
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("shop.logistics.area.edit")
    public Object editDo(@Param("..") Shop_area shoparea, HttpServletRequest req) {
        try {
            shoparea.setOpBy(StringUtil.getUid());
            shoparea.setOpAt((int) (System.currentTimeMillis() / 1000));
            shopAreaService.updateIgnoreNull(shoparea);
            shopAreaService.update(Chain.make("isCash",shoparea.isCash()),Cnd.where("path","like",shoparea.getPath()+"%"));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/delete/?")
    @Ok("json")
    @RequiresPermissions("shop.logistics.area.delete")
    public Object delete(String id, HttpServletRequest req) {
        try {
            Shop_area shoparea = shopAreaService.fetch(id);
            shopAreaService.deleteAndChild(shoparea);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/enable/?")
    @Ok("json")
    @RequiresPermissions("shop.logistics.area.delete")
    public Object enable(String id, HttpServletRequest req) {
        try {
            shopAreaService.update(org.nutz.dao.Chain.make("disabled", false), Cnd.where("id", "=", id));

            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/disable/?")
    @Ok("json")
    @RequiresPermissions("shop.logistics.area.delete")
    public Object disable(String id, HttpServletRequest req) {
        try {
            shopAreaService.update(org.nutz.dao.Chain.make("disabled", true), Cnd.where("id", "=", id));

            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At(value = {"/tree", "/tree/?"})
    @Ok("json")
    @RequiresPermissions("shop.logistics.area")
    public Object tree(String pid, HttpServletRequest req) {
        List<Shop_area> list = shopAreaService.query(Cnd.where("parentId", "=", Strings.sBlank(pid)).asc("path"));
        List<Map<String, Object>> tree = new ArrayList<>();
        for (Shop_area shoparea : list) {
            Map<String, Object> obj = new HashMap<>();
            obj.put("id", shoparea.getId());
            obj.put("text", shoparea.getName());
            obj.put("children", shoparea.isHasChildren());
            tree.add(obj);
        }
        return tree;
    }

    @At("/sort")
    @Ok("beetl:/platform/shop/area/sort.html")
    @RequiresPermissions("shop.logistics.area")
    public void sort(HttpServletRequest req) {
        List<Shop_area> list = shopAreaService.query(Cnd.orderBy().asc("location").asc("path"));
        List<Shop_area> firstMenus = new ArrayList<>();
        Map<String, List<Shop_area>> secondMenus = new HashMap<>();
        for (Shop_area menu : list) {
            if (menu.getPath().length() > 4) {
                List<Shop_area> s = secondMenus.get(StringUtil.getParentId(menu.getPath()));
                if (s == null)
                    s = new ArrayList<>();
                s.add(menu);
                secondMenus.put(StringUtil.getParentId(menu.getPath()), s);
            } else if (menu.getPath().length() == 4) {
                firstMenus.add(menu);
            }
        }
        req.setAttribute("firstMenus", firstMenus);
        req.setAttribute("secondMenus", secondMenus);
    }

    @At(value = "/sortDo/{ids}")
    @Ok("json")
    @RequiresPermissions("shop.logistics.area.edit")
    public Object sortDo(String ids, HttpServletRequest req) {
        try {
            String[] menuIds = StringUtils.split(ids, ",");
            int i = 0;
            shopAreaService.dao().execute(Sqls.create("update shop_area set location=0"));
            for (String s : menuIds) {
                if (!Strings.isBlank(s)) {
                    shopAreaService.update(org.nutz.dao.Chain.make("location", i), Cnd.where("id", "=", s));
                    i++;
                }
            }

            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/build")
    @RequiresPermissions("shop.logistics.area")
    @Ok("json")
    public Object build(HttpServletRequest req) {
        try {
            List<Shop_area> list = shopAreaService.query(Cnd.orderBy().asc("location").asc("path"));
            StringBuilder sbAll = new StringBuilder();
            StringBuilder sbShop = new StringBuilder();
            List<Shop_area> country = new ArrayList<>();//有几个国家？
            Map<String, List<Shop_area>> allMap = new HashMap<>();//全部地区
            Map<String, List<Shop_area>> shopMap = new HashMap<>();//启用的地区
            for (Shop_area area : list) {
                if (area.getPath().length() > 4) {
                    List<Shop_area> s = allMap.get(StringUtil.getParentId(area.getPath()));
                    if (s == null) s = new ArrayList<>();
                    s.add(area);
                    allMap.put(StringUtil.getParentId(area.getPath()), s);
                    if (!area.isDisabled()) {
                        shopMap.put(StringUtil.getParentId(area.getPath()), s);
                    }
                } else if (area.getPath().length() == 4) {
                    country.add(area);
                }
            }
            for (Shop_area area : country) {//组装全部地区数据
                doAeraData(area.getCode(), area.getPath(), "all", allMap);
                doAeraData(area.getCode(), area.getPath(), "shop", shopMap);
            }
            return Result.success("system.success");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("system.error");
        }
    }

    private void doAeraData(String country, String path, String type, Map<String, List<Shop_area>> map) throws Exception {
        String filePath = Globals.AppRoot + "/assets/plugins/city-picker/js/";
        String fileName = "data." + country + "." + type + "_new.js";
        List<Shop_area> list = map.get(path);
        StringBuilder sbData = new StringBuilder();
        StringBuilder sbCountry = new StringBuilder();
        sbData.append(getJson(list, map, type));
        sbCountry.append(getCountry(country, list, type));
        String tpl = Files.read(filePath + "data." + country + ".tpl");
        File file = new File(filePath + fileName);
        Files.createFileIfNoExists(file);
        Files.write(file, tpl.replace("<!--#COUNTRY#-->", sbCountry.toString()).replace("<!--#DATA#-->", sbData.toString()));
    }

    /**
     * 得到省份字母数据区块
     *
     * @param country
     * @param list
     * @return
     */
    private String getCountry(String country, List<Shop_area> list, String type) {
        StringBuilder sb = new StringBuilder();
        String ag = "abcdefg";
        String hk = "hijk";
        String ls = "lmnopqrs";
        String tz = "tuvwxyz";
        StringBuilder sbAG = new StringBuilder();
        StringBuilder sbHK = new StringBuilder();
        StringBuilder sbLS = new StringBuilder();
        StringBuilder sbTZ = new StringBuilder();
        sb.append(country + ":{");
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Shop_area area = list.get(i);
                String py = PinyinUtil.getPinYinHeadChar(area.getName()).substring(0, 1);
                log.debug("py:::" + py);
                if ("all".equalsIgnoreCase(type) || ("shop".equalsIgnoreCase(type) && !area.isDisabled())) {
                    if (ag.contains(py)) {
                        sbAG.append("{code: '" + area.getCode() + "', address: '" + area.getName() + "'},");
                    }
                    log.debug("sbAG:::" + sbAG.toString());
                    if (hk.contains(py)) {
                        sbHK.append("{code: '" + area.getCode() + "', address: '" + area.getName() + "'},");
                    }
                    if (ls.contains(py)) {
                        sbLS.append("{code: '" + area.getCode() + "', address: '" + area.getName() + "'},");
                    }
                    if (tz.contains(py)) {
                        sbTZ.append("{code: '" + area.getCode() + "', address: '" + area.getName() + "'},");
                    }
                }
            }
            if (sbAG.toString().length() > 1) {
                sb.append("'A-G': [" + sbAG.toString().substring(0, sbAG.toString().length() - 1) + "],\n");
            }
            if (sbHK.toString().length() > 1) {
                sb.append("'H-K': [" + sbHK.toString().substring(0, sbHK.toString().length() - 1) + "],\n");
            }
            if (sbLS.toString().length() > 1) {
                sb.append("'L-S': [" + sbLS.toString().substring(0, sbLS.toString().length() - 1) + "],\n");
            }
            if (sbTZ.toString().length() > 1) {
                sb.append("'T-Z': [" + sbTZ.toString().substring(0, sbTZ.toString().length() - 1) + "]\n");
            }
        }
        sb.append("},");
        return sb.toString();
    }

    /**
     * 得到城市数据区块
     *
     * @param list
     * @param map
     * @return
     */
    private String getJson(List<Shop_area> list, Map<String, List<Shop_area>> map, String type) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                Shop_area area = list.get(i);
                List<Shop_area> list2 = map.get(area.getPath());
                if ("all".equalsIgnoreCase(type) || ("shop".equalsIgnoreCase(type) && !area.isDisabled())) {
                    if (area.isHasChildren()) {
                        sb.append(area.getCode() + ":{");
                        sb.append(getSubJson(list2, map, type));
                        sb.append("}");
                        sb.append(",\n");
                        sb.append(getJson(list2, map, type));
                    } else {
                        sb.append(getSubJson(list2, map, type));
                    }
                }
            }
            return sb.toString();
        }
        return "";
    }

    private String getSubJson(List<Shop_area> list, Map<String, List<Shop_area>> map, String type) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                Shop_area area = list.get(i);
                if ("all".equalsIgnoreCase(type) || ("shop".equalsIgnoreCase(type) && !area.isDisabled())) {
                    sb.append(area.getCode() + ":'" + area.getName() + "'");
                    if (i < list.size() - 1) {
                        sb.append(",");
                    }
                }
            }
            return sb.toString();
        }
        return "";
    }
}
