package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_brand;
import cn.wizzer.app.shop.modules.services.ShopGoodsBrandService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsBrandServiceImpl extends BaseServiceImpl<Shop_goods_brand> implements ShopGoodsBrandService {
    public ShopGoodsBrandServiceImpl(Dao dao) {
        super(dao);
    }
}
