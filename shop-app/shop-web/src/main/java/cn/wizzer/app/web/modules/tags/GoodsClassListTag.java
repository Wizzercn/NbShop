package cn.wizzer.app.web.modules.tags;

import cn.wizzer.app.goods.modules.models.Goods_class;
import cn.wizzer.app.goods.modules.services.GoodsClassService;
import org.beetl.core.GeneralVarTagBinding;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.List;

/**
 * Created by wizzer on 2017/6/3.
 */
@IocBean
public class GoodsClassListTag extends GeneralVarTagBinding {
    private final static Log log = Logs.get();
    @Inject
    private GoodsClassService goodsClassService;

    @Override
    public void render() {
        String parentId = Strings.sNull(this.getAttributeValue("parentId"));
        List<Goods_class> list = goodsClassService.getList(parentId);
        for (Goods_class goodsClass : list) {
            this.binds(goodsClass);
            this.doBodyRender();
        }
    }
}
