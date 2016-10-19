package cn.wizzer.modules.services.shop.goods;

import cn.wizzer.common.base.Service;
import cn.wizzer.modules.models.shop.Shop_goods_spec;
import cn.wizzer.modules.models.shop.Shop_goods_type;
import cn.wizzer.modules.models.shop.Shop_goods_type_brand;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
@IocBean(args = {"refer:dao"})
public class ShopGoodsTypeService extends Service<Shop_goods_type> {
	private static final Log log = Logs.get();
    @Inject
    private ShopGoodsTypeBrandService shopGoodsTypeBrandService;
    public ShopGoodsTypeService(Dao dao) {
    	super(dao);
    }

    /**
     * 添加类型
     * @param shopGoodsType
     * @param brand
     * @param props_name
     * @param props_values
     * @param specId
     * @param group_name
     * @param group_params
     * @param tab_name
     * @param tab_note
     */
    @Aop(TransAop.READ_COMMITTED)
    public void add(Shop_goods_type shopGoodsType,String[] brand,String[] props_name,
                    String[] props_values,String[] specId,
                    String[] group_name,String[] group_params,
                   String[] tab_name,String[] tab_note) {
        this.insert(shopGoodsType);
        for (int i = 0; i < brand.length; i++) {
            Shop_goods_type_brand brand1 = new Shop_goods_type_brand();
            brand1.setTypeId(shopGoodsType.getId());
            brand1.setBrandId(Strings.sNull(brand[i]));
            shopGoodsTypeBrandService.insert(brand1);
        }
    }
}

