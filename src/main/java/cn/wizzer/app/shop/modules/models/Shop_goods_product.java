package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * Created by wizzer on 2019/6/11
 */
@Table
@TableIndexes({@Index(name = "IDX_SHOP_G_P_SKU", fields = {"sku"}, unique = true),
        @Index(name = "IDX_SHOP_G_P_PRICE", fields = {"price"}, unique = false)})
public class Shop_goods_product extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("SKU")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String sku;

    @Column
    @Comment("规格名")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String name;

    @Column
    @Comment("销售价")
    @ColDefine(type = ColType.INT)
    private Integer price;

    @Column
    @Comment("市场价")
    @ColDefine(type = ColType.INT)
    private Integer price_market;

    @Column
    @Comment("库存")
    @ColDefine(type = ColType.INT)
    private Integer stock;

    @Column
    @Comment("冻结库存")
    @ColDefine(type = ColType.INT)
    private Integer stock_freeze;

    @Column
    @Comment("是否上架")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean up_true;

    @Column
    @Comment("默认规格")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean default_true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice_market() {
        return price_market;
    }

    public void setPrice_market(Integer price_market) {
        this.price_market = price_market;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock_freeze() {
        return stock_freeze;
    }

    public void setStock_freeze(Integer stock_freeze) {
        this.stock_freeze = stock_freeze;
    }

    public Boolean getUp_true() {
        return up_true;
    }

    public void setUp_true(Boolean up_true) {
        this.up_true = up_true;
    }

    public Boolean getDefault_true() {
        return default_true;
    }

    public void setDefault_true(Boolean default_true) {
        this.default_true = default_true;
    }
}
