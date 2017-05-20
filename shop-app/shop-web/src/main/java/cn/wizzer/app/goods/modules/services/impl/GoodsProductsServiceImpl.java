package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.goods.modules.models.Goods_product;
import cn.wizzer.app.goods.modules.services.GoodsProductsService;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.random.R;

@IocBean(args = {"refer:dao"})
public class GoodsProductsServiceImpl extends BaseServiceImpl<Goods_product> implements GoodsProductsService {
    public GoodsProductsServiceImpl(Dao dao) {
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
