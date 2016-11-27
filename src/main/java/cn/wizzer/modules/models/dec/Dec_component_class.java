package cn.wizzer.modules.models.dec;

import cn.wizzer.common.base.Model;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 组件分类表
 * Created by wizzer on 2016/11/11.
 */
@Table("dec_component_class")
public class Dec_component_class extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("分类名称")
    @ColDefine(type = ColType.VARCHAR, width = 120)
    private String name;

    @Many(target = Dec_component.class, field = "classId")
    protected List<Dec_component> componentList;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db= DB.MYSQL,value = "SELECT IFNULL(MAX(location),0)+1 FROM dec_component_class"),
            @SQL(db= DB.ORACLE,value = "SELECT COALESCE(MAX(location),0)+1 FROM dec_component_class")
    })
    private Integer location;

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

    public List<Dec_component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Dec_component> componentList) {
        this.componentList = componentList;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }
}
