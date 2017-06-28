$(function () {
    $(".slideBox").slide({mainCell:".bd>ul",effect:"leftLoop",autoPlay:true,interTime:2000});
    $(".picScroll-top").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"top",autoPlay:true,vis:3,trigger:"click"});
    $(".picScroll-leftk").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"leftLoop",autoPlay:true,vis:5});

    $(".i-idecul li a").hover(function () {
        $(this).find("dd").stop().animate({"top": "-214px"})
    }, function () {
        $(this).find("dd").stop().animate({"top": "20px"})

    });
    $(".d-tm").hover(function () {
        $(this).addClass('active');
        $(".d-top .d-tms").stop(true, true).delay(300).slideDown(500, "easeOutBounce");
    }, function () {
        $(".d-top .d-tms").stop(true, true).delay(300).fadeOut(100, "easeInCubic");
    });

    $(".login").click(function (e) {
        $("#login").fadeIn();
    });
    $(".register").click(function (e) {
        $("#register").fadeIn();
    });
    $(".zhece-ula").click(function () {
        $("#login").fadeOut();
        $("#register").fadeOut();
    });

    $(".zhece-ulb>a").hover(function () {
        $(this).addClass("on").siblings("a").removeClass("on");
    });

//屏幕滚动执行
    $(window).scroll(function () {

        var top = document.body.scrollTop | document.documentElement.scrollTop;


        if (top > 400) {
            $(".flu-top").stop().addClass("flu-topa");
        } else {
            $(".flu-top").stop().removeClass("flu-topa");
        }
    });

    $(window).scroll(function () {
        var top = document.body.scrollTop | document.documentElement.scrollTop;
        if (top > 300) {
            $("#scrollSearchDiv").stop();
            $("#scrollSearchDiv").addClass("scoll_add");
        }
        else {
            $("#scrollSearchDiv").stop();
            $("#scrollSearchDiv").removeClass("scoll_add");
        }
        if (top > 200) {
            $(".quan-adda").addClass("quan-addb");
            $(".d-tsecr").addClass("d-tsecra");
        }
        else {
            $(".quan-adda").removeClass("quan-addb");
            $(".d-tsecr").removeClass("d-tsecra");
        }
        if (top > 830) {
            $(".list-dulak").css({"display": "block", "top": top + 62 + "px"});
        } else {
            $(".list-dulak").css({"display": "none"});
        }
    });

//锚点滑动
    $('.flu-top a').click(function () {
        $(".flu-top").stop().removeClass("flu-topa");
        $('html, body').animate({
            scrollTop: $($.attr(this, 'href')).offset().top

        }, 500);
        return false;
    });


    jQuery(".picScroll-left").slide({
        titCell: ".hd ul",
        mainCell: ".bd ul",
        autoPage: true,
        effect: "left",
        autoPlay: true,
        scroll: 1,
        vis: 4
    });
    jQuery(".slideTxtBox").slide({
        titCell: ".hd ul",
        mainCell: ".bd ul",
        autoPlay: true,
        delayTime: 500,
        interTime: 3000,
        autoPage: true,
        effect: "fold",
        autoPlay: true
    });

    $('.footer-a a').click(function () {
        $('html, body').animate({
            scrollTop: $($.attr(this, 'href')).offset().top

        }, 500);
        return false;
    });

    jQuery(".picMarquee-left").slide({
        mainCell: ".bd ul",
        autoPlay: true,
        effect: "leftMarquee",
        vis: 4,
        interTime: 50,
        trigger: "click"
    });

    $(".zhe-o").hover(function () {
        $(".zhuce-inlp").stop().hide();
        $(".zhuce-inlo").stop().show();
    })
    $(".zhe-p").hover(function () {
        $(".zhuce-inlo").stop().hide();
        $(".zhuce-inlp").stop().show();
    })


    $(".del").click(function () {
        $(".d-tsecrdiv").show();
        $(this).closest("li").remove();
    })

    $(".d-tsecr").hover(function () {
        $(".d-tsecrdiv").show();
        $(".d-tsecro").show();
    }, function () {
        $(".d-tsecrdiv").hide();
        $(".d-tsecro").hide();

    })


    $(".flush li").hover(function () {
        $(this).children("span").stop().show();
    }, function () {
        $(this).children("span").stop().hide();
    })

    $(".xq").click(function () {
        $(".list-pj").hide();
        $(".list-bota").stop().fadeIn();
        $(".xq").addClass("on");
        $(".pj").removeClass("on");
    })
    $(".pj").click(function () {
        $(".list-bota").hide();
        $(".list-pj").stop().fadeIn();
        $(".pj").addClass("on");
        $(".xq").removeClass("on");
    })

    //全部商品分类
    $(".d-navl").hover(function () {
        $(this).children(".d-navlop").animate({"height": "toggle"});
    }, function () {
        $(this).children(".d-navlop").hide();
    });
    $(".d-navlop > li").hover(function () {
        $(this).children(".d-navldiv").stop().animate({"height": "toggle"});
    }, function () {
        $(this).children(".d-navldiv").hide();
    });

    $(".d-navli").hover(function () {
        $(this).children("ul").stop().animate({"height": "toggle"});
    });
    $(".d-navli ul>li").hover(function () {
        $(this).children("ul").stop().animate({"height": "toggle"});
    });
});
function getStyle(obj, name) {
    if (obj.currentStyle) {
        return obj.currentStyle[name];
    } else {
        return getComputedStyle(obj, false)[name];
    }
}
function starMove(obj, attr, iTarget) {
    clearInterval(obj.time);
    obj.time = setInterval(function () {
        var cur = 0;
        if (attr == 'opacity') {
            cur = Math.round((getStyle(obj, attr)) * 100);      //四舍五入，使cur取整
        } else {
            cur = parseInt(getStyle(obj, attr));
        }

        var speed = (iTarget - cur) / 5;
        speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
        if (cur == iTarget) {
            clearInterval(obj.time)
        } else {
            if (attr == 'opacity') {
                obj.style.filter = 'alpha(opacity:' + (cur + speed) + ')';
                obj.style.opacity = (cur + speed) / 100;
            } else {
                obj.style[attr] = cur + speed + "px";
            }

        }
    }, 20)

}

function getByClass(oParent, sClass) {
    var aEle = oParent.getElementsByTagName('*');
    var aResult = [];
    for (var i = 0; i < aEle.length; i++) {
        if (aEle[i].className == sClass) {
            aResult.push(aEle[i]);
        }
    }
    return aResult;
}

function add() {
    var i = $(".list-dlea").val();
    i++;
    $(".list-dlea").val(i);
}
function reduce() {
    var i = $(".list-dlea").val();
    if (i >= 2) {
        i--;
    }
    $(".list-dlea").val(i);
}
