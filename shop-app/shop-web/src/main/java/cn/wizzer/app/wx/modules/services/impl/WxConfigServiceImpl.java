package cn.wizzer.app.wx.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.wx.modules.models.Wx_config;
import cn.wizzer.app.wx.modules.services.WxConfigService;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.weixin.at.impl.DaoAccessTokenStore;
import org.nutz.weixin.at.impl.RedisAccessTokenStore;
import org.nutz.weixin.impl.WxApi2Impl;
import org.nutz.weixin.spi.WxApi2;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

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

    public WxApi2 getWxApi2(String wxid) {
        Wx_config appInfo = this.fetch(Cnd.where("id", "=", wxid));
        RedisAccessTokenStore redisAccessTokenStore = new RedisAccessTokenStore();
        redisAccessTokenStore.setTokenKey("WxToken:" + wxid);
        redisAccessTokenStore.setJedisPool(jedisPool);
        WxApi2Impl wxApi2 = new WxApi2Impl();
        wxApi2.setAppid(appInfo.getAppid());
        wxApi2.setAppsecret(appInfo.getAppsecret());
        wxApi2.setEncodingAesKey(appInfo.getEncodingAESKey());
        wxApi2.setToken(appInfo.getToken());
        wxApi2.setAccessTokenStore(redisAccessTokenStore);
        return wxApi2;
    }

}
