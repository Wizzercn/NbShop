package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品规格表
 * Created by wizzer on 2019/6/11
 */
@Table
public class Shop_goods_spec extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("规格名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @Column
    @Comment("规格类型(txt/img)")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String type;

    @Column
    @Comment("别名")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String alias_name;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db= DB.MYSQL,value = "SELECT IFNULL(MAX(location),0)+1 FROM Shop_goods_spec"),
            @SQL(db= DB.ORACLE,value = "SELECT COALESCE(MAX(location),0)+1 FROM Shop_goods_spec")
    })
    private Integer location;

    @Many(field = "specId")
    private List<Shop_goods_spec_value> specValues;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlias_name() {
        return alias_name;
    }

    public void setAlias_name(String alias_name) {
        this.alias_name = alias_name;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public List<Shop_goods_spec_value> getSpecValues() {
        return specValues;
    }

    public void setSpecValues(List<Shop_goods_spec_value> specValues) {
        this.specValues = specValues;
    }
}
