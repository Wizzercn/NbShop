package cn.wizzer.app.web.commons.ext.qiniu;

import cn.wizzer.app.shop.modules.models.Shop_config;
import cn.wizzer.app.shop.modules.services.ShopConfigService;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.io.File;

/**
 * Created by wizzer on 2017/6/5.
 */
@IocBean
public class QiniuService {
    private final static Log log = Logs.get();
    @Inject
    private ShopConfigService shopConfigService;

    public NutMap upload(File file, String key) {
        NutMap result = NutMap.NEW();
        try {
            Shop_config shopConfig = shopConfigService.getConfig();
            NutMap config = Json.fromJson(NutMap.class, Strings.sNull(shopConfig.getImg_qiniu_info()));
            String accessKey = config.getString("qiniu_ak", "");
            String secretKey = config.getString("qiniu_sk", "");
            String bucket = config.getString("qiniu_bucket", "");
            String domain = config.getString("qiniu_domain", "");
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket, key);
            Configuration cfg = new Configuration(Zone.zone0());
            UploadManager uploadManager = new UploadManager(cfg);
            try {
                Response response = uploadManager.put(file, key, upToken);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                result.addv("key",key);
            } catch (QiniuException ex) {
                Response r = ex.response;
                log.error("qiniu:::" + r.toString());
                try {
                    log.error("qiniu:::" + r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
            result.addv("domain", domain);
            result.addv("code", 0);
            result.addv("msg", "");
            return result;
        } catch (Exception e) {
            log.error(e);
        }
        return result.addv("code", 1).addv("msg", "");
    }
}
