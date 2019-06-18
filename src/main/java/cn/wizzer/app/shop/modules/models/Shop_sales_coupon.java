package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;

/**
 * 营销优惠券表
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_sales_coupon  extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @PrevInsert(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("优惠券名称")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String name;

    @Column
    @Comment("抵扣金额")
    @ColDefine(type = ColType.INT)
    private Integer money;

    @Column
    @Comment("最大发放量")
    @ColDefine(type = ColType.INT)
    private Integer num_max;

    @Column
    @Comment("已发放量")
    @ColDefine(type = ColType.INT)
    private Integer num_used;

    @Column
    @Comment("可积分兑换")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean score_enabled;

    @Column
    @Comment("所需积分")
    @ColDefine(type = ColType.INT)
    private Integer score;

    @Column
    @Comment("有效天数")
    @ColDefine(type = ColType.INT)
    private Integer can_use_day;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getNum_max() {
        return num_max;
    }

    public void setNum_max(Integer num_max) {
        this.num_max = num_max;
    }

    public Integer getNum_used() {
        return num_used;
    }

    public void setNum_used(Integer num_used) {
        this.num_used = num_used;
    }

    public Boolean getScore_enabled() {
        return score_enabled;
    }

    public void setScore_enabled(Boolean score_enabled) {
        this.score_enabled = score_enabled;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCan_use_day() {
        return can_use_day;
    }

    public void setCan_use_day(Integer can_use_day) {
        this.can_use_day = can_use_day;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
