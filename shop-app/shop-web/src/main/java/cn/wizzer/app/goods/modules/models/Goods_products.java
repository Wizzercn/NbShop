package cn.wizzer.app.goods.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 货品表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_goods_products")
@TableIndexes({@Index(name = "INDEX_SHOP_GOODS_PRODUCT", fields = {"sku"}, unique = true)})
public class Goods_products extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("SKU")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sku;

    @Column
    @Comment("商品ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String goodsId;

    @Column
    @Comment("货品名")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String name;

    @Column
    @Comment("货品规格")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String spec;

    @Column
    @Comment("销售价")
    @ColDefine(type = ColType.INT)
    private int price;

    @Column
    @Comment("市场价")
    @ColDefine(type = ColType.INT)
    private int priceMarket;

    @Column
    @Comment("重量")
    @ColDefine(type = ColType.INT)
    private int weight;

    @Column
    @Comment("库存")
    @ColDefine(type = ColType.INT)
    private int stock;

    @Column
    @Comment("最小购买量")
    @ColDefine(type = ColType.INT)
    private int buyMin;

    @Column
    @Comment("最大购买量")
    @ColDefine(type = ColType.INT)
    private int buyMax;

    @Column
    @Comment("计量单位")
    @ColDefine(type = ColType.VARCHAR, width = 25)
    private String unit;

    @Column
    @Comment("是否下架")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @Column
    @Comment("是否默认")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean isDefault;

    @Column
    @Comment("上架时间")
    @ColDefine(type = ColType.INT)
    private int upAt;

    @Column
    @Comment("下架时间")
    @ColDefine(type = ColType.INT)
    private int downAt;

    @Column
    @Comment("销售量")
    @ColDefine(type = ColType.INT)
    private int numSale;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM shop_goods_products"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM shop_goods_products")
    })
    private Integer location;

    @One(target = Goods_goods.class, field = "goodsId")
    private Goods_goods goods;

    @Many(target = Goods_lv_price.class, field = "productId")
    private List<Goods_lv_price> lvPriceList;

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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceMarket() {
        return priceMarket;
    }

    public void setPriceMarket(int priceMarket) {
        this.priceMarket = priceMarket;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getBuyMin() {
        return buyMin;
    }

    public void setBuyMin(int buyMin) {
        this.buyMin = buyMin;
    }

    public int getBuyMax() {
        return buyMax;
    }

    public void setBuyMax(int buyMax) {
        this.buyMax = buyMax;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public int getUpAt() {
        return upAt;
    }

    public void setUpAt(int upAt) {
        this.upAt = upAt;
    }

    public int getDownAt() {
        return downAt;
    }

    public void setDownAt(int downAt) {
        this.downAt = downAt;
    }

    public int getNumSale() {
        return numSale;
    }

    public void setNumSale(int numSale) {
        this.numSale = numSale;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Goods_goods getGoods() {
        return goods;
    }

    public void setGoods(Goods_goods goods) {
        this.goods = goods;
    }

    public List<Goods_lv_price> getLvPriceList() {
        return lvPriceList;
    }

    public void setLvPriceList(List<Goods_lv_price> lvPriceList) {
        this.lvPriceList = lvPriceList;
    }
}
