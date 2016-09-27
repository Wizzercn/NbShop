package cn.wizzer.modules.models.shop;

import cn.wizzer.common.base.Model;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 商城配置表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_config")
public class Shop_config extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("商城布局")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String shop_templet;

    @Column
    @Comment("商城皮肤")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String shop_css;

    @Column
    @Comment("库存预警")
    @ColDefine(type = ColType.INT)
    private int shop_stock;

    @Column
    @Comment("列表方式")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String list_load_type;

    @Column
    @Comment("分页大小")
    @ColDefine(type = ColType.INT)
    private int list_page_size;

    @Column
    @Comment("快速购买")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean list_quick_buy;

    @Column
    @Comment("启用运费")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean freight_disabled;

    @Column
    @Comment("运费方式")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String freight_type;

    @Column
    @Comment("运费")
    @ColDefine(type = ColType.INT)
    private int freight_price;

    @Column
    @Comment("数量")
    @ColDefine(type = ColType.INT)
    private int freight_num;

    @Column
    @Comment("发票")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean tax_disabled;

    @Column
    @Comment("发票金额")
    @ColDefine(type = ColType.INT)
    private int tax_price;

    @Column
    @Comment("货到付款")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean pay_cash;

    @Column
    @Comment("余额支付")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean pay_money;

    @Column
    @Comment("支付宝")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean pay_alipay;

    @Column
    @Comment("支付宝配置")
    @ColDefine(type = ColType.TEXT)
    private String pay_alipay_info;

    @Column
    @Comment("微信支付")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean pay_wxpay;

    @Column
    @Comment("微信支付配置")
    @ColDefine(type = ColType.TEXT)
    private String pay_wxpay_info;

    @Column
    @Comment("信任登录")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean oauth_open;

    @Column
    @Comment("微信登录")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean oauth_weixin;

    @Column
    @Comment("QQ登录")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean oauth_qq;

    @Column
    @Comment("QQ登录配置")
    @ColDefine(type = ColType.TEXT)
    private String oauth_qq_info;

    @Column
    @Comment("物流跟踪")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean logistics_open;

    @Column
    @Comment("物流跟踪配置")
    @ColDefine(type = ColType.TEXT)
    private String logistics_info;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop_templet() {
        return shop_templet;
    }

    public void setShop_templet(String shop_templet) {
        this.shop_templet = shop_templet;
    }

    public String getShop_css() {
        return shop_css;
    }

    public void setShop_css(String shop_css) {
        this.shop_css = shop_css;
    }

    public int getShop_stock() {
        return shop_stock;
    }

    public void setShop_stock(int shop_stock) {
        this.shop_stock = shop_stock;
    }

    public String getList_load_type() {
        return list_load_type;
    }

    public void setList_load_type(String list_load_type) {
        this.list_load_type = list_load_type;
    }

    public int getList_page_size() {
        return list_page_size;
    }

    public void setList_page_size(int list_page_size) {
        this.list_page_size = list_page_size;
    }

    public boolean isList_quick_buy() {
        return list_quick_buy;
    }

    public void setList_quick_buy(boolean list_quick_buy) {
        this.list_quick_buy = list_quick_buy;
    }

    public boolean isFreight_disabled() {
        return freight_disabled;
    }

    public void setFreight_disabled(boolean freight_disabled) {
        this.freight_disabled = freight_disabled;
    }

    public String getFreight_type() {
        return freight_type;
    }

    public void setFreight_type(String freight_type) {
        this.freight_type = freight_type;
    }

    public int getFreight_price() {
        return freight_price;
    }

    public void setFreight_price(int freight_price) {
        this.freight_price = freight_price;
    }

    public int getFreight_num() {
        return freight_num;
    }

    public void setFreight_num(int freight_num) {
        this.freight_num = freight_num;
    }

    public boolean isTax_disabled() {
        return tax_disabled;
    }

    public void setTax_disabled(boolean tax_disabled) {
        this.tax_disabled = tax_disabled;
    }

    public int getTax_price() {
        return tax_price;
    }

    public void setTax_price(int tax_price) {
        this.tax_price = tax_price;
    }

    public boolean isPay_cash() {
        return pay_cash;
    }

    public void setPay_cash(boolean pay_cash) {
        this.pay_cash = pay_cash;
    }

    public boolean isPay_money() {
        return pay_money;
    }

    public void setPay_money(boolean pay_money) {
        this.pay_money = pay_money;
    }

    public boolean isPay_alipay() {
        return pay_alipay;
    }

    public void setPay_alipay(boolean pay_alipay) {
        this.pay_alipay = pay_alipay;
    }

    public String getPay_alipay_info() {
        return pay_alipay_info;
    }

    public void setPay_alipay_info(String pay_alipay_info) {
        this.pay_alipay_info = pay_alipay_info;
    }

    public boolean isPay_wxpay() {
        return pay_wxpay;
    }

    public void setPay_wxpay(boolean pay_wxpay) {
        this.pay_wxpay = pay_wxpay;
    }

    public String getPay_wxpay_info() {
        return pay_wxpay_info;
    }

    public void setPay_wxpay_info(String pay_wxpay_info) {
        this.pay_wxpay_info = pay_wxpay_info;
    }

    public boolean isOauth_open() {
        return oauth_open;
    }

    public void setOauth_open(boolean oauth_open) {
        this.oauth_open = oauth_open;
    }

    public boolean isOauth_weixin() {
        return oauth_weixin;
    }

    public void setOauth_weixin(boolean oauth_weixin) {
        this.oauth_weixin = oauth_weixin;
    }

    public boolean isOauth_qq() {
        return oauth_qq;
    }

    public void setOauth_qq(boolean oauth_qq) {
        this.oauth_qq = oauth_qq;
    }

    public String getOauth_qq_info() {
        return oauth_qq_info;
    }

    public void setOauth_qq_info(String oauth_qq_info) {
        this.oauth_qq_info = oauth_qq_info;
    }

    public boolean isLogistics_open() {
        return logistics_open;
    }

    public void setLogistics_open(boolean logistics_open) {
        this.logistics_open = logistics_open;
    }

    public String getLogistics_info() {
        return logistics_info;
    }

    public void setLogistics_info(String logistics_info) {
        this.logistics_info = logistics_info;
    }
}
