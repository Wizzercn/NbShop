package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_lv_price;
import cn.wizzer.app.shop.modules.services.ShopGoodsLvPriceService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsLvPriceServiceImpl extends BaseServiceImpl<Shop_goods_lv_price> implements ShopGoodsLvPriceService {
    public ShopGoodsLvPriceServiceImpl(Dao dao) {
        super(dao);
    }
}
