package cn.wizzer.modules.services.shop.goods;

import cn.wizzer.common.base.Service;
import cn.wizzer.modules.models.shop.Shop_member_lv;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
@IocBean(args = {"refer:dao"})
public class ShopMemberLvService extends Service<Shop_member_lv> {
	private static final Log log = Logs.get();

    public ShopMemberLvService(Dao dao) {
    	super(dao);
    }
}

