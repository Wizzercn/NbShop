package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;
import java.util.List;

/**
 * 商品属性表
 * Created by wizzer on 2019/6/11
 */
@Table
public class Shop_goods_type_props extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @PrevInsert(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("类型ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String typeId;

    @Column
    @Comment("属性名称")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String form_name;

    @Column
    @Comment("表单类型(select/input)")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String form_type;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM Shop_goods_type_props"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM Shop_goods_type_props")
    })
    private Integer location;

    @Many(field = "propsId")
    private List<Shop_goods_type_props_value> values;

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

    public String getForm_name() {
        return form_name;
    }

    public void setForm_name(String form_name) {
        this.form_name = form_name;
    }

    public String getForm_type() {
        return form_type;
    }

    public void setForm_type(String form_type) {
        this.form_type = form_type;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public List<Shop_goods_type_props_value> getValues() {
        return values;
    }

    public void setValues(List<Shop_goods_type_props_value> values) {
        this.values = values;
    }
}
