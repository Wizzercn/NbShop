package cn.wizzer.modules.services.shop.goods;

import cn.wizzer.common.base.Service;
import cn.wizzer.common.util.StringUtil;
import cn.wizzer.modules.models.shop.Shop_goods_products;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.random.R;
import org.nutz.log.Log;
import org.nutz.log.Logs;
@IocBean(args = {"refer:dao"})
public class ShopGoodsProductsService extends Service<Shop_goods_products> {
	private static final Log log = Logs.get();

    public ShopGoodsProductsService(Dao dao) {
    	super(dao);
    }

    /**
     * 加个注释吧，这个是获取货号前缀的
     * @return
     */
    public String getSkuPrefix(){
        String uuid= "S"+R.UU32().substring(1,12).toUpperCase();
        if(dao().meta().isMySql()){
            if(null!=this.fetch(Cnd.where("SUBSTRING(sku,1,12)","=",uuid))){
                return getSkuPrefix();
            }
        }
        if(dao().meta().isOracle()){
            if(null!=this.fetch(Cnd.where("SUBSTR(sku,1,12)","=",uuid))){
                return getSkuPrefix();
            }
        }
        return uuid;
    }
}

