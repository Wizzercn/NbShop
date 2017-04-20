package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型-规格表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_goods_type_spec")
public class Shop_goods_type_spec extends BaseModel implements Serializable {
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
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM shop_goods_type_spec"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM shop_goods_type_spec")
    })
    private Integer location;

    @Many(target = Shop_goods_type_spec_values.class, field = "typeSpecId")
    private List<Shop_goods_type_spec_values> specValList;

    @One(target = Shop_goods_spec.class, field = "specId")
    private Shop_goods_spec spec;

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

    public Shop_goods_spec getSpec() {
        return spec;
    }

    public void setSpec(Shop_goods_spec spec) {
        this.spec = spec;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public List<Shop_goods_type_spec_values> getSpecValList() {
        return specValList;
    }

    public void setSpecValList(List<Shop_goods_type_spec_values> specValList) {
        this.specValList = specValList;
    }
}
