package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.*;
import cn.wizzer.app.goods.modules.services.*;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

@IocBean(args = {"refer:dao"})
public class GoodsTypeServiceImpl extends BaseServiceImpl<Goods_type> implements GoodsTypeService {
    public GoodsTypeServiceImpl(Dao dao) {
        super(dao);
    }

    private static final Log log = Logs.get();
    @Inject
    private GoodsTypeBrandService shopGoodsTypeBrandService;
    @Inject
    private GoodsTypeParamgService shopGoodsTypeParamgService;
    @Inject
    private GoodsTypeParamsService shopGoodsTypeParamsService;
    @Inject
    private GoodsTypePropsService shopGoodsTypePropsService;
    @Inject
    private GoodsTypePropsValuesService shopGoodsTypePropsValuesService;
    @Inject
    private GoodsTypeSpecService shopGoodsTypeSpecService;
    @Inject
    private GoodsTypeTabService shopGoodsTypeTabService;
    @Inject
    private GoodsTypeSpecValuesService shopGoodsTypeSpecValuesService;

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
    public void add(Goods_type shopGoodsType, String[] brand, String[] props_name, String[] props_type,
                    String[] props_values, String[] specId,
                    String[] specValIds, String[] specValText, String[] specValUrl,
                    String[] group_name, String[] group_params,
                    String[] tab_name, String[] tab_note) {
        this.insert(shopGoodsType);
        if (brand != null && shopGoodsType.isHasBrand()) {
            for (int i = 0; i < brand.length; i++) {
                Goods_type_brand brand1 = new Goods_type_brand();
                brand1.setTypeId(shopGoodsType.getId());
                brand1.setBrandId(Strings.sNull(brand[i]));
                shopGoodsTypeBrandService.insert(brand1);
            }
        }
        if (props_name != null && shopGoodsType.isHasProp()) {
            for (int i = 0; i < props_name.length; i++) {
                Goods_type_props props = new Goods_type_props();
                props.setTypeId(shopGoodsType.getId());
                props.setName(Strings.sNull(props_name[i]));
                props.setType(Strings.sNull(props_type[i]));
                props.setLocation(i);
                shopGoodsTypePropsService.insert(props);
                String[] pv = StringUtils.split(Strings.sNull(props_values[i]), ",");
                for (int j = 0; j < pv.length; j++) {
                    Goods_type_props_values values = new Goods_type_props_values();
                    values.setPropsId(props.getId());
                    values.setName(Strings.sNull(pv[j]));
                    values.setLocation(j);
                    values.setTypeId(shopGoodsType.getId());
                    shopGoodsTypePropsValuesService.insert(values);
                }
            }
        }
        if (specId != null && shopGoodsType.isHasSpec()) {
            for (int i = 0; i < specId.length; i++) {
                Goods_type_spec spec = new Goods_type_spec();
                spec.setTypeId(shopGoodsType.getId());
                spec.setSpecId(Strings.sNull(specId[i]));
                spec.setLocation(i);
                shopGoodsTypeSpecService.insert(spec);
                //保存规格值
                String[] specValIdsTemp = StringUtils.split(Strings.sNull(specValIds[i]), ",");
                String[] specValTextTemp = StringUtils.split(Strings.sNull(specValText[i]), ",");
                String[] specValUrlTemp = StringUtils.split(Strings.sNull(specValUrl[i]), ",");
                for (int j = 0; j < specValIdsTemp.length; j++) {
                    if (!Strings.isBlank(specValIdsTemp[j])) {
                        Goods_type_spec_values spec_values = new Goods_type_spec_values();
                        spec_values.setSpecId(specId[i]);
                        spec_values.setSpecValueId(specValIdsTemp[j]);
                        spec_values.setTypeId(shopGoodsType.getId());
                        spec_values.setTypeSpecId(spec.getId());
                        spec_values.setSpecValText(specValTextTemp[j]);
                        if (specValIdsTemp.length == specValUrlTemp.length)
                            spec_values.setSpecValUrl(specValUrlTemp[j]);
                        spec_values.setLocation(j);
                        shopGoodsTypeSpecValuesService.insert(spec_values);
                    }

                }
            }
        }
        if (group_name != null && shopGoodsType.isHasParam()) {
            for (int i = 0; i < group_name.length; i++) {
                Goods_type_paramg paramg = new Goods_type_paramg();
                paramg.setTypeId(shopGoodsType.getId());
                paramg.setName(Strings.sNull(group_name[i]));
                paramg.setLocation(i);
                shopGoodsTypeParamgService.insert(paramg);
                String[] params = StringUtils.split(Strings.sNull(group_params[i]), ",");
                for (int j = 0; j < params.length; j++) {
                    Goods_type_params params1 = new Goods_type_params();
                    params1.setGroupId(paramg.getId());
                    params1.setName(Strings.sNull(params[j]));
                    params1.setLocation(j);
                    params1.setTypeId(shopGoodsType.getId());
                    shopGoodsTypeParamsService.insert(params1);
                }
            }
        }
        if (tab_name != null && shopGoodsType.isHasTab()) {
            for (int i = 0; i < tab_name.length; i++) {
                Goods_type_tab tab = new Goods_type_tab();
                tab.setName(Strings.sNull(tab_name[i]));
                tab.setNote(Strings.sNull(tab_note[i]));
                tab.setTypeId(shopGoodsType.getId());
                tab.setLocation(i);
                shopGoodsTypeTabService.insert(tab);
            }
        }
    }

    /**
     * 修改类型
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
     * @param uid
     */
    @Aop(TransAop.READ_COMMITTED)
    public void update(Goods_type shopGoodsType, String[] brand, String[] props_name, String[] props_type,
                       String[] props_values, String[] specId,
                       String[] specValIds, String[] specValText, String[] specValUrl,
                       String[] group_name, String[] group_params,
                       String[] tab_name, String[] tab_note, String uid) {
        shopGoodsType.setOpAt((int) (System.currentTimeMillis() / 1000));
        shopGoodsType.setOpBy(uid);
        this.updateIgnoreNull(shopGoodsType);
        shopGoodsTypeBrandService.clear(Cnd.where("typeId", "=", shopGoodsType.getId()));
        if (brand != null && shopGoodsType.isHasBrand()) {
            for (int i = 0; i < brand.length; i++) {
                Goods_type_brand brand1 = new Goods_type_brand();
                brand1.setTypeId(shopGoodsType.getId());
                brand1.setBrandId(Strings.sNull(brand[i]));
                shopGoodsTypeBrandService.insert(brand1);
            }
        }
        shopGoodsTypePropsValuesService.clear(Cnd.where("typeId", "=", shopGoodsType.getId()));
        shopGoodsTypePropsService.clear(Cnd.where("typeId", "=", shopGoodsType.getId()));
        if (props_name != null && shopGoodsType.isHasProp()) {
            for (int i = 0; i < props_name.length; i++) {
                Goods_type_props props = new Goods_type_props();
                props.setTypeId(shopGoodsType.getId());
                props.setName(Strings.sNull(props_name[i]));
                props.setType(Strings.sNull(props_type[i]));
                props.setLocation(i);
                shopGoodsTypePropsService.insert(props);
                String[] pv = StringUtils.split(Strings.sNull(props_values[i]), ",");
                for (int j = 0; j < pv.length; j++) {
                    Goods_type_props_values values = new Goods_type_props_values();
                    values.setPropsId(props.getId());
                    values.setName(Strings.sNull(pv[j]));
                    values.setLocation(j);
                    values.setTypeId(shopGoodsType.getId());
                    shopGoodsTypePropsValuesService.insert(values);
                }
            }
        }
        shopGoodsTypeSpecService.clear(Cnd.where("typeId", "=", shopGoodsType.getId()));
        if (specId != null && shopGoodsType.isHasSpec()) {
            shopGoodsTypeSpecValuesService.clear(Cnd.where("typeId", "=", shopGoodsType.getId()));
            for (int i = 0; i < specId.length; i++) {
                Goods_type_spec spec = new Goods_type_spec();
                spec.setTypeId(shopGoodsType.getId());
                spec.setSpecId(Strings.sNull(specId[i]));
                spec.setLocation(i);
                shopGoodsTypeSpecService.insert(spec);
                //保存规格值
                String[] specValIdsTemp = StringUtils.split(Strings.sNull(specValIds[i]), ",");
                String[] specValTextTemp = StringUtils.split(Strings.sNull(specValText[i]), ",");
                String[] specValUrlTemp = null;
                if (specValUrl != null)
                    specValUrlTemp = StringUtils.split(Strings.sNull(specValUrl[i]), ",");
                for (int j = 0; j < specValIdsTemp.length; j++) {
                    if (!Strings.isBlank(specValIdsTemp[j])) {
                        Goods_type_spec_values spec_values = new Goods_type_spec_values();
                        spec_values.setSpecId(specId[i]);
                        spec_values.setSpecValueId(specValIdsTemp[j]);
                        spec_values.setTypeId(shopGoodsType.getId());
                        spec_values.setTypeSpecId(spec.getId());
                        spec_values.setSpecValText(specValTextTemp[j]);
                        if (specValUrlTemp != null && specValIdsTemp.length == specValUrlTemp.length)
                            spec_values.setSpecValUrl(specValUrlTemp[j]);
                        spec_values.setLocation(j);
                        shopGoodsTypeSpecValuesService.insert(spec_values);
                    }

                }
            }
        }
        shopGoodsTypeParamsService.clear(Cnd.where("typeId", "=", shopGoodsType.getId()));
        shopGoodsTypeParamgService.clear(Cnd.where("typeId", "=", shopGoodsType.getId()));
        if (group_name != null && shopGoodsType.isHasParam()) {
            for (int i = 0; i < group_name.length; i++) {
                Goods_type_paramg paramg = new Goods_type_paramg();
                paramg.setTypeId(shopGoodsType.getId());
                paramg.setName(Strings.sNull(group_name[i]));
                paramg.setLocation(i);
                shopGoodsTypeParamgService.insert(paramg);
                String[] params = StringUtils.split(Strings.sNull(group_params[i]), ",");
                for (int j = 0; j < params.length; j++) {
                    Goods_type_params params1 = new Goods_type_params();
                    params1.setGroupId(paramg.getId());
                    params1.setName(Strings.sNull(params[j]));
                    params1.setLocation(j);
                    params1.setTypeId(shopGoodsType.getId());
                    shopGoodsTypeParamsService.insert(params1);
                }
            }
        }
        shopGoodsTypeTabService.clear(Cnd.where("typeId", "=", shopGoodsType.getId()));
        if (tab_name != null && shopGoodsType.isHasTab()) {
            for (int i = 0; i < tab_name.length; i++) {
                Goods_type_tab tab = new Goods_type_tab();
                tab.setName(Strings.sNull(tab_name[i]));
                tab.setNote(Strings.sNull(tab_note[i]));
                tab.setTypeId(shopGoodsType.getId());
                tab.setLocation(i);
                shopGoodsTypeTabService.insert(tab);
            }
        }
    }

    /**
     * 删除类型
     *
     * @param id
     */
    @Aop(TransAop.READ_COMMITTED)
    public void deleteType(String id) {
        shopGoodsTypeBrandService.clear(Cnd.where("typeId", "=", id));
        shopGoodsTypePropsValuesService.clear(Cnd.where("typeId", "=", id));
        shopGoodsTypeSpecService.clear(Cnd.where("typeId", "=", id));
        shopGoodsTypeParamsService.clear(Cnd.where("typeId", "=", id));
        shopGoodsTypeParamgService.clear(Cnd.where("typeId", "=", id));
        shopGoodsTypeTabService.clear(Cnd.where("typeId", "=", id));
        this.delete(id);
    }

    /**
     * 删除规类型
     *
     * @param ids
     */
    @Aop(TransAop.READ_COMMITTED)
    public void deleteType(String[] ids) {
        shopGoodsTypeBrandService.clear(Cnd.where("typeId", "in", ids));
        shopGoodsTypePropsValuesService.clear(Cnd.where("typeId", "in", ids));
        shopGoodsTypeSpecService.clear(Cnd.where("typeId", "in", ids));
        shopGoodsTypeParamsService.clear(Cnd.where("typeId", "in", ids));
        shopGoodsTypeParamgService.clear(Cnd.where("typeId", "in", ids));
        shopGoodsTypeTabService.clear(Cnd.where("typeId", "in", ids));
        this.delete(ids);
    }
}
