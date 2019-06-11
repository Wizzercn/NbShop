package cn.wizzer.app.shop.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * 商城图片表
 * Created by wizzer on 2019/6/11
 */
@Table
public class Shop_image extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String id;

    @Column
    @Comment("文件名")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String file_name;

    @Column
    @Comment("文件大小")
    private Long file_size;

    @Column
    @Comment("原始图")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String src_url;

    @Column
    @Comment("列表图")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String list_url;

    @Column
    @Comment("列表水印图")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String list_url_wm;

    @Column
    @Comment("详情图")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String info_url;

    @Column
    @Comment("详情水印图")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String info_url_wm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public Long getFile_size() {
        return file_size;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    public String getSrc_url() {
        return src_url;
    }

    public void setSrc_url(String src_url) {
        this.src_url = src_url;
    }

    public String getList_url() {
        return list_url;
    }

    public void setList_url(String list_url) {
        this.list_url = list_url;
    }

    public String getList_url_wm() {
        return list_url_wm;
    }

    public void setList_url_wm(String list_url_wm) {
        this.list_url_wm = list_url_wm;
    }

    public String getInfo_url() {
        return info_url;
    }

    public void setInfo_url(String info_url) {
        this.info_url = info_url;
    }

    public String getInfo_url_wm() {
        return info_url_wm;
    }

    public void setInfo_url_wm(String info_url_wm) {
        this.info_url_wm = info_url_wm;
    }
}
