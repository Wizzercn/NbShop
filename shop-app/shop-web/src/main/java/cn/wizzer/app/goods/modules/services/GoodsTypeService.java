package cn.wizzer.app.goods.modules.services;

import cn.wizzer.app.goods.modules.models.Goods_type;
import cn.wizzer.framework.base.service.BaseService;

public interface GoodsTypeService extends BaseService<Goods_type> {
    void add(Goods_type shopGoodsType, String[] brand, String[] props_name, String[] props_type,
             String[] props_values, String[] specId,
             String[] specValIds, String[] specValText, String[] specValUrl,
             String[] group_name, String[] group_params,
             String[] tab_name, String[] tab_note);

    void update(Goods_type shopGoodsType, String[] brand, String[] props_name, String[] props_type,
                String[] props_values, String[] specId,
                String[] specValIds, String[] specValText, String[] specValUrl,
                String[] group_name, String[] group_params,
                String[] tab_name, String[] tab_note, String uid);

    void deleteType(String id);

    void deleteType(String[] ids);
}
