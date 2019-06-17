package cn.wizzer.app.shop.modules.services.impl;

import cn.wizzer.app.shop.modules.models.Shop_area;
import cn.wizzer.app.shop.modules.services.ShopAreaService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.plugins.wkcache.annotation.CacheDefaults;
import org.nutz.plugins.wkcache.annotation.CacheRemoveAll;
import org.nutz.plugins.wkcache.annotation.CacheResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wizzer on 2019/6/14
 */
@IocBean(args = {"refer:dao"})
@CacheDefaults(cacheName = "shop_area")
public class ShopAreaServiceImpl extends BaseServiceImpl<Shop_area> implements ShopAreaService {
    public ShopAreaServiceImpl(Dao dao) {
        super(dao);
    }


    /**
     * 通过code获取name
     *
     * @param code
     * @return
     */
    @CacheResult
    public String getNameByCode(String code) {
        Shop_area shopArea = this.fetch(Cnd.where("code", "=", code));
        return shopArea == null ? "" : shopArea.getName();
    }

    /**
     * 通过id获取name
     *
     * @param id
     * @return
     */
    @CacheResult
    public String getNameById(String id) {
        Shop_area shopArea = this.fetch(id);
        return shopArea == null ? "" : shopArea.getName();
    }

    /**
     * 通过树path获取下级列表
     *
     * @param path
     * @return
     */
    @CacheResult
    public List<Shop_area> getSubListByPath(String path) {
        return this.query(Cnd.where("path", "like", Strings.sNull(path) + "____").asc("location"));
    }

    /**
     * 通过父id获取下级列表
     *
     * @param id
     * @return
     */
    @CacheResult
    public List<Shop_area> getSubListById(String id) {
        return this.query(Cnd.where("parentId", "=", Strings.sNull(id)).asc("location"));
    }

    /**
     * 通过code获取下级列表
     *
     * @param code
     * @return
     */
    @CacheResult
    public List<Shop_area> getSubListByCode(String code) {
        Shop_area shopArea = this.fetch(Cnd.where("code", "=", code));
        return shopArea == null ? new ArrayList<>() : this.query(Cnd.where("parentId", "=", Strings.sNull(shopArea.getId())).asc("location"));
    }

    /**
     * 通过path获取下级map
     *
     * @param path
     * @return
     */
    @CacheResult
    public Map getSubMapByPath(String path) {
        return this.getMap(Sqls.create("select code,name from shop_area where path like @path order by location asc").setParam("path", path + "____"));
    }

    /**
     * 通过id获取下级map
     *
     * @param id
     * @return
     */
    @CacheResult
    public Map getSubMapById(String id) {
        return this.getMap(Sqls.create("select code,name from shop_area where parentId = @id order by location asc").setParam("id", id));
    }

    /**
     * 通过code获取下级map
     *
     * @param code
     * @return
     */
    @CacheResult
    public Map getSubMapByCode(String code) {
        Shop_area shopArea = this.fetch(Cnd.where("code", "=", code));
        return shopArea == null ? new HashMap() : this.getMap(Sqls.create("select code,name from shop_area where parentId = @id order by location asc").setParam("id", shopArea.getId()));
    }

    /**
     * 新增字典
     *
     * @param shopArea
     * @param pid
     */
    @Aop(TransAop.READ_COMMITTED)
    public void save(Shop_area shopArea, String pid) {
        String path = "";
        if (!Strings.isEmpty(pid)) {
            Shop_area pp = this.fetch(pid);
            path = pp.getPath();
        }
        shopArea.setPath(getSubPath("shop_area", "path", path));
        shopArea.setParentId(pid);
        dao().insert(shopArea);
        if (!Strings.isEmpty(pid)) {
            this.update(Chain.make("hasChildren", true), Cnd.where("id", "=", pid));
        }
    }

    /**
     * 级联删除单位
     *
     * @param shopArea
     */
    @Aop(TransAop.READ_COMMITTED)
    public void deleteAndChild(Shop_area shopArea) {
        dao().execute(Sqls.create("delete from shop_area where path like @path").setParam("path", shopArea.getPath() + "%"));
        if (!Strings.isEmpty(shopArea.getParentId())) {
            int count = count(Cnd.where("parentId", "=", shopArea.getParentId()));
            if (count < 1) {
                dao().execute(Sqls.create("update shop_area set hasChildren=0 where id=@pid").setParam("pid", shopArea.getParentId()));
            }
        }
    }

    @CacheRemoveAll
    public void clearCache() {

    }
}
