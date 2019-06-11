package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 会员第三方绑定表
 * Created by wizzer on 2019/6/11
 */
@Table
public class Shop_member_bind extends BaseModel implements Serializable {
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
    @Comment("绑定类型(wx/qq)")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String bind_type;

    @Column
    @Comment("绑定ID")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String bind_id;

    @Column
    @Comment("是否绑定")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean binded;

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

    public String getBind_type() {
        return bind_type;
    }

    public void setBind_type(String bind_type) {
        this.bind_type = bind_type;
    }

    public String getBind_id() {
        return bind_id;
    }

    public void setBind_id(String bind_id) {
        this.bind_id = bind_id;
    }

    public Boolean getBinded() {
        return binded;
    }

    public void setBinded(Boolean binded) {
        this.binded = binded;
    }
}
