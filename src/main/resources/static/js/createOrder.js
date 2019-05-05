//获取缓存中的值
var list = localStorage.getItem("goodIdList");

$(document).ready(function () {
    $('.top-html').load('./static/html/tophtml.html');
    loadAddress();
    loadGood();
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
            window.location.href='index.h';

        }
    })
}

/**
 * 加载商品信息
 */
function loadGood() {

    $.ajax({
        type:"post",
        url:"selectGoodByCart.do",
        data:{
            "list":list
        },
        success:function (data) {
            resultCode = data.resultCode;
            message = data.message;
            console.log(resultCode+message);
            if (resultCode == "success"){
                list = data.data;
                var resultNumber=0;
                var money =0;
                var html = '';
                for (var i=0;i<list.length;i++){
                    resultNumber += Number(list[i].number);
                    money +=list[i].goodPrice * list[i].number;
                    console.log(money+":"+money);
                    html +='<div class="create-order-good-one">';
                    html +='<div class="create-order-good-img"><img src="'+ getGoodListImagePath() + list[i].goodImg +'" class="create-order-img"></div>';
                    html +='<div class="create-order-good-name">'+ list[i].goodName+'</div>';
                    html +='<div class="create-order-good-price">￥'+list[i].goodPrice+'</div>';
                    html +='<div class="create-order-good-number">×'+list[i].number+'</div>';
                    html +='<div class="create-order-good-result">共'+list[i].number+'件小计：￥'+list[i].goodPrice*list[i].number+'</div>';
                    html +='</div>';
                }
                $(".create-order-good").html(html);
                $("#result-number").append("共"+resultNumber+"件");
                $("#result-price").append("合计：￥"+money);
            }
        }
    })
}

function createOrder() {
    
}