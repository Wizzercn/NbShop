package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_goods;
import cn.wizzer.app.shop.modules.models.Shop_goods_spec;
import cn.wizzer.app.shop.modules.services.ShopGoodsService;
import cn.wizzer.app.shop.modules.services.ShopGoodsSpecService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopGoodsSpecServiceImpl extends BaseServiceImpl<Shop_goods_spec> implements ShopGoodsSpecService {
    public ShopGoodsSpecServiceImpl(Dao dao) {
        super(dao);
    }

}
