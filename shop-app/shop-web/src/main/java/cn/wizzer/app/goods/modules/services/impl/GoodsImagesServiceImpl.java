package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_images;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.goods.modules.services.GoodsImagesService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsImagesServiceImpl extends BaseServiceImpl<Goods_images> implements GoodsImagesService {
    public GoodsImagesServiceImpl(Dao dao) {
        super(dao);
    }
}
