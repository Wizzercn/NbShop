package cn.wizzer.common.services.pubsub;

import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

import static cn.wizzer.common.services.redis.RedisInterceptor.jedis;

/**
 * 发布订阅服务
 * Created by wizzer on 2016/11/28.
 */
@IocBean(depose = "depose")
public class PubSubService {
    private static final Log log = Logs.get();

    @Inject
    protected JedisPool jedisPool;

    List<PubSubProxy> list = new ArrayList<>();

    public void reg(String patten, PubSub pb) {
        PubSubProxy proxy = new PubSubProxy(patten, pb);
        list.add(proxy);
        new Thread(() -> jedisPool.getResource().psubscribe(proxy, patten)).start();
    }

    @Aop("redis")
    public void fire(String channel, String message) {
        log.debugf("publish channel=%s msg=%s", channel, message);
        jedis().publish(channel, message);
    }

    public void depose() {
        for (PubSubProxy proxy : list)
            proxy.punsubscribe(proxy.patten);
    }
}
