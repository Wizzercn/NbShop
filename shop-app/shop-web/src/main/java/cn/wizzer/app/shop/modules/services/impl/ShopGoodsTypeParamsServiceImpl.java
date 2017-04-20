package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_type_params;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypeParamsService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsTypeParamsServiceImpl extends BaseServiceImpl<Shop_goods_type_params> implements ShopGoodsTypeParamsService {
    public ShopGoodsTypeParamsServiceImpl(Dao dao) {
        super(dao);
    }
}
