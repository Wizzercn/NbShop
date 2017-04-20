package cn.wizzer.app.shop.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.shop.modules.models.Shop_goods_spec;

public interface ShopGoodsSpecService extends BaseService<Shop_goods_spec> {
    void add(Shop_goods_spec shopGoodsSpec, String[] spec_value, String[] spec_picurl);

    void update(Shop_goods_spec shopGoodsSpec, String[] spec_value, String[] spec_picurl,String[] spec_value_id, String uid);

    void deleteSpec(String id);

    void deleteSpec(String[] ids);
}
