package cn.wizzer.app.member.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 会员优惠券表
 * Created by wizzer on 2016/9/27.
 */
@Table("member_coupon")
public class Member_coupon extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("会员ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String memberId;

    @Column
    @Comment("优惠券ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String coupon_id;

    @Column
    @Comment("优惠券名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String coupon_name;

    @Column
    @Comment("优惠券金额")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer coupon_money;

    @Column
    @Comment("获取时间")
    @ColDefine(type = ColType.INT)
    private Integer createAt;

    @Column
    @Comment("使用时间")
    @ColDefine(type = ColType.INT)
    private Integer orderAt;

    @Column
    @Comment("订单ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String orderId;

    @Column
    @Comment("优惠券状态")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer status;//0 未使用 1 已使用  2 已失效

    @One(target = Member_user.class, field = "memberId")
    private Member_user memberUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon_name() {
        return coupon_name;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name;
    }

    public Integer getCoupon_money() {
        return coupon_money;
    }

    public void setCoupon_money(Integer coupon_money) {
        this.coupon_money = coupon_money;
    }

    public Integer getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Integer createAt) {
        this.createAt = createAt;
    }

    public Integer getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(Integer orderAt) {
        this.orderAt = orderAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Member_user getMemberUser() {
        return memberUser;
    }

    public void setMemberUser(Member_user memberUser) {
        this.memberUser = memberUser;
    }
}
