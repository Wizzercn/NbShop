package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;
import java.util.List;

/**
 * 商品信息表
 * Created by wizzer on 2019/6/11
 */
@Table
@TableIndexes({@Index(name = "IDX_SHOP_GOODS", fields = {"classId", "upAt", "location"}, unique = false)})
public class Shop_goods extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @PrevInsert(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("商品名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String name;

    @Column
    @Comment("推荐语")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String title;

    @Column
    @Comment("商品介绍")
    @ColDefine(type = ColType.TEXT)
    private String note;

    @Column
    @Comment("单位")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String unit;

    @Column
    @Comment("重量(单位g)")
    @ColDefine(type = ColType.INT)
    private Integer weight;

    @Column
    @Comment("最小购买量")
    @ColDefine(type = ColType.INT)
    private Integer buy_min;

    @Column
    @Comment("最大购买量")
    @ColDefine(type = ColType.INT)
    private Integer buy_max;

    @Column
    @Comment("分类ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String classId;

    @Column
    @Comment("类型ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String typeId;

    @Column
    @Comment("品牌ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String brandId;

    @Column
    @Comment("是否上架")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean up_true;

    @Column
    @Comment("上架时间")
    private Long upAt;

    @Column
    @Comment("下架时间")
    private Long downAt;

    @Column
    @Comment("属性详情")
    @ColDefine(type = ColType.TEXT)
    private String prop_json;

    @Column
    @Comment("规格详情")
    @ColDefine(type = ColType.TEXT)
    private String spec_json;

    @Column
    @Comment("启用规格")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean spec_enabled;

    @Column
    @Comment("浏览量")
    @ColDefine(type = ColType.INT)
    private Integer count_view;

    @Column
    @Comment("购买量")
    @ColDefine(type = ColType.INT)
    private Integer count_buy;

    @Column
    @Comment("评价量")
    @ColDefine(type = ColType.INT)
    private Integer count_comment;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM Shop_goods"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM Shop_goods")
    })
    private Integer location;

    @ManyMany(from = "goodsId", relation = "shop_goods_image", to = "imageId")
    private List<Shop_image> images;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getBuy_min() {
        return buy_min;
    }

    public void setBuy_min(Integer buy_min) {
        this.buy_min = buy_min;
    }

    public Integer getBuy_max() {
        return buy_max;
    }

    public void setBuy_max(Integer buy_max) {
        this.buy_max = buy_max;
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

    public Boolean getUp_true() {
        return up_true;
    }

    public void setUp_true(Boolean up_true) {
        this.up_true = up_true;
    }

    public Long getUpAt() {
        return upAt;
    }

    public void setUpAt(Long upAt) {
        this.upAt = upAt;
    }

    public Long getDownAt() {
        return downAt;
    }

    public void setDownAt(Long downAt) {
        this.downAt = downAt;
    }

    public String getProp_json() {
        return prop_json;
    }

    public void setProp_json(String prop_json) {
        this.prop_json = prop_json;
    }

    public String getSpec_json() {
        return spec_json;
    }

    public void setSpec_json(String spec_json) {
        this.spec_json = spec_json;
    }

    public Boolean getSpec_enabled() {
        return spec_enabled;
    }

    public void setSpec_enabled(Boolean spec_enabled) {
        this.spec_enabled = spec_enabled;
    }

    public Integer getCount_view() {
        return count_view;
    }

    public void setCount_view(Integer count_view) {
        this.count_view = count_view;
    }

    public Integer getCount_buy() {
        return count_buy;
    }

    public void setCount_buy(Integer count_buy) {
        this.count_buy = count_buy;
    }

    public Integer getCount_comment() {
        return count_comment;
    }

    public void setCount_comment(Integer count_comment) {
        this.count_comment = count_comment;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public List<Shop_image> getImages() {
        return images;
    }

    public void setImages(List<Shop_image> images) {
        this.images = images;
    }
}
