package cn.wizzer.modules.controllers.platform.shop.goods;

import cn.wizzer.common.annotation.SLog;
import cn.wizzer.common.base.Result;
import cn.wizzer.common.filter.PrivateFilter;
import cn.wizzer.common.page.DataTableColumn;
import cn.wizzer.common.page.DataTableOrder;
import cn.wizzer.modules.models.shop.Shop_goods_type;
import cn.wizzer.modules.services.shop.goods.ShopGoodsTypeService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
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
@At("/platform/shop/goods/type")
@Filters({@By(type = PrivateFilter.class)})
public class ShopGoodsTypeController {
	private static final Log log = Logs.get();
	@Inject
	private ShopGoodsTypeService shopGoodsTypeService;

	@At("")
	@Ok("beetl:/platform/shop/goods/type/index.html")
	@RequiresAuthentication
	public void index() {

	}

	@At
	@Ok("json:full")
	@RequiresAuthentication
	public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return shopGoodsTypeService.data(length, start, draw, order, columns, cnd, null);
    }

    @At
    @Ok("beetl:/platform/shop/goods/type/add.html")
    @RequiresAuthentication
    public void add() {

    }

    @At
    @Ok("json")
    @SLog(tag = "新建商品类型", msg = "")
    public Object addDo(@Param("..") Shop_goods_type shopGoodsType, HttpServletRequest req) {
		try {
			shopGoodsTypeService.insert(shopGoodsType);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/shop/goods/type/edit.html")
    @RequiresAuthentication
    public Object edit(String id) {
		return shopGoodsTypeService.fetch(id);
    }

    @At
    @Ok("json")
    @SLog(tag = "修改商品类型", msg = "ID:${args[0].id}")
    public Object editDo(@Param("..") Shop_goods_type shopGoodsType, HttpServletRequest req) {
		try {

			shopGoodsType.setOpAt((int) (System.currentTimeMillis() / 1000));
			shopGoodsTypeService.updateIgnoreNull(shopGoodsType);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At({"/delete","/delete/?"})
    @Ok("json")
    @SLog(tag = "删除商品类型", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids ,HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				shopGoodsTypeService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				shopGoodsTypeService.delete(id);
    			req.setAttribute("id", id);
			}
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At("/detail/?")
    @Ok("beetl:/platform/shop/goods/type/detail.html")
    @RequiresAuthentication
	public Object detail(String id) {
		if (!Strings.isBlank(id)) {
			return shopGoodsTypeService.fetch(id);

		}
		return null;
    }

}
