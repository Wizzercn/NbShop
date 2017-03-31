package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 会员等级表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_member_lv")
public class Shop_member_lv extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("等级名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @Column
    @Comment("等级类型")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String lv_type;//'member', 'wholesale','dealer'

    @Column
    @Comment("等级图标")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String lv_logo;

    @Column
    @Comment("折扣率")
    @ColDefine(type = ColType.INT)
    private int dis_count;

    @Column
    @Comment("所需积分")
    @ColDefine(type = ColType.INT)
    private int point;

    @Column
    @Comment("积分类型")
    @ColDefine(type = ColType.INT)
    private int point_type;//0 总积分 1 消费积分  2 行为积分

    @Column
    @Comment("是否禁用")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @Column
    @Comment("是否默认")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean isDefault;

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

    public String getLv_type() {
        return lv_type;
    }

    public void setLv_type(String lv_type) {
        this.lv_type = lv_type;
    }

    public String getLv_logo() {
        return lv_logo;
    }

    public void setLv_logo(String lv_logo) {
        this.lv_logo = lv_logo;
    }

    public int getDis_count() {
        return dis_count;
    }

    public void setDis_count(int dis_count) {
        this.dis_count = dis_count;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint_type() {
        return point_type;
    }

    public void setPoint_type(int point_type) {
        this.point_type = point_type;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
