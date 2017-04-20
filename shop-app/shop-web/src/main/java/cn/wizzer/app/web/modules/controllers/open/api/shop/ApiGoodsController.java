package cn.wizzer.app.web.modules.controllers.open.api.shop;

import cn.wizzer.app.shop.modules.models.Shop_goods;
import cn.wizzer.app.shop.modules.services.ShopGoodsProductsService;
import cn.wizzer.app.shop.modules.services.ShopGoodsService;
import cn.wizzer.app.sys.modules.models.Sys_api;
import cn.wizzer.app.sys.modules.services.SysApiService;
import cn.wizzer.app.web.commons.filter.TokenFilter;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.OffsetPager;
import cn.wizzer.framework.page.Pagination;
import cn.wizzer.framework.util.DateUtil;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wizzer on 2016/8/11.
 */
@IocBean
@At("/open/api/goods")
@Filters({@By(type = TokenFilter.class)})
public class ApiGoodsController {
    private static final Log log = Logs.get();
    @Inject
    private ShopGoodsProductsService shopGoodsProductsService;
    @Inject
    private ShopGoodsService shopGoodsService;

    @At("/list")
    @Ok("json")
    @AdaptBy(type = JsonAdaptor.class)
    @POST
    public Object list(@Param("..") NutMap params) {
        try {
            int pageSize = params.getInt("pageSize", 5);
            int pageNum = params.getInt("pageNum", 1);
            Sql sql = Sqls.create("SELECT a.id,a.name,a.title,a.classID,a.typeId,a.imgurl,b.* FROM shop_goods a,shop_goods_products b " +
                    " WHERE a.id=b.goodsId AND b.isDefault=TRUE AND a.disabled=FALSE AND b.disabled=FALSE ORDER BY a.location desc");
            Pager pager = new OffsetPager((pageNum - 1) * pageSize, pageSize);
            sql.setPager(pager);
            List list = shopGoodsService.list(sql);
            return Result.success("ok", list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("fail");
        }
    }

    @At("/one")
    @Ok("json")
    @AdaptBy(type = JsonAdaptor.class)
    public Object one(@Param("..") NutMap params) {
        try {
            String id = params.getString("id", "");
            Shop_goods goods = shopGoodsService.fetch(id);
            shopGoodsService.fetchLinks(goods, "^imagesList|productsList|tags*", Cnd.orderBy().asc("location"));
            return Result.success("ok", goods);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("fail");
        }
    }
}
