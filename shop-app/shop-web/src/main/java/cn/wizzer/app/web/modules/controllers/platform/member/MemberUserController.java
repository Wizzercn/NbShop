package cn.wizzer.app.web.modules.controllers.platform.member;

import cn.wizzer.app.member.modules.services.MemberUserMoneyService;
import cn.wizzer.app.member.modules.services.MemberUserScoreService;
import cn.wizzer.app.sales.modules.services.SalesCouponService;
import cn.wizzer.app.shop.modules.services.ShopAreaService;
import cn.wizzer.app.web.commons.utils.MoneyUtil;
import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.member.modules.models.Member_user;
import cn.wizzer.app.member.modules.services.MemberUserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.dao.util.cri.Static;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/member/user")
public class MemberUserController {
    private static final Log log = Logs.get();
    @Inject
    private MemberUserService memberUserService;
    @Inject
    private ShopAreaService shopAreaService;
    @Inject
    private MemberUserMoneyService memberUserMoneyService;
    @Inject
    private MemberUserScoreService memberUserScoreService;
    @Inject
    private SalesCouponService salesCouponService;

    @At("")
    @Ok("beetl:/platform/member/user/index.html")
    @RequiresPermissions("member.manager.user")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("member.manager.user")
    public Object data(@Param("keyword") String keyword, @Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        if (Strings.isNotBlank(keyword)) {
            if (Strings.isMobile(keyword)) {
                cnd.and("mobile", "like", "%" + keyword + "%");
            } else {
                cnd.and("loginname", "like", "%" + keyword + "%");
            }
        }
        return memberUserService.data(length, start, draw, order, columns, cnd, "^(memberType|memberLevel)$");
    }

    @At("/add")
    @Ok("beetl:/platform/member/user/add.html")
    @RequiresPermissions("member.manager.user")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("member.manager.user.add")
    @SLog(tag = "Member_user", msg = "${args[0].id}")
    public Object addDo(@Param("..") Member_user memberUser, HttpServletRequest req) {
        try {
            memberUserService.insert(memberUser);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/edit/?")
    @Ok("beetl:/platform/member/user/edit.html")
    @RequiresPermissions("member.manager.user")
    public void edit(String id, HttpServletRequest req) {
        req.setAttribute("obj", memberUserService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("member.manager.user.edit")
    @SLog(tag = "Member_user", msg = "${args[0].id}")
    public Object editDo(@Param("..") Member_user memberUser, HttpServletRequest req) {
        try {
            memberUser.setOpBy(StringUtil.getUid());
            memberUser.setOpAt((int) (System.currentTimeMillis() / 1000));
            memberUserService.updateIgnoreNull(memberUser);
            memberUserService.clearCache();
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("member.manager.user.delete")
    @SLog(tag = "Member_user", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids, HttpServletRequest req) {
        try {
            if (ids != null && ids.length > 0) {
                memberUserService.delete(ids);
                req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
            } else {
                memberUserService.delete(id);
                req.setAttribute("id", id);
            }
            memberUserService.clearCache();
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/member/user/detail.html")
    @RequiresPermissions("member.manager.user")
    public void detail(String id, HttpServletRequest req) {
        if (!Strings.isBlank(id)) {
            Member_user memberUser = memberUserService.fetch(id);
            req.setAttribute("province", shopAreaService.getNameByCode(memberUser.getProvinceId()));
            req.setAttribute("city", shopAreaService.getNameByCode(memberUser.getCityId()));
            req.setAttribute("obj", memberUserService.fetchLinks(memberUser, null));
        } else {
            req.setAttribute("obj", null);
        }
    }

    @At("/enable/?")
    @Ok("json")
    @RequiresPermissions("shop.logistics.express")
    public Object enable(String id, HttpServletRequest req) {
        try {
            memberUserService.update(org.nutz.dao.Chain.make("disabled", false), Cnd.where("id", "=", id));
            memberUserService.clearCache();
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/disable/?")
    @Ok("json")
    @RequiresPermissions("shop.logistics.express")
    public Object disable(String id, HttpServletRequest req) {
        try {
            memberUserService.update(org.nutz.dao.Chain.make("disabled", true), Cnd.where("id", "=", id));
            memberUserService.clearCache();
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/money/?")
    @Ok("beetl:/platform/member/user/money.html")
    @RequiresPermissions("member.manager.user.edit")
    public Object money(String id, HttpServletRequest req) {
        return memberUserService.fetch(id);
    }

    @At("/moneyDo")
    @Ok("json")
    @RequiresPermissions("member.manager.user.edit")
    public Object moneyDo(@Param("id") String id, @Param("money") String money, @Param("txt") String txt, HttpServletRequest req) {
        try {
            memberUserService.money(id, MoneyUtil.yuanToFen(money), txt);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }


    @At("/moneylog/?")
    @Ok("beetl:/platform/member/user/moneylog.html")
    @RequiresPermissions("member.manager.user")
    public void moneylog(String id, HttpServletRequest req) {
        req.setAttribute("obj", memberUserService.fetch(id));
        req.setAttribute("id", id);
    }

    @At("/moneydata/?")
    @Ok("json:full")
    @RequiresPermissions("member.manager.user")
    public Object moneydata(String memberId, @Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        if (Strings.isNotBlank(memberId)) {
            cnd.and("memberId", "=", memberId);
        }
        return memberUserMoneyService.data(length, start, draw, order, columns, cnd, "sysUser");
    }

    @At("/score/?")
    @Ok("beetl:/platform/member/user/score.html")
    @RequiresPermissions("member.manager.user.edit")
    public Object score(String id, HttpServletRequest req) {
        return memberUserService.fetch(id);
    }

    @At("/scoreDo")
    @Ok("json")
    @RequiresPermissions("member.manager.user.edit")
    public Object scoreDo(@Param("id") String id, @Param("score") int score, @Param("txt") String txt, HttpServletRequest req) {
        try {
            memberUserService.score(id, score, txt);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/scorelog/?")
    @Ok("beetl:/platform/member/user/scorelog.html")
    @RequiresPermissions("member.manager.user")
    public void scorelog(String id, HttpServletRequest req) {
        req.setAttribute("obj", memberUserService.fetch(id));
        req.setAttribute("id", id);
    }

    @At("/scoredata/?")
    @Ok("json:full")
    @RequiresPermissions("member.manager.user")
    public Object scoredata(String memberId, @Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        if (Strings.isNotBlank(memberId)) {
            cnd.and("memberId", "=", memberId);
        }
        return memberUserScoreService.data(length, start, draw, order, columns, cnd, "sysUser");
    }

    @At("/coupon/?")
    @Ok("beetl:/platform/member/user/coupon.html")
    @RequiresPermissions("member.manager.user.edit")
    public Object coupon(String id, HttpServletRequest req) {
        req.setAttribute("list",salesCouponService.query(Cnd.where("disabled","=",false).and(new Static("total_num>send_num"))));
        return memberUserService.fetch(id);
    }

    @At("/couponDo")
    @Ok("json")
    @RequiresPermissions("member.manager.user.edit")
    public Object couponDo(@Param("id") String id, @Param("couponId") String couponId, @Param("txt") String txt, HttpServletRequest req) {
        try {
            memberUserService.coupon(id, couponId, txt);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }
}
