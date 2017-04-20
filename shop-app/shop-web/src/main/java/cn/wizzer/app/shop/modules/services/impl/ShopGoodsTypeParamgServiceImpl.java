package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_type_paramg;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypeParamgService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsTypeParamgServiceImpl extends BaseServiceImpl<Shop_goods_type_paramg> implements ShopGoodsTypeParamgService {
    public ShopGoodsTypeParamgServiceImpl(Dao dao) {
        super(dao);
    }
}
