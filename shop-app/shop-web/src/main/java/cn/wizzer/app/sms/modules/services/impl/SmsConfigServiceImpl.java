package cn.wizzer.app.sms.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.sms.modules.models.Sms_config;
import cn.wizzer.app.sms.modules.services.SmsConfigService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class SmsConfigServiceImpl extends BaseServiceImpl<Sms_config> implements SmsConfigService {
    public SmsConfigServiceImpl(Dao dao) {
        super(dao);
    }
}
