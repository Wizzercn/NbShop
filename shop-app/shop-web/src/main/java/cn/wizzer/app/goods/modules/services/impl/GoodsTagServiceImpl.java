package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_tag;
import cn.wizzer.app.goods.modules.services.GoodsTagService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GoodsTagServiceImpl extends BaseServiceImpl<Goods_tag> implements GoodsTagService {
    public GoodsTagServiceImpl(Dao dao) {
        super(dao);
    }
}
