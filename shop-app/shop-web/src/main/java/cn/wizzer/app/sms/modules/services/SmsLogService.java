package cn.wizzer.app.sms.modules.services;

import cn.wizzer.framework.base.service.BaseService;
import cn.wizzer.app.sms.modules.models.Sms_log;

public interface SmsLogService extends BaseService<Sms_log>{
    void add(Sms_log log);
}
