package cn.wizzer.modules.models.shop;

import cn.wizzer.common.base.Model;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_goods")
public class Shop_goods extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("预留商城ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String storeId;

    @Column
    @Comment("商品名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String name;

    @Column
    @Comment("商品标题")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String title;

    @Column
    @Comment("商品分类")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String classId;

    @Column
    @Comment("商品类型")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String typeId;

    @Column
    @Comment("商品品牌")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String brandId;

    @Column
    @Comment("商品主图")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String imgurl;

    @Column
    @Comment("商品详情")
    @ColDefine(type = ColType.TEXT)
    private String note;

    @Column
    @Comment("属性详情")
    @ColDefine(type = ColType.TEXT)
    private String prop;

    @Column
    @Comment("规格详情")
    @ColDefine(type = ColType.TEXT)
    private String spec;

    @Column
    @Comment("参数详情")
    @ColDefine(type = ColType.TEXT)
    private String param;

    @Column
    @Comment("启用规格")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean hasSpec;

    @Column
    @Comment("计量单位")
    @ColDefine(type = ColType.VARCHAR, width = 25)
    private String unit;

    @Column
    @Comment("是否下架")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @Column
    @Comment("上架时间")
    @ColDefine(type = ColType.INT)
    private int upAt;

    @Column
    @Comment("下架时间")
    @ColDefine(type = ColType.INT)
    private int downAt;

    @Column
    @Comment("浏览量")
    @ColDefine(type = ColType.INT)
    private int numView;

    @Column
    @Comment("评论量")
    @ColDefine(type = ColType.INT)
    private int numComment;

    @Column
    @Comment("销售量")
    @ColDefine(type = ColType.INT)
    private int numSale;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM shop_goods"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM shop_goods")
    })
    private Integer location;

    @One(target = Shop_goods_class.class, field = "classId")
    public Shop_goods_class goodsClass;

    @One(target = Shop_goods_type.class, field = "typeId")
    public Shop_goods_type goodsType;

    @One(target = Shop_goods_brand.class, field = "brandId")
    public Shop_goods_brand goodsBrand;

    @Many(target = Shop_goods_images.class, field = "goodsId")
    private List<Shop_goods_images> imagesList;

    @Many(target = Shop_goods_products.class, field = "goodsId")
    private List<Shop_goods_products> productsList;

    @ManyMany(from = "goodsId", relation = "shop_goods_tag_link", target = Shop_goods_tag.class, to = "tagId")
    private List<Shop_goods_tag> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isHasSpec() {
        return hasSpec;
    }

    public void setHasSpec(boolean hasSpec) {
        this.hasSpec = hasSpec;
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

    public int getNumView() {
        return numView;
    }

    public void setNumView(int numView) {
        this.numView = numView;
    }

    public int getNumComment() {
        return numComment;
    }

    public void setNumComment(int numComment) {
        this.numComment = numComment;
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

    public Shop_goods_class getGoodsClass() {
        return goodsClass;
    }

    public void setGoodsClass(Shop_goods_class goodsClass) {
        this.goodsClass = goodsClass;
    }

    public Shop_goods_type getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Shop_goods_type goodsType) {
        this.goodsType = goodsType;
    }

    public Shop_goods_brand getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(Shop_goods_brand goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public List<Shop_goods_images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Shop_goods_images> imagesList) {
        this.imagesList = imagesList;
    }

    public List<Shop_goods_products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Shop_goods_products> productsList) {
        this.productsList = productsList;
    }

    public List<Shop_goods_tag> getTags() {
        return tags;
    }

    public void setTags(List<Shop_goods_tag> tags) {
        this.tags = tags;
    }
}
