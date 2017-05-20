package cn.wizzer.app.order.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * Created by wizzer on 2017/5/20.
 */
@Table("order_order1")
public class Order_order extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @Prev(els = {@EL("ig(view.tableName,'')")})
    private String id;

    @Column
    @Comment("会员ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String memberId;


}
