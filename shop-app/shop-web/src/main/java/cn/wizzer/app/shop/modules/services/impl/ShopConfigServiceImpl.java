package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.services.ShopConfigService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_config;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;

import java.util.Set;

import static org.nutz.integration.jedis.RedisInterceptor.jedis;

@IocBean(args = {"refer:dao"})
public class ShopConfigServiceImpl extends BaseServiceImpl<Shop_config> implements ShopConfigService {
    public ShopConfigServiceImpl(Dao dao) {
        super(dao);
    }

    @Aop("redis")
    public Shop_config getConfig() {
        byte[] bt = jedis().get(("data:shop_config").getBytes());
        if (bt != null) {
            return Lang.fromBytes(bt, Shop_config.class);
        } else {
            Shop_config api = this.fetch("system");
            if (api != null) {
                this.fetchLinks(api, null);
                jedis().set(("data:shop_config").getBytes(), Lang.toBytes(api));
                return api;
            }
            return null;
        }
    }

    @Aop("redis")
    public void clearCache() {
        Set<String> set = jedis().keys("data:shop_config");
        for (String it : set) {
            jedis().del(it.getBytes());
        }
    }
}
