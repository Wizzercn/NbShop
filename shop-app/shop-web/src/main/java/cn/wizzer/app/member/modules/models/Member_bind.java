package cn.wizzer.app.member.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 第三方登录表
 * Created by wizzer on 2017/4/8.
 */
@Table("member_bind")
@TableIndexes({@Index(name = "INDEX_MEMBER_BIND", fields = {"memberId"}, unique = false)})
public class Member_bind extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("第三方类型")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String bind_type;//qq  weibo  wechat

    @Column
    @Comment("第三方帐号")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String bind_openid;

    @Column
    @Comment("第三方昵称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String bind_nickname;

    @Column
    @Comment("是否禁用")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @Column
    @Comment("是否绑定")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean binded;

    @Column
    @Comment("绑定时间")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.INT)
    private Integer bindAt;

    @Column
    @Comment("帐号ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String memberId;

    @One(target = Member_user.class, field = "memberId")
    private Member_user memberUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBind_type() {
        return bind_type;
    }

    public void setBind_type(String bind_type) {
        this.bind_type = bind_type;
    }

    public String getBind_openid() {
        return bind_openid;
    }

    public void setBind_openid(String bind_openid) {
        this.bind_openid = bind_openid;
    }

    public String getBind_nickname() {
        return bind_nickname;
    }

    public void setBind_nickname(String bind_nickname) {
        this.bind_nickname = bind_nickname;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isBinded() {
        return binded;
    }

    public void setBinded(boolean binded) {
        this.binded = binded;
    }

    public Integer getBindAt() {
        return bindAt;
    }

    public void setBindAt(Integer bindAt) {
        this.bindAt = bindAt;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Member_user getMemberUser() {
        return memberUser;
    }

    public void setMemberUser(Member_user memberUser) {
        this.memberUser = memberUser;
    }
}
