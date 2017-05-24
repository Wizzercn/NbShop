package cn.wizzer.app.shop.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.shop.modules.models.Shop_shipping;

public interface ShopShippingService extends BaseService<Shop_shipping> {
    void add(Shop_shipping shopShipping, String flatprice_s, String lv1_price_s, String lv2_price_s);

    void edit(Shop_shipping shopShipping, String flatprice_s, String lv1_price_s, String lv2_price_s);
}
