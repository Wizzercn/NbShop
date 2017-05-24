/*!
 * all为全部区域,shop为只包含启用的地区
 *
 * Wizzer.cn
 * Date: 2017-03-15
 */
(function (factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as anonymous module.
        define('Districts', [], factory);
    } else {
        // Browser globals.
        factory();
    }
})(function () {

var Districts = {
86:{'A-G': [{code: '340000', address: '安徽省'}],
},
340000:{340100:'合肥市'},
340100:{340102:'瑶海区',340103:'庐阳区',340104:'蜀山区',340111:'包河区',340121:'长丰县',340122:'肥东县',340123:'肥西县',340124:'庐江县',340181:'巢湖市'},

};

if (typeof window !== 'undefined') {
    window.Districts = Districts;
}

return Districts;

});
