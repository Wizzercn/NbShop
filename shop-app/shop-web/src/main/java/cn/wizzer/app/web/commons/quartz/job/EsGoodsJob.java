package cn.wizzer.app.web.commons.quartz.job;

import cn.wizzer.app.goods.modules.models.Goods_goods;
import cn.wizzer.app.goods.modules.services.GoodsGoodsService;
import cn.wizzer.app.shop.modules.models.Shop_estemp;
import cn.wizzer.app.shop.modules.services.ShopEstempService;
import cn.wizzer.app.sys.modules.models.Sys_task;
import cn.wizzer.app.sys.modules.services.SysTaskService;
import cn.wizzer.app.web.commons.es.EsService;
import cn.wizzer.framework.page.Pagination;
import org.apache.commons.lang3.math.NumberUtils;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wizzer.cn on 2015/6/27.
 */
@IocBean
public class EsGoodsJob implements Job {

    private static final Log log = Logs.get();
    @Inject
    protected GoodsGoodsService goodsGoodsService;
    @Inject
    protected SysTaskService sysTaskService;
    @Inject
    protected EsService esService;
    @Inject
    protected ShopEstempService shopEstempService;
    @Inject
    private PropertiesProxy cfg;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data = context.getJobDetail().getJobDataMap();
        String taskId = context.getJobDetail().getKey().getName();
        try {
            int pageSize = data.getInt("pageSize");
            log.info("EsGoodsJob Job pageSize::" + pageSize);
            Pager pager = new Pager();
            pager.setPageNumber(1);
            pager.setPageSize(pageSize);
            List<Shop_estemp> list = shopEstempService.query(Cnd.orderBy().asc("opAt"), "goods", pager);
            if (list.size() > 0) {
                for (Shop_estemp estemp : list) {
                    Goods_goods goods = estemp.getGoods();
                    goodsGoodsService.fetchLinks(goods, null, Cnd.orderBy().asc("location"));
                    if ("delete".equals(estemp.getAction())) {
                        if (esService.deleteData(cfg.get("es.index.name","nutzshop"), "goods", goods.getId())) {
                            shopEstempService.delete(estemp.getId());
                        }
                    } else {
                        if (esService.createOrUpdateData(cfg.get("es.index.name","nutzshop"), "goods", goods.getId(), goods)) {
                            shopEstempService.delete(estemp.getId());
                        }
                    }
                }
            }
            sysTaskService.update(Chain.make("exeAt", (int) (System.currentTimeMillis() / 1000)).add("exeResult", "执行成功"), Cnd.where("id", "=", taskId));
        } catch (Exception e) {
            log.error(e);
            sysTaskService.update(Chain.make("exeAt", (int) (System.currentTimeMillis() / 1000)).add("exeResult", "执行失败"), Cnd.where("id", "=", taskId));
        }
    }
}
