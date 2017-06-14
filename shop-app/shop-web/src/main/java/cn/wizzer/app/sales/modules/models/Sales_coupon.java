package cn.wizzer.app.sales.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * Created by wizzer on 2017/6/6.
 */
@Table("sales_coupon")
public class Sales_coupon extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("优惠券名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String name;

    @Column
    @Comment("金额")
    @ColDefine(type = ColType.INT)
    private Integer money;

    @Column
    @Comment("总数量")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer total_num;

    @Column
    @Comment("已发数量")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer send_num;

    @Column
    @Comment("使用期限起")
    @ColDefine(type = ColType.INT)
    private Integer limit_sartAt;

    @Column
    @Comment("使用期限至")
    @ColDefine(type = ColType.INT)
    private Integer limit_endAt;

    @Column
    @Comment("允许领取数量")
    @ColDefine(type = ColType.INT)
    @Default("1")
    private Integer limit_number;

    @Column
    @Comment("允许积分兑换")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean has_score;

    @Column
    @Comment("所需积分")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer score;

    @Column
    @Comment("是否禁用")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

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

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public Integer getSend_num() {
        return send_num;
    }

    public void setSend_num(Integer send_num) {
        this.send_num = send_num;
    }

    public Integer getLimit_sartAt() {
        return limit_sartAt;
    }

    public void setLimit_sartAt(Integer limit_sartAt) {
        this.limit_sartAt = limit_sartAt;
    }

    public Integer getLimit_endAt() {
        return limit_endAt;
    }

    public void setLimit_endAt(Integer limit_endAt) {
        this.limit_endAt = limit_endAt;
    }

    public Integer getLimit_number() {
        return limit_number;
    }

    public void setLimit_number(Integer limit_number) {
        this.limit_number = limit_number;
    }

    public boolean isHas_score() {
        return has_score;
    }

    public void setHas_score(boolean has_score) {
        this.has_score = has_score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
