package cn.wizzer.app.web.modules.controllers.open.file;

import cn.wizzer.app.shop.modules.models.Shop_config;
import cn.wizzer.app.shop.modules.services.ShopConfigService;
import cn.wizzer.app.web.commons.base.Globals;
import cn.wizzer.app.web.commons.ext.qiniu.QiniuService;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.util.DateUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.img.Images;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Files;
import org.nutz.lang.random.R;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.impl.AdaptorErrorContext;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.util.Date;

/**
 * Created by Wizzer on 2016/7/5.
 */
@IocBean
@At("/open/file/upload")
public class UploadController {
    private static final Log log = Logs.get();
    @Inject
    private ShopConfigService shopConfigService;
    @Inject
    private QiniuService qiniuService;

    @AdaptBy(type = UploadAdaptor.class, args = {"ioc:imageUpload"})
    @POST
    @At
    @Ok("json")
    @RequiresAuthentication
    //AdaptorErrorContext必须是最后一个参数
    public Object image(@Param("Filedata") TempFile tf, HttpServletRequest req, AdaptorErrorContext err) {
        try {
            if (err != null && err.getAdaptorErr() != null) {
                return NutMap.NEW().addv("code", 1).addv("msg", "文件不合法");
            } else if (tf == null) {
                return Result.error("空文件");
            } else {

                String p = Globals.AppRoot;
                String f = Globals.AppUploadPath + "/image/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + R.UU32() + tf.getSubmittedFileName().substring(tf.getSubmittedFileName().indexOf("."));
                Files.write(new File(p + f), tf.getInputStream());
                return Result.success("上传成功", Globals.AppBase + f);
            }
        } catch (Exception e) {
            return Result.error("系统错误");
        } catch (Throwable e) {
            return Result.error("图片格式错误");
        }
    }

    @AdaptBy(type = UploadAdaptor.class, args = {"ioc:imageUpload"})
    @POST
    @At
    @Ok("json")
    @RequiresAuthentication
    //AdaptorErrorContext必须是最后一个参数
    public Object dbimage(@Param("Filedata") TempFile tf, HttpServletRequest req, AdaptorErrorContext err) {
        try {
            if (err != null && err.getAdaptorErr() != null) {
                return NutMap.NEW().addv("code", 1).addv("msg", "文件不合法");
            } else if (tf == null) {
                return Result.error("空文件");
            } else {
                Shop_config shopConfig = shopConfigService.getConfig();
                if (shopConfig.isImg_save_local()) {
                    String p = Globals.AppRoot;
                    String suffix = tf.getSubmittedFileName().substring(tf.getSubmittedFileName().indexOf("."));
                    String f = Globals.AppUploadPath + "/image/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + R.UU32();
                    Files.write(new File(p + f + suffix), tf.getInputStream());
                    Images.zoomScale(p + f + suffix, p + f + "_s" + suffix, shopConfig.getS_width(), shopConfig.getS_height(), Color.GRAY);
                    Images.zoomScale(p + f + suffix, p + f + "_m" + suffix, shopConfig.getM_width(), shopConfig.getM_height(), Color.GRAY);
                    return Result.success("上传成功", Globals.AppBase + f + "_s" + suffix);

                } else {
                    if (shopConfig.isImg_qiniu()) {
                        String p = Globals.AppRoot;
                        String suffix = tf.getSubmittedFileName().substring(tf.getSubmittedFileName().indexOf("."));
                        String f = Globals.AppUploadPath + "/image/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + R.UU32();
                        Files.write(new File(p + f + suffix), tf.getInputStream());
                        Images.zoomScale(p + f + suffix, p + f + "_s" + suffix, shopConfig.getS_width(), shopConfig.getS_height(), Color.GRAY);
                        Images.zoomScale(p + f + suffix, p + f + "_m" + suffix, shopConfig.getM_width(), shopConfig.getM_height(), Color.GRAY);
                        NutMap map = qiniuService.upload(tf.getFile(), f + suffix);
                        qiniuService.upload(new File(p + f + "_s" + suffix), f + "_s" + suffix);
                        qiniuService.upload(new File(p + f + "_m" + suffix), f + "_m" + suffix);
                        return Result.success("上传成功", map.getString("domain", Globals.AppBase) + f + "_s" + suffix);
                    }
                    return Result.error("未配置云存储信息");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("系统错误");
        } catch (Throwable e) {
            return Result.error("图片格式错误");
        }
    }
}
