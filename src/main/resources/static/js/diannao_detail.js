$(document).ready(function () {

    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
    });

    // 加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

    // 增加数量，就是那个+
    $(".add-btn").click(function () {
        var number = parseInt($(".number-choice").val()) + 1;
        $(".number-choice").val(number);
    });

    // 减少数量，就是那个-
    $(".delete-btn").click(function () {
        var number = $(".number-choice").val();
        if (number == "1") {
            return;
        } else {
            $(".number-choice").val(parseInt(number) - 1);
        }
    });

    // 加入购物车
    $(".add-to-shopping").click(function () {
        showAlertMsg("加入购物车成功");
    });

    // 收藏
    $(".collect-btn").click(function () {
        showAlertMsg("收藏成功");
    });
});




















