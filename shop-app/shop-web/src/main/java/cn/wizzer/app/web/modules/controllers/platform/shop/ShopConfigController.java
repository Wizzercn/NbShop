package cn.wizzer.app.web.modules.controllers.platform.shop;

import cn.wizzer.app.shop.modules.services.ShopEstempService;
import cn.wizzer.app.web.commons.ext.es.EsService;
import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.shop.modules.models.Shop_config;
import cn.wizzer.app.shop.modules.services.ShopConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Sqls;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;

@IocBean
@At("/platform/shop/config")
public class ShopConfigController {
    private static final Log log = Logs.get();
    @Inject
    private ShopConfigService shopConfigService;
    @Inject
    private EsService esService;
    @Inject
    private ShopEstempService shopEstempService;
    @Inject
    private PropertiesProxy cfg;

    @At("")
    @Ok("beetl:/platform/shop/config/index.html")
    @RequiresPermissions("shop.config.config")
    public void index(HttpServletRequest req) {
        Shop_config config = shopConfigService.fetch("system");
        req.setAttribute("logistics_info", Json.fromJson(NutMap.class, Strings.sNull(config.getLogistics_info())));
        req.setAttribute("oauth_qq_info", Json.fromJson(NutMap.class, Strings.sNull(config.getOauth_qq_info())));
        req.setAttribute("oauth_wechat_info", Json.fromJson(NutMap.class, Strings.sNull(config.getOauth_wechat_info())));
        req.setAttribute("img_qiniu_info", Json.fromJson(NutMap.class, Strings.sNull(config.getImg_qiniu_info())));
        req.setAttribute("obj", config);
        req.setAttribute("indexName", cfg.get("es.index.name", "nutzshop"));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("shop.config.config.update")
    @SLog(tag = "Shop_config", msg = "${args[0].id}")
    public Object editDo(@Param("..") Shop_config shopConfig, HttpServletRequest req) {
        try {
            shopConfig.setOpBy(StringUtil.getUid());
            shopConfig.setOpAt((int) (System.currentTimeMillis() / 1000));
            shopConfigService.updateIgnoreNull(shopConfig);
            shopConfigService.clearCache();
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/es/?")
    @Ok("json")
    public Object es(String indexName) {
        return Result.success("system.success", esService.isExistsIndex(indexName));
    }

    @At("/esindex/?")
    @Ok("json")
    @RequiresPermissions("shop.config.config.update")
    public Object esindex(String indexName) {
        try {
            if (esService.isExistsIndex(indexName)) {
                esService.deleteIndex(indexName);
            }
            esService.createIndex(indexName);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/esdata/")
    @Ok("json")
    @RequiresPermissions("shop.config.config.update")
    public Object esdata() {
        try {
            shopEstempService.clear();
            shopEstempService.dao().execute(Sqls.create("INSERT INTO shop_estemp(id,goodsid,ACTION,opAt) SELECT id,id,'create',0 FROM goods_goods WHERE delFlag=@f").setParam("f", false));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/escount")
    @Ok("json")
    public Object count() {
        try {
            return Result.success("globals.result.success", shopEstempService.count());
        } catch (Exception e) {
            return Result.error("globals.result.error");
        }
    }
}
