package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型表
 * Created by wizzer on 2019/6/11
 */
@Table
public class Shop_goods_type extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @Column
    @Comment("别名")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String alias_name;

    @Column
    @Comment("实物商品")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean physical;

    @Column
    @Comment("启用规格")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean use_spec;

    @Column
    @Comment("启用属性")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean use_props;

    @Column
    @Comment("启用参数")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean use_params;

    @Column
    @Comment("启用标签")
    @ColDefine(type = ColType.BOOLEAN)
    private Boolean use_tabs;

    @Column
    @Comment("参数JSON")
    @ColDefine(type = ColType.TEXT)
    private String params_json;

    @Column
    @Comment("标签JSON")
    @ColDefine(type = ColType.TEXT)
    private String tabs_json;

    @Many(field = "typeId")
    private List<Shop_goods_type_props> props;

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

    public String getAlias_name() {
        return alias_name;
    }

    public void setAlias_name(String alias_name) {
        this.alias_name = alias_name;
    }

    public Boolean getPhysical() {
        return physical;
    }

    public void setPhysical(Boolean physical) {
        this.physical = physical;
    }

    public Boolean getUse_spec() {
        return use_spec;
    }

    public void setUse_spec(Boolean use_spec) {
        this.use_spec = use_spec;
    }

    public Boolean getUse_props() {
        return use_props;
    }

    public void setUse_props(Boolean use_props) {
        this.use_props = use_props;
    }

    public Boolean getUse_params() {
        return use_params;
    }

    public void setUse_params(Boolean use_params) {
        this.use_params = use_params;
    }

    public Boolean getUse_tabs() {
        return use_tabs;
    }

    public void setUse_tabs(Boolean use_tabs) {
        this.use_tabs = use_tabs;
    }

    public String getParams_json() {
        return params_json;
    }

    public void setParams_json(String params_json) {
        this.params_json = params_json;
    }

    public String getTabs_json() {
        return tabs_json;
    }

    public void setTabs_json(String tabs_json) {
        this.tabs_json = tabs_json;
    }

    public List<Shop_goods_type_props> getProps() {
        return props;
    }

    public void setProps(List<Shop_goods_type_props> props) {
        this.props = props;
    }
}
