package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_image;
import cn.wizzer.app.shop.modules.services.ShopImageService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
public class ShopImageServiceImpl extends BaseServiceImpl<Shop_image> implements ShopImageService {
    public ShopImageServiceImpl(Dao dao) {
        super(dao);
    }

}
