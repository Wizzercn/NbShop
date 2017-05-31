package cn.wizzer.app.sms.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.sms.modules.models.Sms_log;
import cn.wizzer.app.sms.modules.services.SmsLogService;
import org.nutz.aop.interceptor.async.Async;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class SmsLogServiceImpl extends BaseServiceImpl<Sms_log> implements SmsLogService {
    public SmsLogServiceImpl(Dao dao) {
        super(dao);
    }

    @Async
    public void add(Sms_log log){
        this.insert(log);
    }
}
