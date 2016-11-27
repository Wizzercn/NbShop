package cn.wizzer.modules.services.dec;

import cn.wizzer.common.base.Service;
import cn.wizzer.modules.models.dec.Dec_component_class;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
@IocBean(args = {"refer:dao"})
public class DecComponentClassService extends Service<Dec_component_class> {
	private static final Log log = Logs.get();

    public DecComponentClassService(Dao dao) {
    	super(dao);
    }
}

