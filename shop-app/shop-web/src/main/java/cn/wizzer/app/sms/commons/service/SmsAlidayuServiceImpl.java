package cn.wizzer.app.sms.commons.service;

import cn.wizzer.app.sms.modules.models.Sms_config;
import cn.wizzer.app.sms.modules.models.Sms_log;
import cn.wizzer.app.sms.modules.services.SmsConfigService;
import cn.wizzer.app.sms.modules.services.SmsLogService;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * Created by wizzer on 2017/5/31.
 */
@IocBean
public class SmsAlidayuServiceImpl implements SmsService {
    private final static Log log = Logs.get();
    @Inject
    private SmsConfigService smsConfigService;
    @Inject
    private SmsLogService smsLogService;

    public boolean send(String templateId, String mobile, NutMap map) {
        try {
            Sms_config conf = smsConfigService.fetch("alidayu");
            String appkey = Strings.sNull(conf.getApp_key());
            String secret = Strings.sNull(conf.getApp_secret());
            String signname = Strings.sNull(conf.getSms_sign_name(), "阿里大于");
            String url = "http://gw.api.taobao.com/router/rest";
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
            req.setSmsType("normal");//短信类型，传入值请填写normal
            req.setSmsFreeSignName(signname);
            req.setSmsParamString(Json.toJson(map));
            req.setRecNum(mobile);
            req.setSmsTemplateCode(templateId);
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
            if (rsp.isSuccess()) {
                Sms_log smsLog = new Sms_log();
                smsLog.setCode(templateId);
                smsLog.setMobile(mobile);
                smsLog.setNote(Json.toJson(map));
                smsLogService.add(smsLog);
                return true;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return false;
    }
}
