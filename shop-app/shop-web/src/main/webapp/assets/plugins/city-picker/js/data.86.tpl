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
<!--#COUNTRY#-->
<!--#DATA#-->
};

if (typeof window !== 'undefined') {
    window.Districts = Districts;
}

return Districts;

});
