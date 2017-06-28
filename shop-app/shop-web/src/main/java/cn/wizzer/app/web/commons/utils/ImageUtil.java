package cn.wizzer.app.web.commons.utils;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;

/**
 * Created by wizzer on 2017/6/28.
 */
@IocBean
public class ImageUtil {
    public static String s(String url) {
        if (Strings.isNotBlank(url) && url.contains(".")) {
            url = url.replace("_s", "");
            return url.substring(0, url.lastIndexOf(".")) + "_s" + url.substring(url.lastIndexOf("."));
        }
        return "";
    }

    public static String m(String url) {
        if (Strings.isNotBlank(url) && url.contains(".")) {
            url = url.replace("_s", "");
            return url.substring(0, url.lastIndexOf(".")) + "_m" + url.substring(url.lastIndexOf("."));
        }
        return "";
    }

    public static String b(String url) {
        if (Strings.isNotBlank(url) && url.contains(".")) {
            url = url.replace("_s", "");
            return url.substring(0, url.lastIndexOf(".")) + "_b" + url.substring(url.lastIndexOf("."));
        }
        return "";
    }
}
