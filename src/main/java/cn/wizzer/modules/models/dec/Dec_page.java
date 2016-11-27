package cn.wizzer.modules.models.dec;

import cn.wizzer.common.base.Model;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 模板页面表
 * Created by wizzer on 2016/11/11.
 */
@Table("dec_page")
public class Dec_page extends Model implements Serializable {
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
    @Comment("页面名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String name;

    @Column
    @Comment("页面名称")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String code;

    @Column
    @Comment("页面类型")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String type;//index-首页 list-商品列表 search-搜索页 item-商品详情页 channel-频道页 article-文章页 car-购物车页 orderdetail-订单页

    @Column
    @Comment("是否禁用")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @Column
    @Comment("访问路径")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String url;

    @Column
    @Comment("页面内容")
    @ColDefine(type = ColType.TEXT)
    private String note;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
