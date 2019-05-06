
/**
 * 弹出预警信息
 * @param str
 */
function showAlertMsg(str) {
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.msg(str);
    });
}

// 品牌图片路径
function getBrandImagePath() {
    return "http://47.99.183.187:8080/Images/brand_img/";
}

// 商品列表的图片路径
function getGoodListImagePath() {
    return "http://47.99.183.187:8080/Images/";
}


function notSession(message) {
    alert(message + "前往登录！");
    window.location.href='login.h';
}

// 加入购物车
function addCart(goodId) {
    $.ajax({
        url: "/addCart.do",
        type: "post",
        data: {
            "goodId": goodId
        },
        success: function (data) {
            console.log(data);
            var resultCode = data.resultCode;
            if (resultCode == "success") {
                showAlertMsg("添加购物车成功");
            } else if (resultCode == "fail" || resultCode == "error") {
                showAlertMsg("未登录，请登陆");
            }
        },
        error: function (data) {
            console.log(data);
        }
    });
}

// 添加收藏
function  insertFavorite(goodId) {
    $.ajax({
        url: "/insertFavorite.do",
        type: "post",
        data: {
            "goodId": goodId
        },
        success: function (data) {
            console.log(data);
            var resultCode = data.resultCode;
            if (resultCode == "success") {
                showAlertMsg("收藏成功");
            } else if (resultCode == "error") {
                showAlertMsg("未登录，请登陆");
            } else if (resultCode == "fail") {
                showAlertMsg("收藏成功");
            }
        },
        error: function (data) {
            console.log(data);
        }
    });
}


// 添加历史记录
function  addBrowseHistory(goodId) {
    $.ajax({
        url: "/addBrowseHistory.do",
        type: "get",
        data: {
            "goodId": goodId
        },
        success: function (data) {
        },
        error: function (data) {
        }
    });
}





















