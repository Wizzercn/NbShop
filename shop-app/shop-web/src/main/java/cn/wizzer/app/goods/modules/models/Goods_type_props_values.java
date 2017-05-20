package cn.wizzer.app.goods.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 商品类型-属性-值表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_goods_type_props_values")
public class Goods_type_props_values extends BaseModel implements Serializable {
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
    @Comment("属性ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String propsId;

    @Column
    @Comment("属性值")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @One(target = Goods_type_props.class, field = "propsId")
    private Goods_type_props typeProps;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM shop_goods_type_props_values"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM shop_goods_type_props_values")
    })
    private Integer location;

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

    public String getPropsId() {
        return propsId;
    }

    public void setPropsId(String propsId) {
        this.propsId = propsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Goods_type_props getTypeProps() {
        return typeProps;
    }

    public void setTypeProps(Goods_type_props typeProps) {
        this.typeProps = typeProps;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }
}
