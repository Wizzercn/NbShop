package cn.wizzer.app.wx.modules.services.impl;

import cn.wizzer.app.web.commons.base.Globals;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.wx.modules.models.Wx_config;
import cn.wizzer.app.wx.modules.services.WxConfigService;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.weixin.at.impl.RedisAccessTokenStore;
import org.nutz.weixin.impl.WxApi2Impl;
import org.nutz.weixin.spi.WxApi2;
import redis.clients.jedis.JedisPool;

import java.util.Set;

import static org.nutz.integration.jedis.RedisInterceptor.jedis;

/**
 * 如果是集群部署请使用RedisAccessTokenStore
 */
@IocBean(args = {"refer:dao"})
public class WxConfigServiceImpl extends BaseServiceImpl<Wx_config> implements WxConfigService {
    @Inject
    private JedisPool jedisPool;

    public WxConfigServiceImpl(Dao dao) {
        super(dao);
    }

    @Aop("redis")
    public void clearCache() {
        Set<String> set = jedis().keys("data:wx_api_*");
        for (String it : set) {
            jedis().del(it.getBytes());
        }
    }

    @Aop("redis")
    public synchronized WxApi2 getWxApi2(String wxid) {
        WxApi2Impl wxApi2;
        byte[] bt = jedis().get(("data:wx_api_impl_" + wxid).getBytes());
        if (bt != null) {
            wxApi2 = Lang.fromBytes(bt, WxApi2Impl.class);
        } else {
            Wx_config appInfo = this.fetch(Cnd.where("id", "=", wxid));
            RedisAccessTokenStore redisAccessTokenStore = new RedisAccessTokenStore();
            redisAccessTokenStore.setTokenKey("data:wx_api_token_" + wxid);
            redisAccessTokenStore.setJedisPool(jedisPool);
            wxApi2 = new WxApi2Impl();
            wxApi2.setAppid(appInfo.getAppid());
            wxApi2.setAppsecret(appInfo.getAppsecret());
            wxApi2.setEncodingAesKey(appInfo.getEncodingAESKey());
            wxApi2.setToken(appInfo.getToken());
            wxApi2.setAccessTokenStore(redisAccessTokenStore);
            jedis().set(("data:wx_api_impl_" + wxid).getBytes(), Lang.toBytes(wxApi2));
        }
        return wxApi2;
    }

}
