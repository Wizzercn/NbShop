package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 会员表
 * Created by wizzer on 2019/6/11
 */
@Table
@TableIndexes({@Index(name = "IDX_SHOP_MEMBER_M", fields = {"mobile"}, unique = true)})
public class Shop_member extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("会员等级ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String levelId;

    @Column
    @Comment("会员昵称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String nickname;

    @Column
    @Comment("真实姓名")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String realname;

    @Column
    @Comment("性别(0-未设置 1-男 2-女)")
    @ColDefine(type = ColType.INT,width = 1)
    private Integer sex;

    @Column
    @Comment("手机号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String mobile;

    @Column
    @Comment("登录密码")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String login_pwd;

    @Column
    @Comment("密码盐")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String login_pwd_salt;

    @Column
    @Comment("会员头像")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String headimgurl;

    @Column
    @Comment("省")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String province;

    @Column
    @Comment("市")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String city;

    @Column
    @Comment("县区")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String area;

    @Column
    @Comment("详细地址")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String address;

    @Column
    @Comment("生日")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String birthday;

    @Column
    @Comment("会员余额")
    @ColDefine(type = ColType.INT)
    private Integer money;

    @Column
    @Comment("冻结余额")
    @ColDefine(type = ColType.INT)
    private Integer money_freeze;

    @Column
    @Comment("支付密码")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String money_password;

    @Column
    @Comment("支付密码盐")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String money_password_salt;

    @Column
    @Comment("会员积分")
    @ColDefine(type = ColType.INT)
    private Integer score;

    @Column
    @Comment("订单数")
    @ColDefine(type = ColType.INT)
    private Integer num_order;

    @Column
    @Comment("最后登陆IP")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String login_ip;

    @Column
    @Comment("最后登陆时间")
    private Long login_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLogin_pwd() {
        return login_pwd;
    }

    public void setLogin_pwd(String login_pwd) {
        this.login_pwd = login_pwd;
    }

    public String getLogin_pwd_salt() {
        return login_pwd_salt;
    }

    public void setLogin_pwd_salt(String login_pwd_salt) {
        this.login_pwd_salt = login_pwd_salt;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoney_freeze() {
        return money_freeze;
    }

    public void setMoney_freeze(Integer money_freeze) {
        this.money_freeze = money_freeze;
    }

    public String getMoney_password() {
        return money_password;
    }

    public void setMoney_password(String money_password) {
        this.money_password = money_password;
    }

    public String getMoney_password_salt() {
        return money_password_salt;
    }

    public void setMoney_password_salt(String money_password_salt) {
        this.money_password_salt = money_password_salt;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getNum_order() {
        return num_order;
    }

    public void setNum_order(Integer num_order) {
        this.num_order = num_order;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    public Long getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Long login_time) {
        this.login_time = login_time;
    }
}
