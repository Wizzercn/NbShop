package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;

/**
 * 优惠券发放记录表
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_sales_coupon_log extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @PrevInsert(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("优惠券ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String couponId;

    @Column
    @Comment("会员ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String memberId;

    @Column
    @Comment("发放方式(self-自己领取/send-管理员发放)")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String type;

    @Column
    @Comment("发放数量")
    @ColDefine(type = ColType.INT)
    private Integer num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
