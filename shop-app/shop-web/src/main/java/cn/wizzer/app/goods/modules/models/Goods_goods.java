package cn.wizzer.app.goods.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品表
 * Created by wizzer on 2016/9/27.
 */
@Table("goods_goods")
public class Goods_goods extends BaseModel implements Serializable {
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
    private Integer upAt;

    @Column
    @Comment("下架时间")
    @ColDefine(type = ColType.INT)
    private Integer downAt;

    @Column
    @Comment("浏览量")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer numView;

    @Column
    @Comment("评论量")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer numComment;

    @Column
    @Comment("销售量")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer numSale;

    @Column
    @Comment("周销售量")
    @ColDefine(type = ColType.INT)
    @Default("0")
    private Integer numSaleWeek;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM goods_goods"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM goods_goods")
    })
    private Integer location;

    @One(target = Goods_class.class, field = "classId")
    public Goods_class goodsClass;

    @One(target = Goods_type.class, field = "typeId")
    public Goods_type goodsType;

    @One(target = Goods_brand.class, field = "brandId")
    public Goods_brand goodsBrand;

    @Many(target = Goods_images.class, field = "goodsId")
    private List<Goods_images> imagesList;

    @Many(target = Goods_product.class, field = "goodsId")
    private List<Goods_product> productList;

    @ManyMany(from = "goodsId", relation = "goods_tag_link", target = Goods_tag.class, to = "tagId")
    private List<Goods_tag> tags;

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

    public Integer getUpAt() {
        return upAt;
    }

    public void setUpAt(Integer upAt) {
        this.upAt = upAt;
    }

    public Integer getDownAt() {
        return downAt;
    }

    public void setDownAt(Integer downAt) {
        this.downAt = downAt;
    }

    public Integer getNumView() {
        return numView;
    }

    public void setNumView(Integer numView) {
        this.numView = numView;
    }

    public Integer getNumComment() {
        return numComment;
    }

    public void setNumComment(Integer numComment) {
        this.numComment = numComment;
    }

    public Integer getNumSale() {
        return numSale;
    }

    public void setNumSale(Integer numSale) {
        this.numSale = numSale;
    }

    public Integer getNumSaleWeek() {
        return numSaleWeek;
    }

    public void setNumSaleWeek(Integer numSaleWeek) {
        this.numSaleWeek = numSaleWeek;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Goods_class getGoodsClass() {
        return goodsClass;
    }

    public void setGoodsClass(Goods_class goodsClass) {
        this.goodsClass = goodsClass;
    }

    public Goods_type getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Goods_type goodsType) {
        this.goodsType = goodsType;
    }

    public Goods_brand getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(Goods_brand goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public List<Goods_images> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<Goods_images> imagesList) {
        this.imagesList = imagesList;
    }

    public List<Goods_product> getProductList() {
        return productList;
    }

    public void setProductList(List<Goods_product> productList) {
        this.productList = productList;
    }

    public List<Goods_tag> getTags() {
        return tags;
    }

    public void setTags(List<Goods_tag> tags) {
        this.tags = tags;
    }
}
