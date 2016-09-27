package cn.wizzer.modules.models.shop;

import cn.wizzer.common.base.Model;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_goods_type")
public class Shop_goods_type extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("类型名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @Column
    @Comment("实物商品")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean isPhysical;

    @Column
    @Comment("使用规格")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean hasSpec;

    @Column
    @Comment("使用属性")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean hasProp;

    @Many(target = Shop_goods_type_props.class, field = "typeId")
    private List<Shop_goods_type_props> propsList;

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

    public boolean isPhysical() {
        return isPhysical;
    }

    public void setIsPhysical(boolean isPhysical) {
        this.isPhysical = isPhysical;
    }

    public boolean isHasSpec() {
        return hasSpec;
    }

    public void setHasSpec(boolean hasSpec) {
        this.hasSpec = hasSpec;
    }

    public boolean isHasProp() {
        return hasProp;
    }

    public void setHasProp(boolean hasProp) {
        this.hasProp = hasProp;
    }

    public List<Shop_goods_type_props> getPropsList() {
        return propsList;
    }

    public void setPropsList(List<Shop_goods_type_props> propsList) {
        this.propsList = propsList;
    }
}
