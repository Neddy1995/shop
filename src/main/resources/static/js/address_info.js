$(document).ready(function(){
    loadAddress();
});

/**
 * 加载地址信息数据
 */
function loadAddress() {
    $.ajax({
        type:"get",
        url:"selectAllAddress.do",
        async:false,
        success:function (data) {
            var resultCode = data.resultCode;
            var message = data.message;
            console.log(resultCode+message);
            if(resultCode == "success"){
                var list = data.data;
                var html = '';
                for(var i=0 ;i<list.length ; i++){
                    var addressId = list[i].addressId;
                    var addressName = list[i].addressName;
                    var addressPhone = list[i].addressPhone;
                    var addressProv = list[i].addressProv;
                    var addressCity = list[i].addressCity;
                    var addressArea = list[i].addressArea;
                    var addressStreet = list[i].addressStreet;
                    var addressInfo = list[i].addressInfo;
                    html+='<div class="address-info-body">';
                    html+='<div class="address-name">'+ addressName +'</div>';
                    html+='<div class="address-phone">'+ addressPhone +'</div>';
                    html+='<div class="address-area">'+ addressProv + addressCity + addressArea + addressStreet +'</div>';
                    html+='<div class="address-address">'+ addressInfo +'</div>';
                    html+='</div>';
                    html+='<div class="address-btn"><button addressid="' + addressId + '" onclick="deleteAddress(this)" class="layui-btn layui-btn-fluid">删除</button></div>';
                }
                $("#address-load").html(html);
            }
            else{
                alert("报错了"+message);
                var url = "login.html";
                window.open(encodeURI(url));
            }
        },
        error:function (data) {
            alert("查询地址错误！");
        }
    });
}

function deleteAddress(pom) {
    var addressId = pom.getAttribute("addressId");
    $.ajax({
        type:"post",
        url:"deleteAddress.do",
        data:{
            "addressId":addressId
        },
        success:function (data) {
            var resultCode = data.resultCode;
            var message = data.message;
            console.log(resultCode+message);
            if(resultCode == "success"){
                alert("删除成功！");
                // window.location.href("address_info.html");
            }
        }
    });
}