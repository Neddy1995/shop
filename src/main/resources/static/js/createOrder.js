$(document).ready(function () {
    $('.top-html').load('./static/html/tophtml.html');
    loadAddress();
});

/**
 *加载地址信息
 */
function loadAddress() {
    $.ajax({
        type:"get",
        url:"selectOneAddress.do",
        success:function (data) {
            resultCode = data.resultCode;
            message = data.message;
            address = data.data;
            var html = '';
            if (resultCode == "success"){
                html +='<h2 style="float: left;padding-top:15px">地址</h2>';
                html +='<div class="create-order-address-username">谢超</div>';
                html +='<div class="create-order-address-phone">123456</div>';
                html +='<div class="create-order-address-area">四川省成都市龙泉驿区十陵镇</div>';
                $(".create-order-address").html(html);
            }
        },
        error:function () {
            alert("查询地址出错了！");

        }
    })
}

/**
 * 加载商品信息
 */
function loadGood() {

    $.ajax({
        type:"post",
        url:"",
        data:{

        },
        success:function (data) {
            resultCode = data.resultCode;
            message = data.message;
            address = data.data;
            var html = '';
            if (resultCode == "success"){
                html +='<div class="create-order-good-one">';
                html +='<div class="create-order-good-img"><img src="./images/logo.jpg" class="create-order-img"></div>';
                html +='<div class="create-order-good-name">机械革命</div>';
                html +='<div class="create-order-good-price">￥5999</div>';
                html +='<div class="create-order-good-number">×1</div>';
                html +='<div class="create-order-good-result">共1件小计：￥5999</div>';
                html +='</div>';
                $(".create-order-good").html(html);
            }
        }
    })
}

function createOrder() {
    
}