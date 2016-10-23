package cn.wizzer.modules.services.shop.goods;

import cn.wizzer.common.base.Service;
import cn.wizzer.modules.models.shop.Shop_goods;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Index;
import org.nutz.dao.entity.annotation.TableIndexes;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.Date;

@IocBean(args = {"refer:dao"})
@TableIndexes({@Index(name = "INDEX_SHOP_GOODS_PRODUCT", fields = {"sku"}, unique = true)})
public class ShopGoodsService extends Service<Shop_goods> {
	private static final Log log = Logs.get();

    public ShopGoodsService(Dao dao) {
    	super(dao);
    }

}

