package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_goods_brand;
import cn.wizzer.app.shop.modules.services.ShopGoodsBrandService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopGoodsBrandServiceImpl extends BaseServiceImpl<Shop_goods_brand> implements ShopGoodsBrandService {
    public ShopGoodsBrandServiceImpl(Dao dao) {
        super(dao);
    }

}
