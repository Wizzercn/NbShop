package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_goods_spec_value;
import cn.wizzer.app.shop.modules.services.ShopGoodsSpecValueService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopGoodsSpecValueServiceImpl extends BaseServiceImpl<Shop_goods_spec_value> implements ShopGoodsSpecValueService {
    public ShopGoodsSpecValueServiceImpl(Dao dao) {
        super(dao);
    }

}
