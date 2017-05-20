package cn.wizzer.app.web.modules.controllers.platform.goods;

import cn.wizzer.app.goods.modules.models.*;
import cn.wizzer.app.goods.modules.services.*;
import cn.wizzer.app.member.modules.services.MemberLevelService;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.adaptor.WhaleAdaptor;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/goods/goods")
public class GoodsGoodsController {
    private static final Log log = Logs.get();
    @Inject
    private GoodsGoodsService shopGoodsService;
    @Inject
    private GoodsTypeService shopGoodsTypeService;
    @Inject
    private GoodsClassService shopGoodsClassService;
    @Inject
    private GoodsSpecService shopGoodsSpecService;
    @Inject
    private GoodsTypeParamgService shopGoodsTypeParamgService;
    @Inject
    private GoodsTypePropsService shopGoodsTypePropsService;
    @Inject
    private GoodsTypeBrandService shopGoodsTypeBrandService;
    @Inject
    private GoodsTypeSpecService shopGoodsTypeSpecService;
    @Inject
    private GoodsProductsService shopGoodsProductsService;
    @Inject
    private MemberLevelService memberLevelService;
    @Inject
    private GoodsLvPriceService shopGoodsLvPriceService;
    @Inject
    private GoodsImagesService shopGoodsImagesService;
    @Inject
    private GoodsBrandService shopGoodsBrandService;
    @Inject
    private GoodsTagService shopGoodsTagService;

    @At("")
    @Ok("beetl:/platform/goods/goods/index.html")
    @RequiresAuthentication
    public void index(HttpServletRequest req) {

    }

    /**
     * 获取商品分类及分类的商品类型
     *
     * @param id
     * @return
     */
    @At("/getClass/?")
    @Ok("json")
    @RequiresAuthentication
    public Object getClass(String id) {
        return Result.success("", shopGoodsClassService.fetchLinks(shopGoodsClassService.fetch(id), "goodsType"));
    }

    /**
     * 获取商品类型信息
     *
     * @param id
     * @return
     */
    @At("/getType/?")
    @Ok("json")
    @RequiresAuthentication
    public Object getType(String id) {
        return Result.success("", shopGoodsTypeService.fetch(id));
    }

    /**
     * 获取商品类型的扩展属性
     *
     * @param id
     * @return
     */
    @At("/getProps/?")
    @Ok("json")
    @RequiresAuthentication
    public Object getProps(String id) {
        List<Goods_type_props> list = shopGoodsTypePropsService.query(Cnd.where("typeId", "=", id).asc("location"));
        shopGoodsTypePropsService.fetchLinks(list, "propsValues", Cnd.orderBy().asc("location"));
        return Result.success("", list);
    }

    /**
     * 获取商品类型的详细参数
     *
     * @param id
     * @return
     */
    @At("/getParam/?")
    @Ok("json")
    @RequiresAuthentication
    public Object getParam(String id) {
        List<Goods_type_paramg> list = shopGoodsTypeParamgService.query(Cnd.where("typeId", "=", id).asc("location"));
        shopGoodsTypeParamgService.fetchLinks(list, "params", Cnd.orderBy().asc("location"));
        return Result.success("", list);
    }

    /**
     * 通过商品类型获取品牌
     *
     * @param id
     * @return
     */
    @At("/getBrand/?")
    @Ok("json")
    @RequiresAuthentication
    public Object getBrand(String id) {
        List<Goods_type_brand> list = shopGoodsTypeBrandService.query(Cnd.where("typeId", "=", id).asc("location"));
        shopGoodsTypeBrandService.fetchLinks(list, "brand", Cnd.orderBy().asc("location"));
        return Result.success("", list);
    }

    /**
     * 商品添加页面
     *
     * @param req
     */
    @At
    @Ok("beetl:/platform/goods/goods/add.html")
    @RequiresAuthentication
    public void add(HttpServletRequest req) {
        req.setAttribute("typeList", shopGoodsTypeService.query());
        req.setAttribute("lvList", memberLevelService.query(Cnd.orderBy().asc("point")));
    }

    /**
     * 开启规格页面
     *
     * @param id
     * @param sku
     * @param req
     */
    @At({"/spec/?/?", "/spec/?/"})
    @Ok("beetl:/platform/goods/goods/spec.html")
    @RequiresAuthentication
    public void spec(String id, String sku, HttpServletRequest req) {
        List<Goods_type_spec> typeSpecList = shopGoodsTypeSpecService.query(Cnd.where("typeId", "=", id).asc("location"));
        shopGoodsTypeSpecService.fetchLinks(typeSpecList, null, Cnd.orderBy().asc("location"));
        if (Strings.isEmpty(Strings.sNull(sku).trim())) {
            sku = shopGoodsProductsService.getSkuPrefix();
        }
        req.setAttribute("sku", sku.toUpperCase());
        req.setAttribute("specList", typeSpecList);
        req.setAttribute("lvList", memberLevelService.query(Cnd.orderBy().asc("point")));
    }


    @At
    @Ok("json")
    @RequiresPermissions("goods.manager.goods.add")
    @SLog(tag = "新建商品", msg = "商品名称:${args[0].name}")
    @AdaptBy(type = WhaleAdaptor.class)
    //uploadifive上传文件后contentTypy改变,需要用WhaleAdaptor接收参数
    public Object addDo(@Param("..") Goods_goods shopGoods, @Param("products") String products, @Param("spec_values") String spec_values, @Param("prop_values") String prop_values, @Param("param_values") String param_values,
                        @Param("images") String images,
                        HttpServletRequest req) {
        try {
            return Result.success("system.success", shopGoodsService.add(shopGoods, products, spec_values, prop_values, param_values, images));
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/edit/?")
    @Ok("beetl:/platform/goods/goods/edit.html")
    @RequiresAuthentication
    public Object edit(String id, HttpServletRequest req) {
        //获取商品信息
        Goods_goods obj = shopGoodsService.fetch(id);
        //获取商品类型对应的属性信息
        List<Goods_type_props> typePropList = shopGoodsTypePropsService.query(Cnd.where("typeId", "=", obj.getTypeId()).asc("location"));
        shopGoodsTypePropsService.fetchLinks(typePropList, "propsValues", Cnd.orderBy().asc("location"));
        //获取商品类型对应的参数信息
        List<Goods_type_paramg> typeParamgList = shopGoodsTypeParamgService.query(Cnd.where("typeId", "=", obj.getTypeId()).asc("location"));
        shopGoodsTypeParamgService.fetchLinks(typeParamgList, "params", Cnd.orderBy().asc("location"));
        //获取商品类型对应的规格信息
        List<Goods_type_spec> typeSpecList = shopGoodsTypeSpecService.query(Cnd.where("typeId", "=", obj.getTypeId()).asc("location"));
        shopGoodsTypeSpecService.fetchLinks(typeSpecList, null, Cnd.orderBy().asc("location"));
        //组装商品各类关联表数据
        shopGoodsService.fetchLinks(obj, null, Cnd.orderBy().asc("location"));
        List<Goods_product> productsList = obj.getProductList();
        //取出货品对应的会员价格数据
        shopGoodsProductsService.fetchLinks(productsList, "lvPriceList");
        req.setAttribute("specList", typeSpecList);
        req.setAttribute("typePropList", typePropList);
        req.setAttribute("typeParamgList", typeParamgList);
        req.setAttribute("typeList", shopGoodsTypeService.query());
        req.setAttribute("lvList", memberLevelService.query(Cnd.orderBy().asc("point")));
        req.setAttribute("productNum", productsList.size());
        //在页面上显示商品类型管理的品牌
        req.setAttribute("brandList", shopGoodsBrandService.list(Sqls.create("SELECT a.id,a.name FROM goods_brand a,goods_type_brand b WHERE a.id=b.brandId AND b.typeId=@typeId").setParam("typeId", obj.getTypeId())));
        return obj;
    }

    @At
    @Ok("json")
    @RequiresPermissions("goods.manager.goods.edit")
    @SLog(tag = "修改商品", msg = "商品名称:${args[0].name}")
    @AdaptBy(type = WhaleAdaptor.class)
    //uploadifive上传文件后contentTypy改变,需要用WhaleAdaptor接收参数
    public Object editDo(@Param("..") Goods_goods shopGoods, @Param("products") String products, @Param("spec_values") String spec_values, @Param("prop_values") String prop_values, @Param("param_values") String param_values,
                         @Param("images") String images,
                         HttpServletRequest req) {
        try {
            return Result.success("system.success", shopGoodsService.save(shopGoods, products, spec_values, prop_values, param_values, images, Strings.sNull(req.getAttribute("uid"))));
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    /**
     * 商品列表页
     *
     * @param length
     * @param start
     * @param draw
     * @param order
     * @param columns
     * @return
     */
    @At
    @Ok("json:{locked:'note|prop|param|spec',ignoreNull:false}")
    @RequiresAuthentication
    public Object data(@Param("name") String name, @Param("disabled") String disabled, @Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        if (!Strings.isBlank(name)) {
            cnd.and("name", "like", "%" + name + "%");
        }
        if (!Strings.isBlank(disabled)) {
            switch (disabled) {
                case "1":
                    cnd.and("disabled", "=", true);
                    break;
                case "0":
                    cnd.and("disabled", "=", false);
                    break;
            }
        }
        return shopGoodsService.data(length, start, draw, order, columns, cnd, "^(tags|goodsClass|goodsType)$");
    }


    @At({"/delete", "/delete/?"})
    @Ok("json")
    @RequiresPermissions("goods.manager.goods.delete")
    @SLog(tag = "删除商品", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids, HttpServletRequest req) {
        try {
            if (ids != null && ids.length > 0) {
                shopGoodsService.deleteProdcut(ids);
                req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
            } else {
                shopGoodsService.deleteProdcut(id);
                req.setAttribute("id", id);
            }
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    /**
     * 显示商品标签
     *
     * @param ids
     * @param req
     * @return
     */
    @At("/showTag")
    @Ok("beetl:/platform/goods/goods/tag.html")
    @RequiresAuthentication
    public Object showTag(@Param("ids") String[] ids, HttpServletRequest req) {
        req.setAttribute("tagLink", shopGoodsTagService.list(Sqls.create("SELECT * FROM goods_tag_link WHERE goodsId in (@ids)").setParam("ids", ids)));
        return shopGoodsTagService.query(Cnd.orderBy().desc("location"));
    }

    /**
     * 保存商品标签
     *
     * @param goodsIds
     * @param tagIds
     * @return
     */
    @At("/saveTag")
    @Ok("json")
    public Object saveTag(@Param("goodsIds") String[] goodsIds, @Param("tagIds") String[] tagIds) {
        try {
            Sql sql = Sqls.create("insert into goods_tag_link(goodsId,tagId) values(@a,@b)");
            Sql dsql = Sqls.create("delete from goods_tag_link where goodsId in (@ids)").setParam("ids", goodsIds);
            for (String s : goodsIds) {
                for (String t : tagIds) {
                    sql.setParam("a", s).setParam("b", t);
                    sql.addBatch();
                }
            }
            shopGoodsTagService.dao().execute(dsql);
            shopGoodsTagService.dao().execute(sql);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    /**
     * 商品排序
     *
     * @param pk
     * @param name
     * @param value
     * @return
     */
    @At("/location")
    @Ok("json")
    @RequiresAuthentication
    public Object location(@Param("pk") String pk, @Param("name") String name, @Param("value") int value) {
        shopGoodsService.update(Chain.make("location", value), Cnd.where("id", "=", pk));
        NutMap nutMap = new NutMap();
        nutMap.addv("name", name);
        nutMap.addv("pk", pk);
        nutMap.addv("value", value);
        return nutMap;
    }

    /**
     * 显示货品列表，上下架操作
     *
     * @param goodsId
     * @param req
     * @return
     */
    @At("/updown/?")
    @Ok("beetl:/platform/goods/goods/updown.html")
    @RequiresAuthentication
    public Object updown(String goodsId, HttpServletRequest req) {
        req.setAttribute("goodsId", goodsId);
        return shopGoodsProductsService.query(Cnd.where("goodsId", "=", goodsId).desc("location"));
    }

    /**
     * 上下架
     *
     * @param goodsId
     * @param ids
     * @param req
     * @return
     */
    @At("/updownDo")
    @Ok("json")
    @RequiresAuthentication
    public Object updownDo(@Param("goodsId") String goodsId, @Param("ids") String ids, HttpServletRequest req) {
        try {
            shopGoodsService.updown(goodsId, ids, Strings.sNull(req.getAttribute("uid")));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    /**
     * 批量上架
     *
     * @param ids
     * @param req
     * @return
     */
    @At("/up")
    @Ok("json")
    @RequiresAuthentication
    public Object up(@Param("ids") String[] ids, HttpServletRequest req) {
        try {
            shopGoodsService.updowns(ids, false, Strings.sNull(req.getAttribute("uid")));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    /**
     * 批量下架
     *
     * @param ids
     * @param req
     * @return
     */
    @At("/down")
    @Ok("json")
    @RequiresAuthentication
    public Object down(@Param("ids") String[] ids, HttpServletRequest req) {
        try {
            shopGoodsService.updowns(ids, true, Strings.sNull(req.getAttribute("uid")));
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

}
