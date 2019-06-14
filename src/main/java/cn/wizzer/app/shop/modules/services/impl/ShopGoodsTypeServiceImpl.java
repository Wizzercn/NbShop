package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_goods_type;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypeService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopGoodsTypeServiceImpl extends BaseServiceImpl<Shop_goods_type> implements ShopGoodsTypeService {
    public ShopGoodsTypeServiceImpl(Dao dao) {
        super(dao);
    }

}
