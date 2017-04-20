package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_type_tab;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypeTabService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsTypeTabServiceImpl extends BaseServiceImpl<Shop_goods_type_tab> implements ShopGoodsTypeTabService {
    public ShopGoodsTypeTabServiceImpl(Dao dao) {
        super(dao);
    }
}
