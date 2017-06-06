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
    private Integer total_num;

    @Column
    @Comment("已发数量")
    @ColDefine(type = ColType.INT)
    private Integer send_num;

    @Column
    @Comment("期限限制")
    @ColDefine(type = ColType.INT)
    private Integer has_limit;//0 不限  1 按到期时间  2 按获取时间

    @Column
    @Comment("使用期限")
    @ColDefine(type = ColType.INT)
    private Integer limit_time;

    @Column
    @Comment("允许领取多张")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean has_more;

    @Column
    @Comment("允许积分兑换")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean has_score;

    @Column
    @Comment("所需积分")
    @ColDefine(type = ColType.INT)
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

    public Integer getHas_limit() {
        return has_limit;
    }

    public void setHas_limit(Integer has_limit) {
        this.has_limit = has_limit;
    }

    public Integer getLimit_time() {
        return limit_time;
    }

    public void setLimit_time(Integer limit_time) {
        this.limit_time = limit_time;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
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
