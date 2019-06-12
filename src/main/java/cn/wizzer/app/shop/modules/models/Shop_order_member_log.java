package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 订单会员操作日志
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_order_member_log extends BaseModel implements Serializable {
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
    @Comment("操作时间")
    private Long op_time;

    @Column
    @Comment("操作内容")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String op_note;

    @Column
    @Comment("操作IP")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String op_ip;

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

    public Long getOp_time() {
        return op_time;
    }

    public void setOp_time(Long op_time) {
        this.op_time = op_time;
    }

    public String getOp_note() {
        return op_note;
    }

    public void setOp_note(String op_note) {
        this.op_note = op_note;
    }

    public String getOp_ip() {
        return op_ip;
    }

    public void setOp_ip(String op_ip) {
        this.op_ip = op_ip;
    }
}
