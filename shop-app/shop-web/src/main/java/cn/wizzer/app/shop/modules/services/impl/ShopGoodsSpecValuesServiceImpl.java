package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_spec_values;
import cn.wizzer.app.shop.modules.services.ShopGoodsSpecValuesService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsSpecValuesServiceImpl extends BaseServiceImpl<Shop_goods_spec_values> implements ShopGoodsSpecValuesService {
    public ShopGoodsSpecValuesServiceImpl(Dao dao) {
        super(dao);
    }
}
