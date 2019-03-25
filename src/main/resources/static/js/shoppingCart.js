layui.use('form', function(){
    var form = layui.form;
});

$(document).ready(function () {
    //加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

    //自动加载购物车数据
    $.ajax({
        type:"get",
        url:"selectAllCart.do",
        dataType:"json",
        success:function (data) {
            var resultCode = data.resultCode;
            var message = data.message;
            var list = data.data;
            console.log(message);
            if (resultCode == "success"){
                for ( var shoppingCartPo in list){
                    $("#image").src(shoppingCartPo.computerImgUrl);
                    $("#name").text(shoppingCartPo.computerName);
                    $("#price").text("￥"+shoppingCartPo.price);
                }
            }
            else{
                alert(message);
            }
        }
    });

    //增加一个物品
    $("#jia").click(function () {
        alert("增加一个");
    });
    //减少一个物品
    $("#jian").click(function () {
        alert("减少一个");
    });

});


function deleteAll(list) {
    $.ajax({
        type:"post",
        url:"deleteCart.do",
        data:{
            "list":list
        },
        success:function (data) {
            var result = data.resultCode;
            var message = data.message;
            console.log(result + message);
            if(result == "success"){
                alert(message);
            }
            alert(message);
        }
    })
}