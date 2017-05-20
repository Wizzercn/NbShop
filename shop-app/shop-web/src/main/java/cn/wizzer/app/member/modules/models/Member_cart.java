package cn.wizzer.app.member.modules.models;

import cn.wizzer.app.goods.modules.models.Goods_goods;
import cn.wizzer.app.goods.modules.models.Goods_product;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 会员购物车表
 * Created by wizzer on 2017/3/29.
 */
@Table("member_cart")
@TableIndexes({@Index(name = "INDEX_MEMBER_USER_CART", fields = {"memberId"}, unique = false)})
public class Member_cart extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("会员ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String memberId;

    @Column
    @Comment("商品ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String goodsId;

    @Column
    @Comment("货品ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String productId;

    @Column
    @Comment("SKU")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sku;

    @Column
    @Comment("数量")
    @ColDefine(type = ColType.INT)
    private Integer num;

    @Column
    @Comment("购买价")
    @ColDefine(type = ColType.INT)
    private Integer price;

    @Column
    @Comment("商品图片")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String imgurl;

    @One(target = Goods_goods.class, field = "goodsId")
    private Goods_goods goodsGoods;

    @One(target = Goods_product.class, field = "productId")
    private Goods_product goodsProduct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Goods_goods getGoodsGoods() {
        return goodsGoods;
    }

    public void setGoodsGoods(Goods_goods goodsGoods) {
        this.goodsGoods = goodsGoods;
    }

    public Goods_product getGoodsProduct() {
        return goodsProduct;
    }

    public void setGoodsProduct(Goods_product goodsProduct) {
        this.goodsProduct = goodsProduct;
    }
}
