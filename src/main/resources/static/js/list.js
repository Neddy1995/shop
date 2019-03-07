$(document).ready(function () {

    // 参数
    var type = getUrlParam("type");
    var search = getUrlParam("search");

    // 加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
    });

    // 信息流加载
    layui.use('flow', function(){
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
            elem: '#goods-list' //指定列表容器
            ,isAuto: true
            ,mb: 200
            ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
                //模拟数据插入
                setTimeout(function(){
                    var lis = [];
                    for(var i = 0; i < 8; i++){
                        var html = '';
                        html += '<div class="list-item">';
                            html += '<img class="hover-img" src="/static/images/icon_c1.png" style="width: 100%; height: 200px;">';
                            html += '<div class="list-item-price">￥ 2000</div>';
                            html += '<div class="list-item-info">我是一个电脑介绍我是一个电脑介绍我是一个个电脑介绍电脑介绍</div>';
                            html += '<div class="list-item-store-name"><span>华为京东小英雄旗舰店</span><img class="list-item-chart-icon" src="/static/images/icon_chart.png"></div>';
                        html += '</div>';
                        lis.push(html)
                    }

                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < 10); //假设总页数为 10
                }, 500);
            }
        });
    });


    // 根据参数，初始化页面显示内容
    initDomShow(type);

});


// 获取上一个页面来的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = decodeURI(window.location.search).substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

// 根据参数，初始化页面显示内容
function initDomShow(type) {
    if (type == "电脑") {
        $(".compter-type-div").css("display", "block");
    }
    if (type == "手机") {
        $(".mobile-type-div").css("display", "block");
    }
}

// 获取列表数据
function getListData() {
    $.ajax({
        url: "",
        type: "get",
        data: {
            
        },
        success: function (data) {
            
        },
        error: function (data) {
            
        }
    });
}

// 动态显示列表数据
function showListData(data) {
    var length = 20;

    for (var i = 0; i < length ; i++) {

    }
}


























