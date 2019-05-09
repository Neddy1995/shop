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
            console.log(data);
            if(resultCode == "success"){
                list = data.data;
                var html='';
                for(var i=0;i<list.length;i++){
                    var state = list[i].state;
                    var stateString;
                    switch(state){
                        case "0":
                            stateString="未支付";
                            break;
                        case "1":
                            stateString="已支付未发货";
                            break;
                        case "2":
                            stateString="已发货";
                            break;
                        case "3":
                            stateString="已收货未确认";
                            break;
                        case "4":
                            stateString="已确认完成结束";
                            break;
                        case "5":
                            stateString="已取消";
                            break;
                    }
                    var list1 = list[i].list;
                    html+='<div class="order-info-body">';
                    html+='<div class="order-head">';
                    html+='<div id="begin-time" class="begin-time">'+list[i].beginTime+'</div>';
                    html+='<div id="state" style="float: right" class="state">'+stateString+'</div>';
                    html+='</div>';
                    for(var j=0;j<list1.length;j++){
                        html+='<div class="order-good">';
                        html+='<div class="order-img"><img src="'+getGoodListImagePath()+list1[j].goodImg+'" class="img-img"/></div>';
                        html+='<div class="goodName">'+list1[j].goodName+'</div>';
                        html+='<div class="price">￥'+list1[j].goodPrice+'</div>';
                        html+='<div class="number">×'+list1[j].number+'</div>';
                        // html+='<div class="color">银白色</div>';
                        html+='</div>';
                    }
                    html+='<div id="order-delete" class="order-delete"><button class="layui-btn" orderId="'+list[i].orderId+'" onclick="deleteOrder(this)">删除</button></div>';
                    html+='</div>';
                }
                $("#order-list").html(html);
            }
            else {
                alert("报错了" + message);
                var url = "login.html";
                window.open(encodeURI(url));
            }
            
        }
    })
}

function deleteOrder(pom) {
    var orderId = pom.getAttribute("orderId");
    $.ajax({
        type:"post",
        url:"",
        data:{
            "orderId":orderId
        },
        success:function (data) {
            var resultCode =data.resultCode;
            var message = data.message;
            if(resultCode == "success"){
                alert(message);
                window.location.href='user.h';
            }
            
        }
    })
    
}