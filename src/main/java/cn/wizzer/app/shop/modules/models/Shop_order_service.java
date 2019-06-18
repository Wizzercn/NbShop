package cn.wizzer.app.shop.modules.models;

import cn.wizzer.app.shop.commons.enums.ShopOrderServiceStatus;
import cn.wizzer.app.shop.commons.enums.ShopOrderServiceType;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;

/**
 * 售后服务单
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_order_service extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @PrevInsert(els = {@EL("uuid()")})
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
    @Comment("售后类型")
    @ColDefine(type = ColType.INT)
    private ShopOrderServiceType type;

    @Column
    @Comment("售后内容")
    @ColDefine(type = ColType.VARCHAR, width = 2000)
    private String comment;

    @Column
    @Comment("会员昵称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String member_nickname;

    @Column
    @Comment("售后IP")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String comment_ip;

    @Column
    @Comment("售后时间")
    private Long comment_time;

    @Column
    @Comment("回复人")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String reply_userid;

    @Column
    @Comment("回复昵称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String reply_nickname;

    @Column
    @Comment("回复内容")
    @ColDefine(type = ColType.VARCHAR, width = 1000)
    private String reply_comment;

    @Column
    @Comment("回复时间")
    private Long reply_time;

    @Column
    @Comment("售后状态")
    @ColDefine(type = ColType.INT)
    private ShopOrderServiceStatus status;

    @Column
    @Comment("物流公司名称")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String refund_logistics_name;

    @Column
    @Comment("快递单号")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String refund_logistics_sn;

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

    public ShopOrderServiceType getType() {
        return type;
    }

    public void setType(ShopOrderServiceType type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMember_nickname() {
        return member_nickname;
    }

    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname;
    }

    public String getComment_ip() {
        return comment_ip;
    }

    public void setComment_ip(String comment_ip) {
        this.comment_ip = comment_ip;
    }

    public Long getComment_time() {
        return comment_time;
    }

    public void setComment_time(Long comment_time) {
        this.comment_time = comment_time;
    }

    public String getReply_userid() {
        return reply_userid;
    }

    public void setReply_userid(String reply_userid) {
        this.reply_userid = reply_userid;
    }

    public String getReply_nickname() {
        return reply_nickname;
    }

    public void setReply_nickname(String reply_nickname) {
        this.reply_nickname = reply_nickname;
    }

    public String getReply_comment() {
        return reply_comment;
    }

    public void setReply_comment(String reply_comment) {
        this.reply_comment = reply_comment;
    }

    public Long getReply_time() {
        return reply_time;
    }

    public void setReply_time(Long reply_time) {
        this.reply_time = reply_time;
    }

    public ShopOrderServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ShopOrderServiceStatus status) {
        this.status = status;
    }

    public String getRefund_logistics_name() {
        return refund_logistics_name;
    }

    public void setRefund_logistics_name(String refund_logistics_name) {
        this.refund_logistics_name = refund_logistics_name;
    }

    public String getRefund_logistics_sn() {
        return refund_logistics_sn;
    }

    public void setRefund_logistics_sn(String refund_logistics_sn) {
        this.refund_logistics_sn = refund_logistics_sn;
    }
}
