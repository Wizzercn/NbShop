package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;

/**
 * 会员优惠券
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_member_coupon  extends BaseModel implements Serializable {
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
    @Comment("优惠券ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String couponId;

    @Column
    @Comment("优惠券名称")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String coupon_name;

    @Column
    @Comment("优惠券价格")
    @ColDefine(type = ColType.INT)
    private Integer coupon_price;

    @Column
    @Comment("使用状态(0-未使用/1-已使用)")
    @ColDefine(type = ColType.INT)
    private Integer status;

    @Column
    @Comment("获取日期")
    private Long get_time;

    @Column
    @Comment("失效日期")
    private Long end_time;

    @Column
    @Comment("订单ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String orderId;

    @Column
    @Comment("启用状态")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean disabled;

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

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCoupon_name() {
        return coupon_name;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name;
    }

    public Integer getCoupon_price() {
        return coupon_price;
    }

    public void setCoupon_price(Integer coupon_price) {
        this.coupon_price = coupon_price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getGet_time() {
        return get_time;
    }

    public void setGet_time(Long get_time) {
        this.get_time = get_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
