package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_goods_products;
import cn.wizzer.app.shop.modules.services.ShopGoodsProductsService;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.random.R;

@IocBean(args = {"refer:dao"})
public class ShopGoodsProductsServiceImpl extends BaseServiceImpl<Shop_goods_products> implements ShopGoodsProductsService {
    public ShopGoodsProductsServiceImpl(Dao dao) {
        super(dao);
    }

    /**
     * 加个注释吧，这个是获取货号前缀的
     * @return
     */
    public String getSkuPrefix(){
        String uuid= "S"+ R.UU32().substring(1,12).toUpperCase();
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
