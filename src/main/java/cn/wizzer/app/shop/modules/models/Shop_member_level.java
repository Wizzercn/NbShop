package cn.wizzer.app.shop.modules.models;

import cn.wizzer.app.shop.commons.enums.ShopMemberLevelType;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 会员等级表
 * Created by wizzer on 2019/6/12
 */
@Table
public class Shop_member_level  extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("会员ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String memberId;

    @Column
    @Comment("等级名称")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String name;

    @Column
    @Comment("等级类型(member-会员/wholesale-批发商/dealer-零售商)")
    @ColDefine(type = ColType.INT)
    private ShopMemberLevelType type;

    @Column
    @Comment("等级Logo")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String picurl;

    @Column
    @Comment("等级折扣(100%)")
    @ColDefine(type = ColType.INT)
    private Integer price_rate;

    @Column
    @Comment("所需积分")
    @ColDefine(type = ColType.INT)
    private Integer score;

    @Column
    @Comment("启用状态")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean disabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShopMemberLevelType getType() {
        return type;
    }

    public void setType(ShopMemberLevelType type) {
        this.type = type;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public Integer getPrice_rate() {
        return price_rate;
    }

    public void setPrice_rate(Integer price_rate) {
        this.price_rate = price_rate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
