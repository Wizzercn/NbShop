package cn.wizzer.modules.models.shop;

import cn.wizzer.common.base.Model;
import org.nutz.dao.DB;
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

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM shop_goods_type_params"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM shop_goods_type_params")
    })
    private Integer location;

    @One(target = Shop_goods_type_paramg.class, field = "groupId")
    private Shop_goods_type_paramg paramg;

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

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Shop_goods_type_paramg getParamg() {
        return paramg;
    }

    public void setParamg(Shop_goods_type_paramg paramg) {
        this.paramg = paramg;
    }
}
