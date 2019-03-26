
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
    var path = "D://images";
}


function notSession(message) {
    alert(message + "前往登录！");
    window.location.href='login.h';
}