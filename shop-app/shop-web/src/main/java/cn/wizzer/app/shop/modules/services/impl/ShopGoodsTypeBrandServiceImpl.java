package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_type_brand;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypeBrandService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsTypeBrandServiceImpl extends BaseServiceImpl<Shop_goods_type_brand> implements ShopGoodsTypeBrandService {
    public ShopGoodsTypeBrandServiceImpl(Dao dao) {
        super(dao);
    }
}
