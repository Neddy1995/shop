
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

function getSession() {
    var session = "<%=session.getAttribute("user")%>";
    alert(session);
    return session;
}