$(function () {
    $(".slideBox").slide({mainCell:".bd>ul",effect:"leftLoop",autoPlay:true,interTime:2000});
    $(".picScroll-top").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"top",autoPlay:true,vis:3,trigger:"click"});
    $(".picScroll-leftk").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"leftLoop",autoPlay:true,vis:5});
    //全部商品分类
    $(".d-navl").hover(function(){
        $(this).children(".d-navlop").animate({"height":"toggle"});
    },function(){
        $(this).children(".d-navlop").hide();
    });
    $(".d-navlop > li").hover(function(){
        $(this).children(".d-navldiv").stop(true, true).delay(300).slideDown(500, "easeOutBounce");
    },function(){
        $(this).children(".d-navldiv").stop(true, true).delay(300).fadeOut(100, "easeInCubic");
    });
    $(".d-navli").hover(function(){
        $(this).children("ul").stop().animate({"height":"toggle"});
    });
    $(".d-navli ul>li").hover(function(){
        $(this).children("ul").stop().animate({"height":"toggle"});
    });
});