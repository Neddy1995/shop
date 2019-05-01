$(document).ready(function () {

    loadOrder();
});

/**
 * 加载数据
 */
function loadOrder() {
    $.ajax({
        type:"get",
        url:"selectAllOrder.do",
        async:false,
        success:function (data) {
            resultCode = data.resultCode;
            message = data.message;
            list = data.data;
            console.log(resultCode+message);
            console.log(list);
            if(resultCode == "success"){
                var html='';
                for(var i=0;i<1;i++){
                    html+='<div class="order-head">';
                    html+='<div id="begin-time" class="begin-time">2019-04-28 16:04:00</div>';
                    html+='<div id="state" style="float: right" class="state">交易成功</div>';
                    html+='</div>';
                    html+='<div class="order-good">';
                    html+='<div class="order-img"><img src="./images/logo.jpg" class="img-img"/></div>';
                    html+='<div class="goodName">机械革命</div>';
                    html+='<div class="price">￥5999</div>';
                    html+='<div class="number">×1</div>';
                    html+='<div class="color">银白色</div>';
                    html+='</div>';
                    html+='<div id="order-delete" class="order-delete"><button class="layui-btn">删除</button></div>';
                    html+='</div>';
                }
                $("#order-list").html(html);
            }
            else{
                alert("查询订单错误！");
            }
            
        }
    })
}