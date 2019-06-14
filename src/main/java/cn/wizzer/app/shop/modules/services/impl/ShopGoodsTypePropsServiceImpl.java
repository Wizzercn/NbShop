package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_goods_type_props;
import cn.wizzer.app.shop.modules.services.ShopGoodsTypePropsService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopGoodsTypePropsServiceImpl extends BaseServiceImpl<Shop_goods_type_props> implements ShopGoodsTypePropsService {
    public ShopGoodsTypePropsServiceImpl(Dao dao) {
        super(dao);
    }

}
