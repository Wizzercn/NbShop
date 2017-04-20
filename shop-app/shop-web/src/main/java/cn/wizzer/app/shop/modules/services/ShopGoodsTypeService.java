package cn.wizzer.app.shop.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.shop.modules.models.Shop_goods_type;

public interface ShopGoodsTypeService extends BaseService<Shop_goods_type>{
    void add(Shop_goods_type shopGoodsType, String[] brand, String[] props_name, String[] props_type,
             String[] props_values, String[] specId,
             String[] specValIds, String[] specValText,
             String[] group_name, String[] group_params,
             String[] tab_name, String[] tab_note);

    void update(Shop_goods_type shopGoodsType, String[] brand, String[] props_name, String[] props_type,
                String[] props_values, String[] specId,
                String[] specValIds, String[] specValText,
                String[] group_name, String[] group_params,
                String[] tab_name, String[] tab_note, String uid);

    void deleteType(String id);

    void deleteType(String[] ids);
}
