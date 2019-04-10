
// 参数
var type = getUrlParam("type");   // 电脑，手机
var search = getUrlParam("search");
var goodTypeId = ""; // 商品类别id
var pageSize = 8;  //每页数量
var currentPage = 1; //当前数量

$(document).ready(function () {
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
                    var totalPage = 10; // 默认值
                    $.ajax({
                        url: "selectGoodList.do",
                        type: "get",
                        async: false,
                        data: {
                            "goodName": "",
                            "goodTypeId": "",
                            "brandId": "",
                            "screenSize": "",
                            "minGoodPrice": "",
                            "maxGoodPrice": "",
                            "pageSize": pageSize,
                            "currentPage": page
                        },
                        success: function (data) {
                            console.log(data);
                            var result = data.data;
                            var totalNum = result.totalNum;  //总数量
                           totalPage = result.totalPage; //总页数
                            var items = result.items; //数据
                            for(var i = 0; i < items.length; i++){

                                var goodId = items[i].good_id;
                                var goodImg = getGoodListImagePath() + items[i].good_img;
                                var goodPrice = items[i].good_price;
                                var goodDesc = items[i].good_desc;
                                var userName = items[i].user_name;

                                var html = '';
                                html += '<div class="list-item" type="' + type + '" goodId="' + goodId + '" onclick="toDetail(this)">';
                                    html += '<img class="hover-img" src="' + goodImg + '" style="width: 100%; height: 200px;">';
                                    html += '<div class="list-item-price">￥ ' + goodPrice + '</div>';
                                    html += '<div class="list-item-info">' + goodDesc + '</div>';
                                    html += '<div class="list-item-store-name"><span>' + userName + '</span><img class="list-item-chart-icon" src="/static/images/icon_chart.png"></div>';
                                html += '</div>';
                                lis.push(html)
                            }

                        },
                        error: function (data) {

                        }
                    });
                    next(lis.join(''), page < totalPage); //假设总页数为 10
                }, 500);
            }
        });
    });


    // 根据参数，初始化页面显示内容
    initDomShow(type);

    // 根据goodTypeId查询品牌信息
    selectAllBrandByType();

    // 获取列表数据
    getListData();

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
        goodTypeId = "computer";
    }
    if (type == "手机") {
        $(".mobile-type-div").css("display", "block");
        goodTypeId = "mobile_phone";
    }
}

// 获取列表数据
function getListData() {
    $.ajax({
        url: "selectGoodList.do",
        type: "get",
        data: {
            "goodName": "",
            "goodTypeId": "",
            "brandId": "",
            "screenSize": "",
            "minGoodPrice": "",
            "maxGoodPrice": "",
            "pageSize": pageSize,
            "currentPage": currentPage
        },
        success: function (data) {
            console.log(data);
            var result = data.data;
            var totalNum = result.totalNum;  //总数量
            var totalPage = result.totalPage; //总页数
            var item = result.item; //数据

        },
        error: function (data) {
            
        }
    });
}

// 跳转到详情页面
function toDetail(dom) {
    var goodId = dom.getAttribute("goodId");
    var type = dom.getAttribute("type");   // 电脑、手机

    if (type == "电脑") {
        var url = "diannao_detail.html?goodId=" + goodId;
        window.open(encodeURI(url));
    } else if (type == "手机") {
        var url = "shouji_detail.html?goodId=" + goodId;
        window.open(encodeURI(url));
    }
}

// 根据goodTypeId查询品牌信息
function selectAllBrandByType() {
    $.ajax({
        url: "/selectAllBrandByType.do",
        type: "get",
        data: {
            "goodTypeId": goodTypeId
        },
        success: function (data) {
            // 显示品牌数据信息
            var html = '';
            var result = data.data;
            for (var i = 0 ;i < result.length; i++) {
                var brand_id = result[i].brand_id;
                var brand_name = result[i].brand_name;
                var img = result[i].img;

                var imgSrc = getBrandImagePath() + img;

                html += '<div class="pinpai-item-div" title="' + brand_name + '">';
                html += '<img class="pinpai-img-item hover-img" src="' + imgSrc + '">';
                html += '</div>';
            }

            $(".pinpai-item-content").html(html);
        },
        error: function (data) {
            console.log(data);
        }
    });
}






















