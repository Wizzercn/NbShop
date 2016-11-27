package cn.wizzer.modules.models.dec;

import cn.wizzer.common.base.Model;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 页面组件表
 * Created by wizzer on 2016/11/11.
 */
@Table("dec_page_component")
public class Dec_page_component extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("模板ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String templateId;

    @Column
    @Comment("页面ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String pageId;

    @Column
    @Comment("组件ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String componentId;

    @Column
    @Comment("组件参数")
    @ColDefine(type = ColType.TEXT)
    private String params;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}
