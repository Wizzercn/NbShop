package cn.wizzer.app.sms.commons.service;

import org.nutz.lang.util.NutMap;

/**
 * Created by wizzer on 2017/5/31.
 */
public interface SmsService {
    boolean send(String templateId, String mobile, NutMap map);
}
