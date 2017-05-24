package cn.wizzer.app.web.commons.utils;

import org.nutz.ioc.loader.annotation.IocBean;

import java.math.BigDecimal;

/**
 * Created by wizzer on 2017/3/31.
 */
@IocBean
public class MoneyUtil {
    /**
     * 分转换为元
     *
     * @param fen 分
     * @return 元
     */
    public static String fenToYuan(int fen) {
        try {
            return new BigDecimal(fen).divide(new BigDecimal(100)).setScale(2).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0.00";
    }

    /**
     * 元转换为分
     *
     * @param yuan 元
     * @return 分
     */
    public static int yuanToFen(String yuan) {
        try {
            return BigDecimal.valueOf(Double.valueOf(yuan)).multiply(new BigDecimal(100)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
