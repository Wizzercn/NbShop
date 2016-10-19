package cn.wizzer.modules.models.shop;

import cn.wizzer.common.base.Model;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型-参数分组表
 * Created by wizzer on 2016/10/19.
 */
@Table("shop_goods_type_tab")
public class Shop_goods_type_tab extends Model implements Serializable {
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
    @Comment("标签名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @Column
    @Comment("标签内容")
    @ColDefine(type = ColType.TEXT)
    private String note;

    @One(target = Shop_goods_type.class, field = "typeId")
    private Shop_goods_type goodsType;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Shop_goods_type getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Shop_goods_type goodsType) {
        this.goodsType = goodsType;
    }
}
