package cn.wizzer.app.goods.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型表
 * Created by wizzer on 2016/9/27.
 */
@Table("shop_goods_type")
public class Goods_type extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("类型名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String name;

    @Column
    @Comment("实物商品")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean isPhysical;

    @Column
    @Comment("使用规格")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean hasSpec;

    @Column
    @Comment("使用属性")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean hasProp;

    @Column
    @Comment("使用参数")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean hasParam;

    @Column
    @Comment("自定义Tab")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean hasTab;

    @Column
    @Comment("关联品牌")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean hasBrand;

    @Many(target = Goods_type_spec.class, field = "typeId")
    private List<Goods_type_spec> specList;

    @Many(target = Goods_type_props.class, field = "typeId")
    private List<Goods_type_props> propsList;

    @Many(target = Goods_type_paramg.class, field = "typeId")
    private List<Goods_type_paramg> paramgList;

    @Many(target = Goods_type_tab.class, field = "typeId")
    private List<Goods_type_tab> tabList;

    @Many(target = Goods_type_brand.class, field = "typeId")
    protected List<Goods_type_brand> brandList;

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

    public boolean isPhysical() {
        return isPhysical;
    }

    public void setIsPhysical(boolean isPhysical) {
        this.isPhysical = isPhysical;
    }

    public boolean isHasSpec() {
        return hasSpec;
    }

    public void setHasSpec(boolean hasSpec) {
        this.hasSpec = hasSpec;
    }

    public boolean isHasProp() {
        return hasProp;
    }

    public void setHasProp(boolean hasProp) {
        this.hasProp = hasProp;
    }

    public boolean isHasParam() {
        return hasParam;
    }

    public void setHasParam(boolean hasParam) {
        this.hasParam = hasParam;
    }

    public boolean isHasTab() {
        return hasTab;
    }

    public void setHasTab(boolean hasTab) {
        this.hasTab = hasTab;
    }

    public boolean isHasBrand() {
        return hasBrand;
    }

    public void setHasBrand(boolean hasBrand) {
        this.hasBrand = hasBrand;
    }

    public List<Goods_type_spec> getSpecList() {
        return specList;
    }

    public void setSpecList(List<Goods_type_spec> specList) {
        this.specList = specList;
    }

    public List<Goods_type_props> getPropsList() {
        return propsList;
    }

    public void setPropsList(List<Goods_type_props> propsList) {
        this.propsList = propsList;
    }

    public List<Goods_type_paramg> getParamgList() {
        return paramgList;
    }

    public void setParamgList(List<Goods_type_paramg> paramgList) {
        this.paramgList = paramgList;
    }

    public List<Goods_type_tab> getTabList() {
        return tabList;
    }

    public void setTabList(List<Goods_type_tab> tabList) {
        this.tabList = tabList;
    }

    public List<Goods_type_brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Goods_type_brand> brandList) {
        this.brandList = brandList;
    }
}
