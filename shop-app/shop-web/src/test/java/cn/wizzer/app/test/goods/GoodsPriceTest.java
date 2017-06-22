package cn.wizzer.app.test.goods;

import cn.wizzer.app.test.base.TestBase;
import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wizzer on 2017/6/20.
 */
public class GoodsPriceTest extends TestBase {
    private final static Log log= Logs.get();
    @Test
    public void getPrice(){
        int price=1203;
        int lv=98;
        log.debug("price:::"+(price*lv)/100);
        price=12;
        lv=93;
        int m=(price*lv)/100;
        log.debug("price:::"+m);
        price=1;
        lv=93;
        m=(price*lv)/100;
        log.debug("price:::"+m);
    }

    @Test
    public void t1(){
        Map map=new HashMap<>();map.put(null,1);map.clear();map.get(null);
        log.debug("xxxxxxxxx:::"+ map.get(null));

    }
}
