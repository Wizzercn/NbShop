/**
 * Created by wizzer.cn on 3/7/16.
 */
(function ($) {
    var ms = {
        init: function (obj, args) {
            return (function () {
                ms.fillHtml(obj, args);
                ms.bindEvent(obj, args);
            })();
        },
        //填充html
        fillHtml: function (obj, args) {
            return (function () {
                obj.empty();
                //上一页
                if (args.current > 1) {
                    obj.append('<a href="javascript:;" class="page-l round_s"><i></i><span>上一页</span></a> ');
                } else {
                    obj.append('<a class="page-l round_s disabled"><i></i><span>上一页</span></a> ');
                }
                //中间页码
                if (args.current != 1 && args.current >= 4 && args.pageCount != 4) {
                    obj.append('<a href="javascript:;" class="page-num round_s">' + 1 + '</a> ');
                }
                if (args.current - 2 > 2 && args.current <= args.pageCount && args.pageCount > 5) {
                    obj.append('<span class="page-txt">...</span> ');
                }
                var start = args.current - 2, end = args.current + 2;
                if ((start > 1 && args.current < 4) || args.current == 1) {
                    end++;
                }
                if (args.current > args.pageCount - 4 && args.current >= args.pageCount) {
                    start--;
                }
                for (; start <= end; start++) {
                    if (start <= args.pageCount && start >= 1) {
                        if (start != args.current) {
                            obj.append('<a href="javascript:;" class="page-num round_s">' + start + '</a> ');
                        } else {
                            obj.append('<a class="page-num round_s on">' + start + '</a> ');
                        }
                    }
                }
                if (args.current + 2 < args.pageCount - 1 && args.current >= 1 && args.pageCount > 5) {
                    obj.append('<span class="page-txt">...</span> ');
                }
                if (args.current != args.pageCount && args.current < args.pageCount - 2 && args.pageCount != 4) {
                    obj.append('<a href="javascript:;" class="page-num round_s">' + args.pageCount + '</a> ');
                }
                //下一页
                if (args.current < args.pageCount) {
                    obj.append('<a href="javascript:;" class="page-r round_s"><span>下一页</span><i></i></a> ');
                } else {
                    obj.append('<a class="page-r round_s disabled"><span>下一页</span><i></i></a> ');
                }
            })();
        },
        //绑定事件
        bindEvent: function (obj, args) {
            return (function () {
                obj.on("click", "a.page-num", function () {
                    var current = parseInt($(this).text());
                    if (current != args.current) {
                        ms.fillHtml(obj, {"current": current, "pageCount": args.pageCount});
                        if (typeof(args.backFn) == "function") {
                            args.backFn(current);
                        }
                    }
                });
                //上一页
                obj.on("click", "a.page-l", function () {
                    var current = parseInt(obj.children("a.on").text());
                    if (current - 1 > 0) {
                        ms.fillHtml(obj, {"current": current - 1, "pageCount": args.pageCount});
                        if (typeof(args.backFn) == "function") {
                            args.backFn(current - 1);
                        }
                    }
                });
                //下一页
                obj.on("click", "a.page-r", function () {
                    var current = parseInt(obj.children("a.on").text());
                    if (current + 1 <= args.pageCount) {
                        ms.fillHtml(obj, {"current": current + 1, "pageCount": args.pageCount});
                        if (typeof(args.backFn) == "function") {
                            args.backFn(current + 1);
                        }
                    }
                });
            })();
        }
    };
    $.fn.createPage = function (options) {
        var args = $.extend({
            pageCount: 10,
            current: 1,
            backFn: function () {
            }
        }, options);
        ms.init(this, args);
    }
})(jQuery);
