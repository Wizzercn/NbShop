package cn.wizzer.modules.models.dec;

import cn.wizzer.common.base.Model;
import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 组件表
 * Created by wizzer on 2016/11/11.
 */
@Table("dec_component")
public class Dec_component extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("分类ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String classId;

    @Column
    @Comment("组件名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String name;

    @Column
    @Comment("组件代码")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String code;

    @Column
    @Comment("组件版本号")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String version;

    @Column
    @Comment("组件作者")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String author;

    @Column
    @Comment("是否禁用")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db= DB.MYSQL,value = "SELECT IFNULL(MAX(location),0)+1 FROM dec_component"),
            @SQL(db= DB.ORACLE,value = "SELECT COALESCE(MAX(location),0)+1 FROM dec_component")
    })
    private Integer location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }
}
