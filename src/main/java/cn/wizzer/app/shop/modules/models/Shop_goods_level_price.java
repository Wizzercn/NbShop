package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;

/**
 * 商品会员等级价
 * Created by wizzer on 2019/6/11
 */
@Table
public class Shop_goods_level_price extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @PrevInsert(els = {@EL("uuid()")})
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
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String levelId;

    @Column
    @Comment("销售价")
    @ColDefine(type = ColType.INT)
    private Integer price;

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

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
