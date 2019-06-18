package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;

import java.io.Serializable;

/**
 * 会员收货地址表
 * Created by wizzer on 2019/6/11
 */
@Table
public class Shop_member_address extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @PrevInsert(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("会员ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String memberId;

    @Column
    @Comment("名称")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String name;

    @Column
    @Comment("手机号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String mobile;

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
    @Comment("邮编")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String postcode;

    @Column
    @Comment("详细地址")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String address;

    @Column
    @Comment("默认地址")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean default_true;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDefault_true() {
        return default_true;
    }

    public void setDefault_true(Boolean default_true) {
        this.default_true = default_true;
    }
}
