package cn.wizzer.modules.models.shop;

import cn.wizzer.common.base.Model;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型-参数分组表
 * Created by wizzer on 2016/10/19.
 */
@Table("shop_goods_type_paramg")
public class Shop_goods_type_paramg extends Model implements Serializable {
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
    @Comment("分组名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db = DB.MYSQL, value = "SELECT IFNULL(MAX(location),0)+1 FROM shop_goods_type_paramg"),
            @SQL(db = DB.ORACLE, value = "SELECT COALESCE(MAX(location),0)+1 FROM shop_goods_type_paramg")
    })
    private Integer location;

    @One(target = Shop_goods_type.class, field = "typeId")
    private Shop_goods_type goodsType;

    @Many(target = Shop_goods_type_params.class, field = "groupId")
    private List<Shop_goods_type_params> params;

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

    public Shop_goods_type getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Shop_goods_type goodsType) {
        this.goodsType = goodsType;
    }

    public List<Shop_goods_type_params> getParams() {
        return params;
    }

    public void setParams(List<Shop_goods_type_params> params) {
        this.params = params;
    }
}
