package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;

/**
 * 会员购物车表
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_member_cart extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @PrevInsert(els = {@EL("uuid()")})
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
    @Comment("商品名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String goods_name;

    @Column
    @Comment("sku")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sku;

    @Column
    @Comment("规格名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String spec_name;

    @Column
    @Comment("商品图片")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String picurl;

    @Column
    @Comment("购买时商品价")
    @ColDefine(type = ColType.INT)
    private Integer buy_price;

    @Column
    @Comment("购买数量")
    @ColDefine(type = ColType.INT)
    private Integer buy_num;

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getSpec_name() {
        return spec_name;
    }

    public void setSpec_name(String spec_name) {
        this.spec_name = spec_name;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public Integer getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(Integer buy_price) {
        this.buy_price = buy_price;
    }

    public Integer getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(Integer buy_num) {
        this.buy_num = buy_num;
    }
}
