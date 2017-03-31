package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 商品会员价表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_goods_lv_price")
public class Shop_goods_lv_price extends BaseModel implements Serializable {
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
    @Comment("货品ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String productId;

    @Column
    @Comment("等级ID")
    @ColDefine(type = ColType.VARCHAR)
    private String lvId;

    @Column
    @Comment("等级价格")
    @ColDefine(type = ColType.INT)
    private int lvPrice;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLvId() {
        return lvId;
    }

    public void setLvId(String lvId) {
        this.lvId = lvId;
    }

    public int getLvPrice() {
        return lvPrice;
    }

    public void setLvPrice(int lvPrice) {
        this.lvPrice = lvPrice;
    }
}
