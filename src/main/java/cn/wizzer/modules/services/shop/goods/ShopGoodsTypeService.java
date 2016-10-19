package cn.wizzer.modules.services.shop.goods;

import cn.wizzer.common.base.Service;
import cn.wizzer.modules.models.shop.*;
import org.apache.commons.lang3.StringUtils;
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
    @Inject
    private ShopGoodsTypeParamgService shopGoodsTypeParamgService;
    @Inject
    private ShopGoodsTypeParamsService shopGoodsTypeParamsService;
    @Inject
    private ShopGoodsTypePropsService shopGoodsTypePropsService;
    @Inject
    private ShopGoodsTypePropsValuesService shopGoodsTypePropsValuesService;
    @Inject
    private ShopGoodsTypeSpecService shopGoodsTypeSpecService;
    @Inject
    private ShopGoodsTypeTabService shopGoodsTypeTabService;

    public ShopGoodsTypeService(Dao dao) {
        super(dao);
    }

    /**
     * 添加类型
     *
     * @param shopGoodsType
     * @param brand
     * @param props_name
     * @param props_type
     * @param props_values
     * @param specId
     * @param group_name
     * @param group_params
     * @param tab_name
     * @param tab_note
     */
    @Aop(TransAop.READ_COMMITTED)
    public void add(Shop_goods_type shopGoodsType, String[] brand, String[] props_name,String[] props_type,
                    String[] props_values, String[] specId,
                    String[] group_name, String[] group_params,
                    String[] tab_name, String[] tab_note) {
        this.insert(shopGoodsType);
        for (int i = 0; i < brand.length; i++) {
            Shop_goods_type_brand brand1 = new Shop_goods_type_brand();
            brand1.setTypeId(shopGoodsType.getId());
            brand1.setBrandId(Strings.sNull(brand[i]));
            shopGoodsTypeBrandService.insert(brand1);
        }
        for (int i = 0; i < props_name.length; i++) {
            Shop_goods_type_props props=new Shop_goods_type_props();
            props.setTypeId(shopGoodsType.getId());
            props.setName(Strings.sNull(props_name[i]));
            props.setType(Strings.sNull(props_type[i]));
            props.setLocation(i);
            shopGoodsTypePropsService.insert(props);
            String[] pv= StringUtils.split(Strings.sNull(props_values[i]), ",");
            for (int j = 0; j < pv.length; j++) {
                Shop_goods_type_props_values values=new Shop_goods_type_props_values();
                values.setPropsId(props.getId());
                values.setName(Strings.sNull(pv[j]));
                values.setLocation(j);
                shopGoodsTypePropsValuesService.insert(values);
            }
        }
        for (int i = 0; i < specId.length; i++) {
            Shop_goods_type_spec spec=new Shop_goods_type_spec();
            spec.setTypeId(shopGoodsType.getId());
            spec.setSpecId(Strings.sNull(specId[i]));
            spec.setLocation(i);
            shopGoodsTypeSpecService.insert(spec);
        }
        for (int i = 0; i < group_name.length; i++) {
            Shop_goods_type_paramg paramg=new Shop_goods_type_paramg();
            paramg.setTypeId(shopGoodsType.getId());
            paramg.setName(Strings.sNull(group_name[i]));
            paramg.setLocation(i);
            shopGoodsTypeParamgService.insert(paramg);
            String[] params= StringUtils.split(Strings.sNull(group_params[i]), ",");
            for (int j = 0; j < params.length; j++) {
                Shop_goods_type_params params1=new Shop_goods_type_params();
                params1.setGroupId(paramg.getId());
                params1.setName(Strings.sNull(params[j]));
                params1.setLocation(j);
                shopGoodsTypeParamsService.insert(params1);
            }
        }
        for (int i = 0; i < tab_name.length; i++) {
            Shop_goods_type_tab tab=new Shop_goods_type_tab();
            tab.setName(Strings.sNull(tab_name[i]));
            tab.setNote(Strings.sNull(tab_note[i]));
            tab.setTypeId(shopGoodsType.getId());
            shopGoodsTypeTabService.insert(tab);
        }
    }
}

