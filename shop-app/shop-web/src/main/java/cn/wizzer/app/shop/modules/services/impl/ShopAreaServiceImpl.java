package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.shop.modules.models.Shop_area;
import cn.wizzer.app.shop.modules.services.ShopAreaService;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;

@IocBean(args = {"refer:dao"})
public class ShopAreaServiceImpl extends BaseServiceImpl<Shop_area> implements ShopAreaService {
    public ShopAreaServiceImpl(Dao dao) {
        super(dao);
    }

    @Aop(TransAop.READ_COMMITTED)
    public void save(Shop_area shoparea, String pid) {
        String path = "";
        if (!Strings.isEmpty(pid)) {
            Shop_area pp = this.fetch(pid);
            path = pp.getPath();
        }
        shoparea.setPath(getSubPath("shop_area", "path", path));
        shoparea.setParentId(pid);
        dao().insert(shoparea);
        if (!Strings.isEmpty(pid)) {
            this.update(Chain.make("hasChildren", true), Cnd.where("id", "=", pid));
        }
    }

    @Aop(TransAop.READ_COMMITTED)
    public void deleteAndChild(Shop_area shoparea) {
        dao().execute(Sqls.create("delete from shop_area where path like @path").setParam("path", shoparea.getPath() + "%"));
        if (!Strings.isEmpty(shoparea.getParentId())) {
            int count = count(Cnd.where("parentId", "=", shoparea.getParentId()));
            if (count < 1) {
                dao().execute(Sqls.create("update shop_area set hasChildren=@f where id=@pid").setParam("f", false).setParam("pid", shoparea.getParentId()));
            }
        }
    }

    public String getNameByCode(String code) {
        Shop_area shopArea = this.fetch(Cnd.where("code", "=", code));
        if (shopArea != null)
            return shopArea.getName();
        return "";
    }
}
