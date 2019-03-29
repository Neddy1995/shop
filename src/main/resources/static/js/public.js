
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

function getImagesPath(){
    var path = "D:/商城系统/图片/电脑品牌图标/";
    return path;
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