package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 会员商品评价/咨询表
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_member_comment extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("会员ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String memberId;

    @Column
    @Comment("商品ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String goodsId;

    @Column
    @Comment("订单ID(咨询时为空)")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String orderId;

    @Column
    @Comment("评论类型(assess/advice)")
    @ColDefine(type = ColType.VARCHAR, width = 5)
    private String type;

    @Column
    @Comment("评价分数(1/2/3/4/5)")
    @ColDefine(type = ColType.INT)
    private Integer score;

    @Column
    @Comment("评论内容")
    @ColDefine(type = ColType.VARCHAR, width = 1000)
    private String comment;

    @Column
    @Comment("会员昵称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String member_nickname;

    @Column
    @Comment("评论IP")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String comment_ip;

    @Column
    @Comment("评论时间")
    private Long comment_time;

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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
