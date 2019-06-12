package cn.wizzer.app.shop.modules.models;

import cn.wizzer.app.shop.commons.enums.ShopOrderPayType;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 订单支付表
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_order_pay_payment extends BaseModel implements Serializable {
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
    @Comment("支付方式")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private ShopOrderPayType pay_type;

    @Column
    @Comment("支付金额")
    @ColDefine(type = ColType.INT)
    private Integer pay_money;

    @Column
    @Comment("支付时间")
    private Long pay_time;

    @Column
    @Comment("系统支付单号")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String pay_no;

    @Column
    @Comment("支付IP")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String pay_ip;

    @Column
    @Comment("支付帐号")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String pay_account;

    @Column
    @Comment("支付状态(0-待完成/1-已完成后/2-交易失败)")
    @ColDefine(type = ColType.INT,width = 1)
    private Integer pay_status;

    @Column
    @Comment("交易单据号")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String trade_no;

    @Column
    @Comment("回调地址")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String  return_url;

    @Column
    @Comment("交易完成时间")
    private Long finish_time;

    @Column
    @Comment("支付备注")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String pay_memo;

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

    public ShopOrderPayType getPay_type() {
        return pay_type;
    }

    public void setPay_type(ShopOrderPayType pay_type) {
        this.pay_type = pay_type;
    }

    public Integer getPay_money() {
        return pay_money;
    }

    public void setPay_money(Integer pay_money) {
        this.pay_money = pay_money;
    }

    public Long getPay_time() {
        return pay_time;
    }

    public void setPay_time(Long pay_time) {
        this.pay_time = pay_time;
    }

    public Integer getPay_status() {
        return pay_status;
    }

    public void setPay_status(Integer pay_status) {
        this.pay_status = pay_status;
    }

    public String getPay_no() {
        return pay_no;
    }

    public void setPay_no(String pay_no) {
        this.pay_no = pay_no;
    }

    public String getPay_ip() {
        return pay_ip;
    }

    public void setPay_ip(String pay_ip) {
        this.pay_ip = pay_ip;
    }

    public String getPay_account() {
        return pay_account;
    }

    public void setPay_account(String pay_account) {
        this.pay_account = pay_account;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public Long getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Long finish_time) {
        this.finish_time = finish_time;
    }

    public String getPay_memo() {
        return pay_memo;
    }

    public void setPay_memo(String pay_memo) {
        this.pay_memo = pay_memo;
    }
}
