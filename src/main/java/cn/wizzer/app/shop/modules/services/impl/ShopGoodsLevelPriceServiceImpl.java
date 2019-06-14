package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_goods_level_price;
import cn.wizzer.app.shop.modules.services.ShopGoodsLevelPriceService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopGoodsLevelPriceServiceImpl extends BaseServiceImpl<Shop_goods_level_price> implements ShopGoodsLevelPriceService {
    public ShopGoodsLevelPriceServiceImpl(Dao dao) {
        super(dao);
    }

}
