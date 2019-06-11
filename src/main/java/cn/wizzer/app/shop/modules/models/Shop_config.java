package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 商城配置表
 * Created by wizzer on 2019/6/11
 */
@Table
public class Shop_config extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("商城皮肤")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String shop_skin;

    @Column
    @Comment("库存预警通知")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean shop_stock_notice;

    @Column
    @Comment("库存预警值")
    @ColDefine(type = ColType.INT)
    private Integer shop_stock;

    @Column
    @Comment("通知手机号(多个号码)")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String shop_stock_mobile;

    @Column
    @Comment("新订单通知")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean shop_order_notice;

    @Column
    @Comment("通知手机号(多个号码)")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String shop_order_mobile;

    @Column
    @Comment("商品页加载方式(ajax/list)")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String list_load_type;

    @Column
    @Comment("商品页页大小")
    @ColDefine(type = ColType.INT)
    private Integer list_page_size;

    @Column
    @Comment("启用快速购买")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean list_quick_buy;

    @Column
    @Comment("显示热卖商品")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean list_show_hot;

    @Column
    @Comment("是否开启运费")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean freight_enabled;

    @Column
    @Comment("商品页加载方式(price-价格/weight-重量)")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String freight_type;

    @Column
    @Comment("运费")
    @ColDefine(type = ColType.INT)
    private Integer freight_price;

    @Column
    @Comment("运费基数(小于x元或大于x克)")
    @ColDefine(type = ColType.INT)
    private Integer freight_base_num;

    @Column
    @Comment("是否启用发票")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean tax_enabled;

    @Column
    @Comment("满多少可开发票(0-不限制)")
    @ColDefine(type = ColType.INT)
    private Integer tax_price;

    @Column
    @Comment("货到付款")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean pay_cash_enabled;

    @Column
    @Comment("余额付款")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean pay_money_enabled;

    @Column
    @Comment("支付宝支付")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean pay_alipay_enabled;

    @Column
    @Comment("支付宝配置")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String pay_alipay_json;

    @Column
    @Comment("微信支付")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean pay_wxpay_enabled;

    @Column
    @Comment("微信支付配置")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String pay_wxpay_json;

    @Column
    @Comment("短信功能")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean sms_enabled;

    @Column
    @Comment("短信平台类型")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sms_type;

    @Column
    @Comment("短信平台AppKey")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String sms_app_key;

    @Column
    @Comment("短信平台AppSecret")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String sms_app_secret;

    @Column
    @Comment("短信签名")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sms_sign_name;

    @Column
    @Comment("短信注册模板")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sms_reg_template;

    @Column
    @Comment("身份验证验证码模板")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sms_check_template;

    @Column
    @Comment("登陆确认验证码模板")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sms_login_template;

    @Column
    @Comment("修改密码验证码模板")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sms_password_template;

    @Column
    @Comment("库存预警通知模板")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sms_stock_template;

    @Column
    @Comment("新订单通知模板")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sms_order_template;

    @Column
    @Comment("列表页缩略图宽")
    @ColDefine(type = ColType.INT)
    private Integer img_list_w;

    @Column
    @Comment("列表页缩略图高")
    @ColDefine(type = ColType.INT)
    private Integer img_list_h;

    @Column
    @Comment("详情页缩略图宽")
    @ColDefine(type = ColType.INT)
    private Integer img_info_w;

    @Column
    @Comment("详情页缩略图高")
    @ColDefine(type = ColType.INT)
    private Integer img_info_h;

    @Column
    @Comment("是否启用水印")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean img_wm_enabled;

    @Column
    @Comment("水印图片")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String img_wm_url;

    @Column
    @Comment("启用会员积分")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean member_score_enabled;

    @Column
    @Comment("商品积分比例(100%)")
    @ColDefine(type = ColType.INT)
    private Integer  member_score_rate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop_skin() {
        return shop_skin;
    }

    public void setShop_skin(String shop_skin) {
        this.shop_skin = shop_skin;
    }

    public Boolean getShop_stock_notice() {
        return shop_stock_notice;
    }

    public void setShop_stock_notice(Boolean shop_stock_notice) {
        this.shop_stock_notice = shop_stock_notice;
    }

    public Integer getShop_stock() {
        return shop_stock;
    }

    public void setShop_stock(Integer shop_stock) {
        this.shop_stock = shop_stock;
    }

    public String getShop_stock_mobile() {
        return shop_stock_mobile;
    }

    public void setShop_stock_mobile(String shop_stock_mobile) {
        this.shop_stock_mobile = shop_stock_mobile;
    }

    public Boolean getShop_order_notice() {
        return shop_order_notice;
    }

    public void setShop_order_notice(Boolean shop_order_notice) {
        this.shop_order_notice = shop_order_notice;
    }

    public String getShop_order_mobile() {
        return shop_order_mobile;
    }

    public void setShop_order_mobile(String shop_order_mobile) {
        this.shop_order_mobile = shop_order_mobile;
    }

    public String getList_load_type() {
        return list_load_type;
    }

    public void setList_load_type(String list_load_type) {
        this.list_load_type = list_load_type;
    }

    public Integer getList_page_size() {
        return list_page_size;
    }

    public void setList_page_size(Integer list_page_size) {
        this.list_page_size = list_page_size;
    }

    public Boolean getList_quick_buy() {
        return list_quick_buy;
    }

    public void setList_quick_buy(Boolean list_quick_buy) {
        this.list_quick_buy = list_quick_buy;
    }

    public Boolean getList_show_hot() {
        return list_show_hot;
    }

    public void setList_show_hot(Boolean list_show_hot) {
        this.list_show_hot = list_show_hot;
    }

    public Boolean getFreight_enabled() {
        return freight_enabled;
    }

    public void setFreight_enabled(Boolean freight_enabled) {
        this.freight_enabled = freight_enabled;
    }

    public String getFreight_type() {
        return freight_type;
    }

    public void setFreight_type(String freight_type) {
        this.freight_type = freight_type;
    }

    public Integer getFreight_price() {
        return freight_price;
    }

    public void setFreight_price(Integer freight_price) {
        this.freight_price = freight_price;
    }

    public Integer getFreight_base_num() {
        return freight_base_num;
    }

    public void setFreight_base_num(Integer freight_base_num) {
        this.freight_base_num = freight_base_num;
    }

    public Boolean getTax_enabled() {
        return tax_enabled;
    }

    public void setTax_enabled(Boolean tax_enabled) {
        this.tax_enabled = tax_enabled;
    }

    public Integer getTax_price() {
        return tax_price;
    }

    public void setTax_price(Integer tax_price) {
        this.tax_price = tax_price;
    }

    public Boolean getPay_cash_enabled() {
        return pay_cash_enabled;
    }

    public void setPay_cash_enabled(Boolean pay_cash_enabled) {
        this.pay_cash_enabled = pay_cash_enabled;
    }

    public Boolean getPay_money_enabled() {
        return pay_money_enabled;
    }

    public void setPay_money_enabled(Boolean pay_money_enabled) {
        this.pay_money_enabled = pay_money_enabled;
    }

    public Boolean getPay_alipay_enabled() {
        return pay_alipay_enabled;
    }

    public void setPay_alipay_enabled(Boolean pay_alipay_enabled) {
        this.pay_alipay_enabled = pay_alipay_enabled;
    }

    public String getPay_alipay_json() {
        return pay_alipay_json;
    }

    public void setPay_alipay_json(String pay_alipay_json) {
        this.pay_alipay_json = pay_alipay_json;
    }

    public Boolean getPay_wxpay_enabled() {
        return pay_wxpay_enabled;
    }

    public void setPay_wxpay_enabled(Boolean pay_wxpay_enabled) {
        this.pay_wxpay_enabled = pay_wxpay_enabled;
    }

    public String getPay_wxpay_json() {
        return pay_wxpay_json;
    }

    public void setPay_wxpay_json(String pay_wxpay_json) {
        this.pay_wxpay_json = pay_wxpay_json;
    }

    public Boolean getSms_enabled() {
        return sms_enabled;
    }

    public void setSms_enabled(Boolean sms_enabled) {
        this.sms_enabled = sms_enabled;
    }

    public String getSms_type() {
        return sms_type;
    }

    public void setSms_type(String sms_type) {
        this.sms_type = sms_type;
    }

    public String getSms_app_key() {
        return sms_app_key;
    }

    public void setSms_app_key(String sms_app_key) {
        this.sms_app_key = sms_app_key;
    }

    public String getSms_app_secret() {
        return sms_app_secret;
    }

    public void setSms_app_secret(String sms_app_secret) {
        this.sms_app_secret = sms_app_secret;
    }

    public String getSms_sign_name() {
        return sms_sign_name;
    }

    public void setSms_sign_name(String sms_sign_name) {
        this.sms_sign_name = sms_sign_name;
    }

    public String getSms_reg_template() {
        return sms_reg_template;
    }

    public void setSms_reg_template(String sms_reg_template) {
        this.sms_reg_template = sms_reg_template;
    }

    public String getSms_check_template() {
        return sms_check_template;
    }

    public void setSms_check_template(String sms_check_template) {
        this.sms_check_template = sms_check_template;
    }

    public String getSms_login_template() {
        return sms_login_template;
    }

    public void setSms_login_template(String sms_login_template) {
        this.sms_login_template = sms_login_template;
    }

    public String getSms_password_template() {
        return sms_password_template;
    }

    public void setSms_password_template(String sms_password_template) {
        this.sms_password_template = sms_password_template;
    }

    public String getSms_stock_template() {
        return sms_stock_template;
    }

    public void setSms_stock_template(String sms_stock_template) {
        this.sms_stock_template = sms_stock_template;
    }

    public String getSms_order_template() {
        return sms_order_template;
    }

    public void setSms_order_template(String sms_order_template) {
        this.sms_order_template = sms_order_template;
    }

    public Integer getImg_list_w() {
        return img_list_w;
    }

    public void setImg_list_w(Integer img_list_w) {
        this.img_list_w = img_list_w;
    }

    public Integer getImg_list_h() {
        return img_list_h;
    }

    public void setImg_list_h(Integer img_list_h) {
        this.img_list_h = img_list_h;
    }

    public Integer getImg_info_w() {
        return img_info_w;
    }

    public void setImg_info_w(Integer img_info_w) {
        this.img_info_w = img_info_w;
    }

    public Integer getImg_info_h() {
        return img_info_h;
    }

    public void setImg_info_h(Integer img_info_h) {
        this.img_info_h = img_info_h;
    }

    public Boolean getImg_wm_enabled() {
        return img_wm_enabled;
    }

    public void setImg_wm_enabled(Boolean img_wm_enabled) {
        this.img_wm_enabled = img_wm_enabled;
    }

    public String getImg_wm_url() {
        return img_wm_url;
    }

    public void setImg_wm_url(String img_wm_url) {
        this.img_wm_url = img_wm_url;
    }

    public Boolean getMember_score_enabled() {
        return member_score_enabled;
    }

    public void setMember_score_enabled(Boolean member_score_enabled) {
        this.member_score_enabled = member_score_enabled;
    }

    public Integer getMember_score_rate() {
        return member_score_rate;
    }

    public void setMember_score_rate(Integer member_score_rate) {
        this.member_score_rate = member_score_rate;
    }
}
