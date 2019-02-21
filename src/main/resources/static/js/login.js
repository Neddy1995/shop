$(document).ready(function () {

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

    // 图片验证码
    $(".verification-code").on("click",function () {
        var timestamp = (new Date()).valueOf();
        $(this).attr("src","code?timestamp=" + timestamp);
    });

    // 登陆按钮点击事件
    $("#login-btn").click(function () {
        // 获取用户名、密码、图片验证码的值，然后校验
        var userName = $.trim($("#userName").val());
        var password = $.trim($("#password").val());
        var paramCode = $.trim($("#paramCode").val());

        if (userName == "") {
            showAlertMsg('用户名为空');
            return;
        }

        if (password == "") {
            showAlertMsg('密码为空');
            return;
        }

        if (paramCode == "") {
            showAlertMsg('验证码为空');
            return;
        }

        login(userName, password, paramCode);
    });

});

/**
 * 登陆
 * @param userName
 * @param password
 * @param paramCode
 */
function login(userName, password, paramCode) {
    $.ajax({
        type: "post",
        url: "login.do",
        data: {
            "userName": userName,
            "password": password,
            "paramCode": paramCode
        },
        success: function (data) {
            console.log(data);
            // 处理登陆结果
            var resultCode = data.resultCode;
            var message = data.message;
            showAlertMsg(resultCode + message);

            // 登陆失败
            if (resultCode == "fail") {
                showAlertMsg(message);
            } else {
                // 登陆成功
                // 跳转到首页
                window.location.href = "index.h"
            }
        },
        error: function(data) {
            console.log(data);
        }
    });
}















