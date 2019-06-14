package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_goods_image;
import cn.wizzer.app.shop.modules.services.ShopGoodsImageService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopGoodsImageServiceImpl extends BaseServiceImpl<Shop_goods_image> implements ShopGoodsImageService {
    public ShopGoodsImageServiceImpl(Dao dao) {
        super(dao);
    }

}
