$(document).ready(function () {
    // 加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
    });

    // 轮播图部分
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            ,width: '100%' //设置容器宽度
            ,height: '280px'
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });

    // 电脑-手机-测评的点击事件
    $(".tab-brief-li").click(function () {
        var text = $(this).text();
        initRollContentLeftData(text);
    });


    // 初始化轮播图左边那里的数据
    initRollContentLeftData("电脑");

});


// 初始化轮播图左边那里的数据
function initRollContentLeftData(text) {
    var html = '';
    if (text == "电脑") {
        html += '<div class="tool-bar-item" param="台式电脑">台式电脑</div>';
        html += '<div class="tool-bar-item" param="笔记本">笔记本</div>';
        html += '<div class="tool-bar-item" param="二手电脑">二手电脑</div>';
        html += '<div class="tool-bar-item" param="外设">外设</div>';
        html += '<div class="tool-bar-item" param="配件">配件</div>';
    } else if (text == "手机") {
        html += '<div class="tool-bar-item" param="发烧友">发烧友</div>';
        html += '<div class="tool-bar-item" param="性价比">性价比</div>';
        html += '<div class="tool-bar-item" param="二手机">二手机</div>';
        html += '<div class="tool-bar-item" param="外设">外设</div>';
        html += '<div class="tool-bar-item" param="配件">配件</div>';
    } else if (text == "评测") {
        html += '<div class="tool-bar-item" param="台式电脑测评">台式电脑测评</div>';
        html += '<div class="tool-bar-item" param="笔记本测评">笔记本测评</div>';
        html += '<div class="tool-bar-item" param="手机测评">手机测评</div>';
        html += '<div class="tool-bar-item" param="外设测评">外设测评</div>';
        html += '<div class="tool-bar-item" param="配件测评">配件测评</div>';
    } else {
        return;
    }
    $(".roll-content-left").html(html);

    $(".tool-bar-item").click(function () {
        var searchContent = $(this).attr("param")
        location.href=encodeURI("list.html?search=" + searchContent);
    });
}
