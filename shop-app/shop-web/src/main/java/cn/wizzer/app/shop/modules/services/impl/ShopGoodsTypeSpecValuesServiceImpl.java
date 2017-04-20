package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_type_spec_values;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypeSpecValuesService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsTypeSpecValuesServiceImpl extends BaseServiceImpl<Shop_goods_type_spec_values> implements ShopGoodsTypeSpecValuesService {
    public ShopGoodsTypeSpecValuesServiceImpl(Dao dao) {
        super(dao);
    }
}
