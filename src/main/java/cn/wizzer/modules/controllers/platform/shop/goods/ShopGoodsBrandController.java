package cn.wizzer.modules.controllers.platform.shop.goods;

import cn.wizzer.common.annotation.SLog;
import cn.wizzer.common.base.Result;
import cn.wizzer.common.filter.PrivateFilter;
import cn.wizzer.common.page.DataTableColumn;
import cn.wizzer.common.page.DataTableOrder;
import cn.wizzer.modules.models.shop.Shop_goods_brand;
import cn.wizzer.modules.services.shop.goods.ShopGoodsBrandService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@At("/platform/shop/goods/brand")
@Filters({@By(type = PrivateFilter.class)})
public class ShopGoodsBrandController {
	private static final Log log = Logs.get();
	@Inject
	private ShopGoodsBrandService shopGoodsBrandService;

	@At("")
	@Ok("beetl:/platform/shop/goods/brand/index.html")
	@RequiresAuthentication
	public void index() {

	}

	@At
	@Ok("json:full")
	@RequiresAuthentication
	public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return shopGoodsBrandService.data(length, start, draw, order, columns, cnd, null);
    }

    @At
    @Ok("beetl:/platform/shop/goods/brand/add.html")
    @RequiresAuthentication
    public void add() {

    }

    @At
    @Ok("json")
    @SLog(tag = "新建品牌", msg = "新建品牌")
	@RequiresPermissions("shop.goods.conf.brand.add")
	@AdaptBy(type = WhaleAdaptor.class)
    public Object addDo(@Param("..") Shop_goods_brand shopGoodsBrand, HttpServletRequest req) {
		try {
			shopGoodsBrandService.insert(shopGoodsBrand);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/shop/goods/brand/edit.html")
    @RequiresAuthentication
    public Object edit(String id) {
		return shopGoodsBrandService.fetch(id);
    }

    @At
    @Ok("json")
    @SLog(tag = "修改品牌", msg = "ID:${args[0].id}")
	@RequiresPermissions("shop.goods.conf.brand.edit")
	@AdaptBy(type = WhaleAdaptor.class)
	public Object editDo(@Param("..") Shop_goods_brand shopGoodsBrand, HttpServletRequest req) {
		try {

			shopGoodsBrand.setOpAt((int) (System.currentTimeMillis() / 1000));
			shopGoodsBrandService.updateIgnoreNull(shopGoodsBrand);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At({"/delete","/delete/?"})
    @Ok("json")
    @SLog(tag = "删除品牌", msg = "ID:${args[2].getAttribute('id')}")
	@RequiresPermissions("shop.goods.conf.brand.delete")
	public Object delete(String id, @Param("ids") String[] ids ,HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				shopGoodsBrandService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				shopGoodsBrandService.delete(id);
    			req.setAttribute("id", id);
			}
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

}
