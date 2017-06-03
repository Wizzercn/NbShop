package cn.wizzer.app.member.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wizzer on 2017/5/20.
 */
@Table("member_user")
@TableIndexes({@Index(name = "INDEX_MEMBER_USER_LOGINNAMAE", fields = {"loginname"}, unique = true),
        @Index(name = "INDEX_MEMBER_USER_MOBILE", fields = {"mobile"}, unique = true)
})
public class Member_user extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("会员类型")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String typeId;

    @Column
    @Comment("会员等级")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String levelId;

    @Column
    @Comment("登录名")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String loginname;

    @Column
    @Comment("登录邮箱")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String email;

    @Column
    @Comment("登录手机号")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String mobile;

    @Column
    @Comment("密码")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String password;

    @Column
    @Comment("密码盐")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String salt;
    @Column
    @Comment("会员余额")
    @ColDefine(type = ColType.INT)
    private Integer money=0;

    @Column
    @Comment("冻结余额")
    @ColDefine(type = ColType.INT)
    private Integer freezeMoney=0;

    @Column
    @Comment("支付密码")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String payPassword;

    @Column
    @Comment("会员积分")
    @ColDefine(type = ColType.INT)
    private Integer score=0;

    @Column
    @Comment("冻结积分")
    @ColDefine(type = ColType.INT)
    private Integer freezeScore=0;

    @Column
    @Comment("会员历史总积分")//计算会员等级用
    @ColDefine(type = ColType.INT)
    private Integer allScore=0;

    @Column
    @Comment("昵称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String nickname;

    @Column
    @Comment("姓名")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String name;

    @Column
    @Comment("性别")
    @ColDefine(type = ColType.VARCHAR, width = 5)
    private String sex;

    @Column
    @Comment("生日年")
    @ColDefine(type = ColType.INT)
    private Integer b_year;

    @Column
    @Comment("生日月")
    @ColDefine(type = ColType.INT)
    private Integer b_month;

    @Column
    @Comment("生日日")
    @ColDefine(type = ColType.INT)
    private Integer b_day;

    @Column
    @Comment("星座")
    @ColDefine(type = ColType.VARCHAR, width = 5)
    private String astro;

    @Column
    @Comment("所在省")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String provinceId;

    @Column
    @Comment("所在市")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String cityId;

    @Column
    @Comment("注册来源")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String regSrc;

    @Column
    @Comment("注册时间")
    @ColDefine(type = ColType.INT)
    private Integer regAt;

    @Column
    @Comment("是否禁用")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @One(target = Member_type.class, field = "typeId")
    private Member_type memberType;

    @One(target = Member_level.class, field = "levelId")
    private Member_level memberLevel;

    @Many(target = Member_bind.class, field = "memberId")
    private List<Member_bind> memberBindList;

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

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getFreezeMoney() {
        return freezeMoney;
    }

    public void setFreezeMoney(Integer freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getFreezeScore() {
        return freezeScore;
    }

    public void setFreezeScore(Integer freezeScore) {
        this.freezeScore = freezeScore;
    }

    public Integer getAllScore() {
        return allScore;
    }

    public void setAllScore(Integer allScore) {
        this.allScore = allScore;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getB_year() {
        return b_year;
    }

    public void setB_year(Integer b_year) {
        this.b_year = b_year;
    }

    public Integer getB_month() {
        return b_month;
    }

    public void setB_month(Integer b_month) {
        this.b_month = b_month;
    }

    public Integer getB_day() {
        return b_day;
    }

    public void setB_day(Integer b_day) {
        this.b_day = b_day;
    }

    public String getAstro() {
        return astro;
    }

    public void setAstro(String astro) {
        this.astro = astro;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getRegSrc() {
        return regSrc;
    }

    public void setRegSrc(String regSrc) {
        this.regSrc = regSrc;
    }

    public Integer getRegAt() {
        return regAt;
    }

    public void setRegAt(Integer regAt) {
        this.regAt = regAt;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Member_type getMemberType() {
        return memberType;
    }

    public void setMemberType(Member_type memberType) {
        this.memberType = memberType;
    }

    public Member_level getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Member_level memberLevel) {
        this.memberLevel = memberLevel;
    }

    public List<Member_bind> getMemberBindList() {
        return memberBindList;
    }

    public void setMemberBindList(List<Member_bind> memberBindList) {
        this.memberBindList = memberBindList;
    }
}
