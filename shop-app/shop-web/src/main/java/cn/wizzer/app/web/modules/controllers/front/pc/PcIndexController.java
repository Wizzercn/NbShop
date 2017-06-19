package cn.wizzer.app.web.modules.controllers.front.pc;

import cn.wizzer.app.member.modules.services.MemberUserService;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * Created by wizzer on 2017/6/14.
 */
@IocBean
@At("/")
public class PcIndexController {
    @Inject
    private MemberUserService memberUserService;
    @At(value={"/", "/index"}, top=true)
    @Ok("beetl:/public/pc/index/index.html")
    public void index() {
        memberUserService.getMember(Cnd.where("id","=","0e3599ae81284aba905114a10ef3dca5"));
    }
}
