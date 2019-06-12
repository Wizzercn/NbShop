package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 订单商品表
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_order_goods extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("订单ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String orderId;

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
    @Comment("sku")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sku;

    @Column
    @Comment("商品名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String goods_name;

    @Column
    @Comment("规格名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String spec_name;

    @Column
    @Comment("购买时商品价")
    @ColDefine(type = ColType.INT)
    private Integer price;

    @Column
    @Comment("实际购买价(会员等级计算)")
    @ColDefine(type = ColType.INT)
    private Integer buy_price;

    @Column
    @Comment("购买数量")
    @ColDefine(type = ColType.INT)
    private Integer buy_num;

    @Column
    @Comment("发货数量")
    @ColDefine(type = ColType.INT)
    private Integer send_num;

    @Column
    @Comment("总积分")
    @ColDefine(type = ColType.INT)
    private Integer goods_score;

    @Column
    @Comment("总金额")
    @ColDefine(type = ColType.INT)
    private Integer goods_money;

    @Column
    @Comment("总重量")
    @ColDefine(type = ColType.INT)
    private Integer goods_weight;

    @Column
    @Comment("商品图片")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String picurl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Integer getSend_num() {
        return send_num;
    }

    public void setSend_num(Integer send_num) {
        this.send_num = send_num;
    }

    public Integer getGoods_score() {
        return goods_score;
    }

    public void setGoods_score(Integer goods_score) {
        this.goods_score = goods_score;
    }

    public Integer getGoods_money() {
        return goods_money;
    }

    public void setGoods_money(Integer goods_money) {
        this.goods_money = goods_money;
    }

    public Integer getGoods_weight() {
        return goods_weight;
    }

    public void setGoods_weight(Integer goods_weight) {
        this.goods_weight = goods_weight;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}
