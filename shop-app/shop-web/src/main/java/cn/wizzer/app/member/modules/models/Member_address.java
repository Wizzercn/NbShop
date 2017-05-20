package cn.wizzer.app.member.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 收货地址表
 * Created by wizzer on 2017/3/5.
 */
@Table("member_address")
@TableIndexes({@Index(name = "INDEX_MEMBER_USER_ADDRESS", fields = {"memberId"}, unique = false)})
public class Member_address extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("所在省")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String province;

    @Column
    @Comment("所在市")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String city;

    @Column
    @Comment("所在县区")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String county;

    @Column
    @Comment("所在街道")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String town;

    @Column
    @Comment("详细地址")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String address;

    @Column
    @Comment("邮政编码")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String postCode;

    @Column
    @Comment("收货人姓名")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String fullName;

    @Column
    @Comment("收货人手机")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String mobile;

    @Column
    @Comment("收货人电话")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String phone;

    @Column
    @Comment("是否默认")
    private boolean defaultValue;

    @Column
    @Comment("会员ID")
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
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
