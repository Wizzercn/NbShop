package cn.wizzer.app.member.modules.services.impl;

import cn.wizzer.app.member.modules.models.Member_user_money;
import cn.wizzer.app.member.modules.models.Member_user_score;
import cn.wizzer.app.member.modules.services.MemberUserMoneyService;
import cn.wizzer.app.member.modules.services.MemberUserScoreService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.member.modules.models.Member_user;
import cn.wizzer.app.member.modules.services.MemberUserService;
import cn.wizzer.framework.util.StringUtil;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class MemberUserServiceImpl extends BaseServiceImpl<Member_user> implements MemberUserService {
    public MemberUserServiceImpl(Dao dao) {
        super(dao);
    }

    @Inject
    private MemberUserMoneyService memberUserMoneyService;
    @Inject
    private MemberUserScoreService memberUserScoreService;

    @Aop(TransAop.READ_COMMITTED)
    public void money(String id, int money, String txt) {
        Member_user user = this.fetch(id);
        Member_user_money userMoney = new Member_user_money();
        userMoney.setCreatAt((int) (System.currentTimeMillis() / 1000));
        userMoney.setOldMoney(user.getMoney());
        userMoney.setDiffMoney(money);
        userMoney.setNewMoney(user.getMoney() + money);
        userMoney.setMemberId(id);
        userMoney.setNote(txt);
        userMoney.setTrade_no("");
        userMoney.setType("管理");
        memberUserMoneyService.insert(userMoney);
        this.update(Chain.make("money", (user.getMoney() + money)).add("opBy", StringUtil.getUid()).add("opAt",
                (int) (System.currentTimeMillis() / 1000)), Cnd.where("id", "=", id));
    }

    @Aop(TransAop.READ_COMMITTED)
    public void score(String id, int score, String txt) {
        Member_user user = this.fetch(id);
        Member_user_score userScore = new Member_user_score();
        userScore.setCreatAt((int) (System.currentTimeMillis() / 1000));
        userScore.setOldScore(user.getScore());
        userScore.setDiffScore(score);
        userScore.setNewScore(user.getScore() + score);
        userScore.setMemberId(id);
        userScore.setNote(txt);
        userScore.setType("管理");
        memberUserScoreService.insert(userScore);
        this.update(Chain.make("score", (user.getScore() + score)).add("opBy", StringUtil.getUid()).add("opAt",
                (int) (System.currentTimeMillis() / 1000)), Cnd.where("id", "=", id));
    }
}
