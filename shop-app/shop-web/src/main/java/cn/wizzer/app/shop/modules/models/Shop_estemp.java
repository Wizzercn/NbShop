package cn.wizzer.app.shop.modules.models;

import cn.wizzer.app.goods.modules.models.Goods_goods;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 搜索引擎临时数据表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_estemp")
public class Shop_estemp extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("商品ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String goodsId;

    @Column
    @Comment("操作类型")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String action;//create  update  delete

    @One(target = Goods_goods.class, field = "goodsId")
    private Goods_goods goods;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Goods_goods getGoods() {
        return goods;
    }

    public void setGoods(Goods_goods goods) {
        this.goods = goods;
    }
}
