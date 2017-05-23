package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 支付方式
 * Created by wizzer on 2017/5/23.
 */
@Table("shop_shipping")
public class Shop_shipping extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("配送方式")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String name;

    @Column
    @Comment("计价方式")
    @ColDefine(type = ColType.VARCHAR, width = 10)
    private String method;//flatprice--统一价格 weight--按重量 number--按件数

    @Column
    @Comment("统一价格")
    @ColDefine(type = ColType.INT)
    private int flatprice;

    @Column
    @Comment("首重量/首件数")
    @ColDefine(type = ColType.INT)
    private int lv1_number;

    @Column
    @Comment("首重价/首件价")
    @ColDefine(type = ColType.INT)
    private int lv1_price;

    @Column
    @Comment("续重量/续件数")
    @ColDefine(type = ColType.INT)
    private int lv2_number;

    @Column
    @Comment("续重价/续件价")
    @ColDefine(type = ColType.INT)
    private int lv2_price;

    @Column
    @Comment("是否禁用")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @Column
    @Comment("是否默认")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean defaultValue;

    @Column
    @Comment("描述")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String note;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM shop_shipping"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM shop_shipping")
    })
    private Integer location;

    @ManyMany(from = "shippingId", relation = "shop_shipping_express", to = "expressId")
    private List<Shop_express> expressList;

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getFlatprice() {
        return flatprice;
    }

    public void setFlatprice(int flatprice) {
        this.flatprice = flatprice;
    }

    public int getLv1_number() {
        return lv1_number;
    }

    public void setLv1_number(int lv1_number) {
        this.lv1_number = lv1_number;
    }

    public int getLv1_price() {
        return lv1_price;
    }

    public void setLv1_price(int lv1_price) {
        this.lv1_price = lv1_price;
    }

    public int getLv2_number() {
        return lv2_number;
    }

    public void setLv2_number(int lv2_number) {
        this.lv2_number = lv2_number;
    }

    public int getLv2_price() {
        return lv2_price;
    }

    public void setLv2_price(int lv2_price) {
        this.lv2_price = lv2_price;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public List<Shop_express> getExpressList() {
        return expressList;
    }

    public void setExpressList(List<Shop_express> expressList) {
        this.expressList = expressList;
    }
}
