package cn.wizzer.app.goods.modules.services;

import cn.wizzer.app.goods.modules.models.Goods_spec;
import cn.wizzer.framework.base.service.BaseService;

public interface GoodsSpecService extends BaseService<Goods_spec> {
    void add(Goods_spec shopGoodsSpec, String[] spec_value, String[] spec_picurl);

    void update(Goods_spec shopGoodsSpec, String[] spec_value, String[] spec_picurl, String[] spec_value_id, String uid);

    void deleteSpec(String id);

    void deleteSpec(String[] ids);
}
