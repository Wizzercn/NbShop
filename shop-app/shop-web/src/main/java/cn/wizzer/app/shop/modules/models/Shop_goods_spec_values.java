package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 商品规格值表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_goods_spec_values")
public class Shop_goods_spec_values extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("规格ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String specId;

    @Column
    @Comment("规格值")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String spec_value;

    @Column
    @Comment("规格图片")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String spec_picurl;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM shop_goods_spec_values"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM shop_goods_spec_values")
    })
    private Integer location;

    @One(target = Shop_goods_spec.class, field = "specId")
    private Shop_goods_spec goodsSpec;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpec_value() {
        return spec_value;
    }

    public void setSpec_value(String spec_value) {
        this.spec_value = spec_value;
    }

    public String getSpec_picurl() {
        return spec_picurl;
    }

    public void setSpec_picurl(String spec_picurl) {
        this.spec_picurl = spec_picurl;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Shop_goods_spec getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(Shop_goods_spec goodsSpec) {
        this.goodsSpec = goodsSpec;
    }
}
