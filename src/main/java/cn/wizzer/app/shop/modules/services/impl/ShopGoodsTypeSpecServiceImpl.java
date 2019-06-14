package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_goods_type_spec;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypeSpecService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopGoodsTypeSpecServiceImpl extends BaseServiceImpl<Shop_goods_type_spec> implements ShopGoodsTypeSpecService {
    public ShopGoodsTypeSpecServiceImpl(Dao dao) {
        super(dao);
    }

}
