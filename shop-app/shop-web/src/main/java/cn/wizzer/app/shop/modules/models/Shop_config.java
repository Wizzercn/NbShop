package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 商城配置表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_config")
public class Shop_config extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("库存预警")
    @ColDefine(type = ColType.INT)
    private int shop_stock;

    @Column
    @Comment("积分比率")
    @ColDefine(type = ColType.INT)
    private int point_rate;

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
    @Comment("发票")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean tax_disabled;

    @Column
    @Comment("开票金额")
    @ColDefine(type = ColType.INT)
    private int tax_price;

    @Column
    @Comment("货到付款")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean pay_cash;

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

    public int getShop_stock() {
        return shop_stock;
    }

    public void setShop_stock(int shop_stock) {
        this.shop_stock = shop_stock;
    }

    public String getList_load_type() {
        return list_load_type;
    }

    public int getPoint_rate() {
        return point_rate;
    }

    public void setPoint_rate(int point_rate) {
        this.point_rate = point_rate;
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
