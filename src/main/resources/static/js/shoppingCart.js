layui.use('form', function(){
    var form = layui.form;
});

$(document).ready(function () {
    //加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

    //查询所有记录
    selectAll();

});

/**
 * 查询所有记录
 */
function selectAll() {
    $.ajax({
        type:"get",
        url:"selectAllCart.do",
        dataType:"json",
        async: false,
        success:function (data) {
            var resultCode = data.resultCode;
            var message = data.message;
            var list = data.data;
            console.log(message);
            if(resultCode == "error"){
                notSession(message);
            }
            else if (resultCode == "success"){
                $(".cart-table").show();
                $(".cart-div").hide();
                // 加载中间商品
                var html = '';
                console.log(list);
                for(var i=0;i<list.length;i++){
                    var cartId = list[i].cartId;
                    var computerImgUrl = list[i].computerImgUrl;
                    var computerName = list[i].computerName;
                    var number = list[i].number;
                    var price = list[i].price;
                    var money=number * price;
                    console.log("computerImgUrl:"+computerImgUrl+"computerName:"+computerName+"number:"+number+"price:"+price+"money:"+money);
                    html +='<tr class="layui-table-body">';
                    html +='<td><input type="radio" onclick="" value="1"/></td>';
                    html +='<td><img id="image" class="logo" src="' + computerImgUrl + '" /><p id="name">' + computerName +'</p></td>';
                    html +='<td id="price">￥'+ price +'</td>';
                    html +='<td><div><button id="jian" class="layui-btn" cartId="' + cartId + '" number="' + number + '" onclick="jian(this)"><i class="layui-icon">－</i></button>';
                    html +='<space id="number">' + number + '</space>';
                    html +='<button id="jia" class="layui-btn" cartId="' + cartId + '" number="' + number + '" onclick="jia(this)"><i class="layui-icon">＋</i></button></div></td>';
                    html +='<td id="result">￥' + money + '</td>';
                    html +='<td><button id="deleteGoodForShoppingCart" class="layui-btn" cartId="' + cartId + '" onclick="deleteCart(this)">';
                    html +='<i class="layui-icon">&#xe640;</i></button></td></tr>';
                }
                $("#table-tbody").append(html);
            }
            else if(resultCode == "fail"){
                alert(message);
                $(".cart-table").hide();
                $(".cart-div").show();

            }
        },
        error:function () {
            alert("报错了！");
        }
    });
}

/**
 * 删除选中的内容
 * @param list
 */
function deleteCart(pom) {
    var cartId = pom.getAttribute("cartId");
    $.ajax({
        type:"post",
        url:"deleteCart.do",
        data:{
            "list":cartId
        },
        success:function (data) {
            var result = data.resultCode;
            var message = data.message;
            console.log(result + message);
            if(result == "success"){
                alert(message);
                window.location.href='shoppingCart.h';
            }
        }
    })
}

/**
 * 增加一个物品
 */
function jia(pom) {
    var cartId = pom.getAttribute("cartId");
    var number = parseInt(pom.getAttribute("number"));
    number = number +1;
    $.ajax({
        type:"post",
        url:"updateCart.do",
        data:{
            "cartId":cartId,
            "number":number
        },
        success:function (data) {
            window.location.href='shoppingCart.h';
        }
    });
}

/**
 * 减少一个物品
 */
function jian(pom) {
    var cartId = pom.getAttribute("cartId");
    var number = parseInt(pom.getAttribute("number"));
    if (number != 1){
        number = number - 1;
        $.ajax({
            type:"post",
            url:"updateCart.do",
            data:{
                "cartId":cartId,
                "number":number
            },
            success:function (data) {
                window.location.href='shoppingCart.h';
            }
        });
    }
}