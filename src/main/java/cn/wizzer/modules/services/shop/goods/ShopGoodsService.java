package cn.wizzer.modules.services.shop.goods;

import cn.wizzer.common.base.Service;
import cn.wizzer.modules.models.shop.Shop_goods;
import cn.wizzer.modules.models.shop.Shop_goods_spec;
import cn.wizzer.modules.models.shop.Shop_goods_spec_values;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Index;
import org.nutz.dao.entity.annotation.TableIndexes;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.Date;

@IocBean(args = {"refer:dao"})
public class ShopGoodsService extends Service<Shop_goods> {
	private static final Log log = Logs.get();

    public ShopGoodsService(Dao dao) {
    	super(dao);
    }

    @Aop(TransAop.READ_COMMITTED)
    public void add(Shop_goods shopGoods, Json products,Json spec_values, Json prop_values, Json param_values,
                  Json images) {
        log.debug(images.toString());
    }

}

