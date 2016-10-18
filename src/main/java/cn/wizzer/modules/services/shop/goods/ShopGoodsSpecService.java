package cn.wizzer.modules.services.shop.goods;

import cn.wizzer.common.base.Service;
import cn.wizzer.modules.models.shop.Shop_goods_spec;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

@IocBean(args = {"refer:dao"})
public class ShopGoodsSpecService extends Service<Shop_goods_spec> {
    private static final Log log = Logs.get();
    @Inject
    private ShopGoodsSpecValuesService shopGoodsSpecValuesService;

    public ShopGoodsSpecService(Dao dao) {
        super(dao);
    }

    /**
     * 删除规格的同时删除其值,事务支持
     *
     * @param id
     */
    @Aop(TransAop.READ_COMMITTED)
    public void deleteSpec(String id) {
        shopGoodsSpecValuesService.clear(Cnd.where("specId", "=", id));
        this.delete(id);
    }

    /**
     * 删除规格的同时删除其值,事务支持
     *
     * @param ids
     */
    @Aop(TransAop.READ_COMMITTED)
    public void deleteSpec(String[] ids) {
        shopGoodsSpecValuesService.clear(Cnd.where("specId", "in", ids));
        this.delete(ids);
    }
}

