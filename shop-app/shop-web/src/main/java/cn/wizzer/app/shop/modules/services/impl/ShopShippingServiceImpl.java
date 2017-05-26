package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.web.commons.utils.MoneyUtil;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_shipping;
import cn.wizzer.app.shop.modules.services.ShopShippingService;
import cn.wizzer.framework.util.StringUtil;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.lang.random.R;

@IocBean(args = {"refer:dao"})
public class ShopShippingServiceImpl extends BaseServiceImpl<Shop_shipping> implements ShopShippingService {
    public ShopShippingServiceImpl(Dao dao) {
        super(dao);
    }

    @Aop(TransAop.READ_COMMITTED)
    public void add(Shop_shipping shopShipping, String flatprice_s, String lv1_price_s, String lv2_price_s) {
        if ("flatprice".equals(shopShipping.getMethod())) {
            shopShipping.setFlatprice(MoneyUtil.yuanToFen(Strings.sNull(flatprice_s)));
        }
        if ("weight".equals(shopShipping.getMethod()) || "number".equals(shopShipping.getMethod())) {
            shopShipping.setLv1_price(MoneyUtil.yuanToFen(Strings.sNull(lv1_price_s)));
            shopShipping.setLv2_price(MoneyUtil.yuanToFen(Strings.sNull(lv2_price_s)));
        }
        if (shopShipping.isDefaultValue()) {
            this.update(Chain.make("defaultValue", false), Cnd.NEW());
        }
        this.insert(shopShipping);
    }

    @Aop(TransAop.READ_COMMITTED)
    public void edit(Shop_shipping shopShipping, String flatprice_s, String lv1_price_s, String lv2_price_s) {
        if ("flatprice".equals(shopShipping.getMethod())) {
            shopShipping.setFlatprice(MoneyUtil.yuanToFen(Strings.sNull(flatprice_s)));
        }
        if ("weight".equals(shopShipping.getMethod()) || "number".equals(shopShipping.getMethod())) {
            shopShipping.setLv1_price(MoneyUtil.yuanToFen(Strings.sNull(lv1_price_s)));
            shopShipping.setLv2_price(MoneyUtil.yuanToFen(Strings.sNull(lv2_price_s)));
        }
        shopShipping.setOpBy(StringUtil.getUid());
        shopShipping.setOpAt((int) (System.currentTimeMillis() / 1000));
        if (shopShipping.isDefaultValue()) {
            this.update(Chain.make("defaultValue", false), Cnd.NEW());
        }
        this.updateIgnoreNull(shopShipping);
    }

    @Aop(TransAop.READ_COMMITTED)
    public void setDefault(String id) {
        this.update(Chain.make("defaultValue", false), Cnd.NEW());
        this.update(Chain.make("defaultValue", true), Cnd.where("id", "=", id));
    }
}
