package cn.wizzer.app.sms.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 短信配置表
 * Created by wizzer on 2016/9/27.
 */
@Table("sms_config")
public class Sms_config extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @ColDefine(type = ColType.VARCHAR,width = 255)
    private String app_key;

    @Column
    @ColDefine(type = ColType.VARCHAR,width = 255)
    private String app_secret;

    @Column
    @Comment("短信签名")
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private String sms_sign_name;

    @Column
    @Comment("用户注册验证码模板")
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private String sms_reg_template;

    @Column
    @Comment("身份验证验证码模板")
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private String sms_check_template;

    @Column
    @Comment("登陆确认验证码模板")
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private String sms_login_template;

    @Column
    @Comment("修改密码验证码模板")
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private String sms_password_template;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getApp_secret() {
        return app_secret;
    }

    public void setApp_secret(String app_secret) {
        this.app_secret = app_secret;
    }

    public String getSms_sign_name() {
        return sms_sign_name;
    }

    public void setSms_sign_name(String sms_sign_name) {
        this.sms_sign_name = sms_sign_name;
    }

    public String getSms_reg_template() {
        return sms_reg_template;
    }

    public void setSms_reg_template(String sms_reg_template) {
        this.sms_reg_template = sms_reg_template;
    }

    public String getSms_check_template() {
        return sms_check_template;
    }

    public void setSms_check_template(String sms_check_template) {
        this.sms_check_template = sms_check_template;
    }

    public String getSms_login_template() {
        return sms_login_template;
    }

    public void setSms_login_template(String sms_login_template) {
        this.sms_login_template = sms_login_template;
    }

    public String getSms_password_template() {
        return sms_password_template;
    }

    public void setSms_password_template(String sms_password_template) {
        this.sms_password_template = sms_password_template;
    }
}
