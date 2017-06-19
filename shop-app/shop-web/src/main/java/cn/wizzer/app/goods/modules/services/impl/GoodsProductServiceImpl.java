package cn.wizzer.app.goods.modules.services.impl;

import cn.wizzer.app.goods.modules.models.Goods_lv_price;
import cn.wizzer.app.goods.modules.services.GoodsLvPriceService;
import cn.wizzer.app.member.modules.models.Member_level;
import cn.wizzer.app.member.modules.models.Member_user;
import cn.wizzer.app.member.modules.services.MemberLevelService;
import cn.wizzer.app.member.modules.services.MemberUserService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.goods.modules.models.Goods_product;
import cn.wizzer.app.goods.modules.services.GoodsProductService;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.random.R;
import org.nutz.lang.util.NutMap;
import org.nutz.plugins.wkcache.annotation.CacheDefaults;
import org.nutz.plugins.wkcache.annotation.CacheRemove;
import org.nutz.plugins.wkcache.annotation.CacheRemoveAll;
import org.nutz.plugins.wkcache.annotation.CacheResult;

@IocBean(args = {"refer:dao"})
@CacheDefaults(cacheName = "goods_product")
public class GoodsProductServiceImpl extends BaseServiceImpl<Goods_product> implements GoodsProductService {
    public GoodsProductServiceImpl(Dao dao) {
        super(dao);
    }

    @Inject
    private MemberUserService memberUserService;
    @Inject
    private MemberLevelService memberLevelService;
    @Inject
    private GoodsLvPriceService goodsLvPriceService;

    /**
     * 加个注释吧，这个是获取货号前缀的
     *
     * @return
     */
    public String getSkuPrefix() {
        String uuid = "S" + R.UU32().substring(1, 12).toUpperCase();
        if (dao().meta().isMySql()) {
            if (null != this.fetch(Cnd.where("SUBSTRING(sku,1,12)", "=", uuid))) {
                return getSkuPrefix();
            }
        }
        if (dao().meta().isOracle()) {
            if (null != this.fetch(Cnd.where("SUBSTR(sku,1,12)", "=", uuid))) {
                return getSkuPrefix();
            }
        }
        return uuid;
    }

    @CacheResult(cacheKey = "${args[0]}_${args[1]}_${args[2]}")
    public NutMap getPrice(String goodsId, String productId, String memberId) {
        NutMap map = NutMap.NEW();
        Goods_product product = this.fetch(Cnd.where("id", "=", productId));
        int price = product.getPrice();
        int priceMarket = product.getPriceMarket();
        Member_user memberUser = memberUserService.getMember(Cnd.where("id", "=", memberId));
        if (memberUser != null) {
            Goods_lv_price goodsLvPrice = goodsLvPriceService.getLvPrice(Cnd.where("goodsId", "=", goodsId).and("productId", "=", productId).and("lvId", "=", memberUser.getLevelId()));
            if (goodsLvPrice != null) {//查找会员等级商品价格
                price = goodsLvPrice.getLvPrice();
            } else {//如果没有找到单独价格,那么到会员等级表找打折比例
                Member_level memberLevel = memberLevelService.getLevel(Cnd.where("id", "=", memberUser.getLevelId()));
                if (memberLevel != null) {
                    //todo
                }
            }
        }
        return map.addv("price", price).addv("priceMarket", priceMarket);
    }

    @CacheRemove(cacheKey = "${args[0]}_*")
    public void deleteCache(String goodsId) {

    }

    @CacheRemoveAll
    public void clearCache() {

    }
}
