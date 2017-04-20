package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_images;
import cn.wizzer.app.shop.modules.services.ShopGoodsImagesService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class ShopGoodsImagesServiceImpl extends BaseServiceImpl<Shop_goods_images> implements ShopGoodsImagesService {
    public ShopGoodsImagesServiceImpl(Dao dao) {
        super(dao);
    }
}
