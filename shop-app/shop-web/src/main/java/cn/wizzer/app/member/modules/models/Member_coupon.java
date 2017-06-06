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
    @Comment("优惠券名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String coupon_name;

    @Column
    @Comment("优惠券金额")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String coupon_money;

    @Column
    @Comment("获取时间")
    @ColDefine(type = ColType.INT)
    private Integer getAt;

}
