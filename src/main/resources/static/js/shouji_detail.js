
// 参数
var goodId = getUrlParam("goodId");

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

    // 请求电脑详情数据
    selectComputerGoodDetail();

    // 获取地理位置
    getPosition();


    // 查询库存
    selectStock();
});

// 请求电脑详情数据
function selectComputerGoodDetail() {
    $.ajax({
        url: "/selectComputerGoodDetail.do",
        type: "get",
        data: {
            "goodId": goodId
        },
        success: function (data) {
            var computer = data.data;

            var brandId = computer.brandId;
            var computerColour = computer.computerColour;
            var computerCpu = computer.computerCpu;
            var computerGpu = computer.computerGpu;
            var computerId = computer.computerId;
            var computerImgUrl = computer.computerImgUrl;
            var computerName = computer.computerName;
            var computerRam = computer.computerRam;
            var computerRom = computer.computerRom;
            var computerScreenRefresh = computer.computerScreenRefresh;
            var computerScreenResolution = computer.computerScreenResolution;
            var computerScreenSize = computer.computerScreenSize;
            var computerVersion = computer.computerVersion;
            var goodDesc = computer.goodDesc;
            var goodId = computer.goodId;
            var material = computer.material;
            var price = computer.price;
            var system = computer.system;
            var weight = computer.weight;

            $(".goodDesc").html(goodDesc);
            $(".price").html(price);
            $(".computerColour").html(computerColour);
            $(".computerVersion").html(computerVersion);
            $(".computerImgUrl").attr("src", getGoodListImagePath() + computerImgUrl);

            $(".detail-item-computerName").html(computerName);
            $(".detail-item-computerVersion").html(computerVersion);
            $(".detail-item-computerColour").html(computerColour);
            $(".detail-item-computerCpu").html(computerCpu);
            $(".detail-item-computerGpu").html(computerGpu);
            $(".detail-item-computerRom").html(computerRom);
            $(".detail-item-computerRam").html(computerRam);
            $(".detail-item-computerScreenSize").html(computerScreenSize);
            $(".detail-item-computerScreenResolution").html(computerScreenResolution);
            $(".detail-item-computerScreenRefresh").html(computerScreenRefresh);
            $(".detail-item-material").html(material);
            $(".detail-item-system").html(system);
            $(".detail-item-weight").html(weight);

        },
        error: function (data) {
            console.log(data);
        }
    });
}

// 查询库存
function selectStock() {
    $.ajax({
        url: "/selectStock.do",
        type: "get",
        data: {
            "goodId": goodId
        },
        success: function (data) {
            var stock = data.data.stock;
            $(".stock").html(stock);
        },
        error: function (data) {
            console.log(data);
        }
    });
}

// 获取地理位置
function getPosition() {
    var position = "成都大学";
    $(".position").html(position);
}


// 获取上一个页面来的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = decodeURI(window.location.search).substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

















