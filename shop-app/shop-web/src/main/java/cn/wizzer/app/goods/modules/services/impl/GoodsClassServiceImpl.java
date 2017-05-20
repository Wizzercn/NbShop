package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_class;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.goods.modules.services.GoodsClassService;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;

@IocBean(args = {"refer:dao"})
public class GoodsClassServiceImpl extends BaseServiceImpl<Goods_class> implements GoodsClassService {
    public GoodsClassServiceImpl(Dao dao) {
        super(dao);
    }

    /**
     * 新增分类
     *
     * @param goodsClass
     * @param pid
     */
    @Aop(TransAop.READ_COMMITTED)
    public void save(Goods_class goodsClass, String pid) {
        String path = "";
        if (!Strings.isEmpty(pid)) {
            Goods_class pp = this.fetch(pid);
            path = pp.getPath();
        } else pid = "";
        goodsClass.setPath(getSubPath("goods_class", "path", path));
        goodsClass.setParentId(pid);
        dao().insert(goodsClass);
        if (!Strings.isEmpty(pid)) {
            this.update(Chain.make("hasChildren", true), Cnd.where("id", "=", pid));
        }
    }

    /**
     * 级联删除菜单
     *
     * @param goodsClass
     */
    @Aop(TransAop.READ_COMMITTED)
    public void deleteAndChild(Goods_class goodsClass) {
        dao().execute(Sqls.create("delete from shop_goods_class where path like @path").setParam("path", goodsClass.getPath() + "%"));
        if (!Strings.isEmpty(goodsClass.getParentId())) {
            int count = count(Cnd.where("parentId", "=", goodsClass.getParentId()));
            if (count < 1) {
                dao().execute(Sqls.create("update shop_goods_class set hasChildren=0 where id=@pid").setParam("pid", goodsClass.getParentId()));
            }
        }
    }
}
