package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_tag;
import cn.wizzer.app.shop.modules.services.ShopGoodsTagService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsTagServiceImpl extends BaseServiceImpl<Shop_goods_tag> implements ShopGoodsTagService {
    public ShopGoodsTagServiceImpl(Dao dao) {
        super(dao);
    }
}
