package cn.wizzer.app.goods.modules.services;

import cn.wizzer.app.goods.modules.models.Goods_class;
import cn.wizzer.framework.base.service.BaseService;
import org.nutz.dao.Cnd;

import java.util.List;

public interface GoodsClassService extends BaseService<Goods_class> {
    void save(Goods_class goodsClass, String pid);

    void deleteAndChild(Goods_class goodsClass);

    Goods_class getGoodsClass(Cnd cnd);

    List<Goods_class> getList(Cnd cnd);

    List<Goods_class> getList(String parentId);

    void clearCache();
}
