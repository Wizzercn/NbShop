package cn.wizzer.modules.services.dec;

import cn.wizzer.common.base.Service;
import cn.wizzer.modules.models.dec.Dec_page;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
@IocBean(args = {"refer:dao"})
public class DecPageService extends Service<Dec_page> {
	private static final Log log = Logs.get();

    public DecPageService(Dao dao) {
    	super(dao);
    }
}

