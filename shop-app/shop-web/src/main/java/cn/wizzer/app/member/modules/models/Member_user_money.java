package cn.wizzer.app.member.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 会员余额变动历史表
 * Created by wizzer on 2017/3/5.
 */
@Table("member_user_money")
@TableIndexes({@Index(name = "INDEX_MEMBER_USER_MONEY", fields = {"memberId"}, unique = false)})
public class Member_user_money extends BaseModel implements Serializable {
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
    @Comment("订单ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String orderId;

    @Column
    @Comment("交易单据号")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String trade_no;

    @Column
    @Comment("交易说明")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String note;

    @Column
    @Comment("原余额")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer oldMoney = 0;

    @Column
    @Comment("现金额")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer newMoney = 0;

    @Column
    @Comment("差额")
    @Default("0")
    @ColDefine(type = ColType.INT)
    private Integer diffMoney = 0;

    @Column
    @Comment("产生时间")
    @ColDefine(type = ColType.INT)
    private Integer creatAt;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getOldMoney() {
        return oldMoney;
    }

    public void setOldMoney(Integer oldMoney) {
        this.oldMoney = oldMoney;
    }

    public Integer getNewMoney() {
        return newMoney;
    }

    public void setNewMoney(Integer newMoney) {
        this.newMoney = newMoney;
    }

    public Integer getDiffMoney() {
        return diffMoney;
    }

    public void setDiffMoney(Integer diffMoney) {
        this.diffMoney = diffMoney;
    }

    public Integer getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Integer creatAt) {
        this.creatAt = creatAt;
    }
}
