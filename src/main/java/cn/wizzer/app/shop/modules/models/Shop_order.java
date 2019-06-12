package cn.wizzer.app.shop.modules.models;

import cn.wizzer.app.shop.commons.enums.*;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 订单表
 * Created by wizzer on 2019/6/12
 */
@Table
@TableIndexes({@Index(name = "IDX_SHOP_ORDER_STATUS", fields = {"order_status", "pay_status", "send_status", "assess_status"}, unique = false)})
public class Shop_order extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
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
    @Comment("sku")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sku;

    @Column
    @Comment("城市ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String cityId;

    @Column
    @Comment("订单状态(0-活动/1-已取消/2-已完成/3-已删除)")
    @ColDefine(type = ColType.INT)
    private ShopOrderOrderStatus order_status;

    @Column
    @Comment("付款状态(0-待支付/1-已付款/2-申请退款/3-已退款)")
    @ColDefine(type = ColType.INT)
    private ShopOrderPayStatus pay_status;

    @Column
    @Comment("发货状态(0-待发货/1-已发货/2-已收货/3-申请退货/4-已退货)")
    @ColDefine(type = ColType.INT)
    private ShopOrderSendStatus send_status;

    @Column
    @Comment("评价状态(0-待评价/1-已评价)")
    @ColDefine(type = ColType.INT)
    private ShopOrderAssessStatus assess_status;

    @Column
    @Comment("订单商品总重")
    @ColDefine(type = ColType.INT)
    private Integer order_weight;

    @Column
    @Comment("订单商品积分")
    @ColDefine(type = ColType.INT)
    private Integer order_score;

    @Column
    @Comment("订单商品总价")
    @ColDefine(type = ColType.INT)
    private Integer order_goods_money;

    @Column
    @Comment("订单运费")
    @ColDefine(type = ColType.INT)
    private Integer order_freight_money;

    @Column
    @Comment("优惠券抵扣")
    @ColDefine(type = ColType.INT)
    private Integer order_coupon_money;

    @Column
    @Comment("店铺优惠(负值为增加)")
    @ColDefine(type = ColType.INT)
    private Integer order_discount_money;

    @Column
    @Comment("订单总金额")
    @ColDefine(type = ColType.INT)
    private Integer order_finish_money;

    @Column
    @Comment("订单已支付金额(考虑部分支付情况)")
    @ColDefine(type = ColType.INT)
    private Integer order_pay_money;

    @Column
    @Comment("会员等级价")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean used_member_level_price;

    @Column
    @Comment("使用优惠券")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean used_member_coupon;

    @Column
    @Comment("商品数量")
    @ColDefine(type = ColType.INT)
    private Integer order_goods_num;

    @Column
    @Comment("配送方式")
    @ColDefine(type = ColType.INT)
    private ShopOrderSendType send_type;

    @Column
    @Comment("物流公司编号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String send_logistics_code;

    @Column
    @Comment("物流公司名称")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String send_logistics_name;

    @Column
    @Comment("快递单号")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String send_logistics_sn;

    @Column
    @Comment("是否开票")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean tax_has;

    @Column
    @Comment("发票类型(0-个人/1-企业)")
    @ColDefine(type = ColType.INT, width = 1)
    private Integer tax_type;

    @Column
    @Comment("发票税号")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String tax_no;

    @Column
    @Comment("发票抬头")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String tax_title;

    @Column
    @Comment("订单时间")
    private Long order_time;

    @Column
    @Comment("订单IP")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String order_ip;

    @Column
    @Comment("收货时间")
    private Long received_time;

    @Column
    @Comment("收货状态")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private ShopOrderReceivedStatus received_status;

    @Column
    @Comment("订单来源")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private ShopOrderOrderSource order_source;

    @Column
    @Comment("订单备注")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String member_memo;

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

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public ShopOrderOrderStatus getOrder_status() {
        return order_status;
    }

    public void setOrder_status(ShopOrderOrderStatus order_status) {
        this.order_status = order_status;
    }

    public ShopOrderPayStatus getPay_status() {
        return pay_status;
    }

    public void setPay_status(ShopOrderPayStatus pay_status) {
        this.pay_status = pay_status;
    }

    public ShopOrderSendStatus getSend_status() {
        return send_status;
    }

    public void setSend_status(ShopOrderSendStatus send_status) {
        this.send_status = send_status;
    }

    public ShopOrderAssessStatus getAssess_status() {
        return assess_status;
    }

    public void setAssess_status(ShopOrderAssessStatus assess_status) {
        this.assess_status = assess_status;
    }

    public Integer getOrder_weight() {
        return order_weight;
    }

    public void setOrder_weight(Integer order_weight) {
        this.order_weight = order_weight;
    }

    public Integer getOrder_score() {
        return order_score;
    }

    public void setOrder_score(Integer order_score) {
        this.order_score = order_score;
    }

    public Integer getOrder_goods_money() {
        return order_goods_money;
    }

    public void setOrder_goods_money(Integer order_goods_money) {
        this.order_goods_money = order_goods_money;
    }

    public Integer getOrder_freight_money() {
        return order_freight_money;
    }

    public void setOrder_freight_money(Integer order_freight_money) {
        this.order_freight_money = order_freight_money;
    }

    public Integer getOrder_coupon_money() {
        return order_coupon_money;
    }

    public void setOrder_coupon_money(Integer order_coupon_money) {
        this.order_coupon_money = order_coupon_money;
    }

    public Integer getOrder_discount_money() {
        return order_discount_money;
    }

    public void setOrder_discount_money(Integer order_discount_money) {
        this.order_discount_money = order_discount_money;
    }

    public Integer getOrder_finish_money() {
        return order_finish_money;
    }

    public void setOrder_finish_money(Integer order_finish_money) {
        this.order_finish_money = order_finish_money;
    }

    public Integer getOrder_pay_money() {
        return order_pay_money;
    }

    public void setOrder_pay_money(Integer order_pay_money) {
        this.order_pay_money = order_pay_money;
    }

    public Boolean getUsed_member_level_price() {
        return used_member_level_price;
    }

    public void setUsed_member_level_price(Boolean used_member_level_price) {
        this.used_member_level_price = used_member_level_price;
    }

    public Boolean getUsed_member_coupon() {
        return used_member_coupon;
    }

    public void setUsed_member_coupon(Boolean used_member_coupon) {
        this.used_member_coupon = used_member_coupon;
    }

    public Integer getOrder_goods_num() {
        return order_goods_num;
    }

    public void setOrder_goods_num(Integer order_goods_num) {
        this.order_goods_num = order_goods_num;
    }

    public ShopOrderSendType getSend_type() {
        return send_type;
    }

    public void setSend_type(ShopOrderSendType send_type) {
        this.send_type = send_type;
    }

    public String getSend_logistics_code() {
        return send_logistics_code;
    }

    public void setSend_logistics_code(String send_logistics_code) {
        this.send_logistics_code = send_logistics_code;
    }

    public String getSend_logistics_name() {
        return send_logistics_name;
    }

    public void setSend_logistics_name(String send_logistics_name) {
        this.send_logistics_name = send_logistics_name;
    }

    public String getSend_logistics_sn() {
        return send_logistics_sn;
    }

    public void setSend_logistics_sn(String send_logistics_sn) {
        this.send_logistics_sn = send_logistics_sn;
    }

    public Boolean getTax_has() {
        return tax_has;
    }

    public void setTax_has(Boolean tax_has) {
        this.tax_has = tax_has;
    }

    public Integer getTax_type() {
        return tax_type;
    }

    public void setTax_type(Integer tax_type) {
        this.tax_type = tax_type;
    }

    public String getTax_no() {
        return tax_no;
    }

    public void setTax_no(String tax_no) {
        this.tax_no = tax_no;
    }

    public String getTax_title() {
        return tax_title;
    }

    public void setTax_title(String tax_title) {
        this.tax_title = tax_title;
    }

    public Long getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Long order_time) {
        this.order_time = order_time;
    }

    public String getOrder_ip() {
        return order_ip;
    }

    public void setOrder_ip(String order_ip) {
        this.order_ip = order_ip;
    }

    public Long getReceived_time() {
        return received_time;
    }

    public void setReceived_time(Long received_time) {
        this.received_time = received_time;
    }

    public ShopOrderReceivedStatus getReceived_status() {
        return received_status;
    }

    public void setReceived_status(ShopOrderReceivedStatus received_status) {
        this.received_status = received_status;
    }

    public ShopOrderOrderSource getOrder_source() {
        return order_source;
    }

    public void setOrder_source(ShopOrderOrderSource order_source) {
        this.order_source = order_source;
    }

    public String getMember_memo() {
        return member_memo;
    }

    public void setMember_memo(String member_memo) {
        this.member_memo = member_memo;
    }
}
