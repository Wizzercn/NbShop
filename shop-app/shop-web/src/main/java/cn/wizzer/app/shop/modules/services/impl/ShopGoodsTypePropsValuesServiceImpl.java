package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_type_props_values;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypePropsValuesService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsTypePropsValuesServiceImpl extends BaseServiceImpl<Shop_goods_type_props_values> implements ShopGoodsTypePropsValuesService {
    public ShopGoodsTypePropsValuesServiceImpl(Dao dao) {
        super(dao);
    }
}
