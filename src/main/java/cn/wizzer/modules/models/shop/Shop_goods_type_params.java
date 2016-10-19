package cn.wizzer.modules.models.shop;

import cn.wizzer.common.base.Model;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型-参数表
 * Created by wizzer on 2016/10/19.
 */
@Table("shop_goods_type_params")
public class Shop_goods_type_params extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("分组ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String groupId;

    @Column
    @Comment("参数名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @One(target = Shop_goods_type_paramg.class, field = "groupId")
    private Shop_goods_type_paramg typeParamg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop_goods_type_paramg getTypeParamg() {
        return typeParamg;
    }

    public void setTypeParamg(Shop_goods_type_paramg typeParamg) {
        this.typeParamg = typeParamg;
    }
}
