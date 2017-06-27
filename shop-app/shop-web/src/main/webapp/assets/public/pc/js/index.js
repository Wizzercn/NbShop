$(function () {
    $(".slideBox").slide({mainCell:".bd>ul",effect:"leftLoop",autoPlay:true,interTime:2000});
    $(".picScroll-top").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"top",autoPlay:true,vis:3,trigger:"click"});
    $(".picScroll-leftk").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"leftLoop",autoPlay:true,vis:5});

});