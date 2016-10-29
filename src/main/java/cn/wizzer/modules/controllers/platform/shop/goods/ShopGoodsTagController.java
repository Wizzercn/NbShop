package cn.wizzer.modules.controllers.platform.shop.goods;

import cn.wizzer.common.annotation.SLog;
import cn.wizzer.common.base.Result;
import cn.wizzer.common.filter.PrivateFilter;
import cn.wizzer.common.page.DataTableColumn;
import cn.wizzer.common.page.DataTableOrder;
import cn.wizzer.modules.models.shop.*;
import cn.wizzer.modules.services.shop.goods.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.adaptor.WhaleAdaptor;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/shop/goods/goods/tag")
@Filters({@By(type = PrivateFilter.class)})
public class ShopGoodsTagController {
    private static final Log log = Logs.get();
    @Inject
    private ShopGoodsTagService shopGoodsTagService;

    @At("")
    @Ok("beetl:/platform/shop/goods/tag/index.html")
    @RequiresAuthentication
    public void index(HttpServletRequest req) {

    }

    @At
    @Ok("beetl:/platform/shop/goods/tag/add.html")
    @RequiresAuthentication
    public void add(HttpServletRequest req) {

    }

    @At
    @Ok("json")
    @RequiresAuthentication
    @SLog(tag = "新建标签", msg = "标签名称:${args[0].name}")
    @AdaptBy(type = WhaleAdaptor.class)
    //uploadifive上传文件后contentTypy改变,需要用WhaleAdaptor接收参数
    public Object addDo(@Param("..") Shop_goods_tag shopGoodsTag, HttpServletRequest req) {
        try {
            return Result.success("system.success", shopGoodsTagService.insert(shopGoodsTag));
        } catch (Exception e) {
            return Result.error("system.error" + ":请检查货号是否已被占用");
        }
    }

    @At("/edit/?")
    @Ok("beetl:/platform/shop/goods/tag/edit.html")
    @RequiresAuthentication
    public Object edit(String id, HttpServletRequest req) {
        return shopGoodsTagService.fetch(id);
    }

    @At
    @Ok("json")
    @RequiresAuthentication
    @SLog(tag = "修改商品", msg = "商品名称:${args[0].name}")
    @AdaptBy(type = WhaleAdaptor.class)
    //uploadifive上传文件后contentTypy改变,需要用WhaleAdaptor接收参数
    public Object editDo(@Param("..") Shop_goods_tag shopGoodsTag, HttpServletRequest req) {
        try {
            shopGoodsTag.setOpAt((int) (System.currentTimeMillis() / 1000));
            shopGoodsTagService.updateIgnoreNull(shopGoodsTag);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At
    @Ok("json:full")
    @RequiresAuthentication
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        return shopGoodsTagService.data(length, start, draw, order, columns, cnd, null);
    }


    @At({"/delete", "/delete/?"})
    @Ok("json")
    @RequiresAuthentication
    @SLog(tag = "删除标签", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids, HttpServletRequest req) {
        try {
            if (ids != null && ids.length > 0) {
                shopGoodsTagService.delete(ids);
                req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
            } else {
                shopGoodsTagService.delete(id);
                req.setAttribute("id", id);
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

}
