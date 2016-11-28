package cn.wizzer.common.services.pubsub;

/**
 * 发布订阅服务
 * Created by wizzer on 2016/11/28.
 */
public interface PubSub {
    void onMessage(String channel, String message);
}
