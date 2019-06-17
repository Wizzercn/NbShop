package cn.wizzer.app.shop.modules.services;

import cn.wizzer.app.shop.modules.models.Shop_area;
import cn.wizzer.framework.base.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * Created by wizzer on 2019/6/14
 */
public interface ShopAreaService extends BaseService<Shop_area> {
    /**
     * 通过code获取名称
     *
     * @param code
     * @return
     */
    String getNameByCode(String code);

    /**
     * 通过ID获取名称
     *
     * @param id
     * @return
     */
    String getNameById(String id);

    /**
     * 通过树PATH获取子级
     *
     * @param path
     * @return
     */
    List<Shop_area> getSubListByPath(String path);

    /**
     * 通过ID获取子级
     *
     * @param id
     * @return
     */
    List<Shop_area> getSubListById(String id);

    /**
     * 通过code获取子级
     *
     * @param code
     * @return
     */
    List<Shop_area> getSubListByCode(String code);

    /**
     * 通过树PATH获取子级
     *
     * @param path
     * @return
     */
    Map getSubMapByPath(String path);

    /**
     * 通过ID获取子级
     *
     * @param id
     * @return
     */
    Map getSubMapById(String id);

    /**
     * 通过code获取子级
     *
     * @param code
     * @return
     */
    Map getSubMapByCode(String code);

    /**
     * 保存数据字典
     *
     * @param shopArea
     * @param pid
     */
    void save(Shop_area shopArea, String pid);

    /**
     * 级联删除数据
     *
     * @param shopArea
     */
    void deleteAndChild(Shop_area shopArea);

    /**
     * 清空缓存
     */
    void clearCache();
}
