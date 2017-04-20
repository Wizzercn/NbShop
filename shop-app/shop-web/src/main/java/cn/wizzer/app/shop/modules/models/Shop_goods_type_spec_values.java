package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 商品类型-规格表-规格值表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_goods_type_spec_values")
public class Shop_goods_type_spec_values extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("类型ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String typeId;

    @Column
    @Comment("规格ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String specId;

    @Column
    @Comment("规格值ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String specValueId;

    @Column
    @Comment("规格值名称")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String specValText;

    @Column
    @Comment("规格值图片")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String specValUrl;

    @Column
    @Comment("类型规格ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String typeSpecId;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM shop_goods_type_spec_values"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM shop_goods_type_spec_values")
    })
    private Integer location;

    @One(target = Shop_goods_type_spec_values.class, field = "specValueId")
    private Shop_goods_type_spec_values typeSpec;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpecValueId() {
        return specValueId;
    }

    public void setSpecValueId(String specValueId) {
        this.specValueId = specValueId;
    }

    public String getSpecValText() {
        return specValText;
    }

    public void setSpecValText(String specValText) {
        this.specValText = specValText;
    }

    public String getSpecValUrl() {
        return specValUrl;
    }

    public void setSpecValUrl(String specValUrl) {
        this.specValUrl = specValUrl;
    }

    public String getTypeSpecId() {
        return typeSpecId;
    }

    public void setTypeSpecId(String typeSpecId) {
        this.typeSpecId = typeSpecId;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Shop_goods_type_spec_values getTypeSpec() {
        return typeSpec;
    }

    public void setTypeSpec(Shop_goods_type_spec_values typeSpec) {
        this.typeSpec = typeSpec;
    }
}
