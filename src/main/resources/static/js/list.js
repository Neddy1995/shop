$(document).ready(function () {

    // 参数
    var param = getPramValue("search");

    // 加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
    });

});


// 获取上一个页面来的参数
function getPramValue(name) {
    var param = "";
    var str = decodeURI(window.location.search);   //location.search是从当前URL的?号开始的字符串
    if (str.indexOf(name) != -1) {
        var pos_start = str.indexOf(name) + name.length + 1;
        var pos_end = str.indexOf("&", pos_start);

        if (pos_end == -1) {
            param= str.substring(pos_start);
        } else {
            param = "";
        }
    }
    return param;
}
