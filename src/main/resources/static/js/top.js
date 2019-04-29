$(document).ready(function () {
    /**
     * 后台获取session
     * 如果存在session则显示用户按钮和退出按钮
     * 不存在则显示登录和注册按钮
     */
    $.ajax({
        type:"get",
        url:"getSession",
        dataType:"json",
        async: false,
        success:function (data) {
            var resultCode = data.resultCode;
            var message = data.message;
            var user = data.data;
            console.log(message);
            var power = user.power;
            if (resultCode == "success"){
                if(power == "1"){
                    $("#login").hide();
                    $("#register").hide();
                    $("#admin").hide();
                    $("#user").show();
                    $("#logout").show();
                    $("#user").text(user.userName);
                }
                else if(power == "2" || power == "3"){
                    $("#admin").show();
                    $("#logout").show();
                    $("#login").hide();
                    $("#register").hide();
                    $("#user").hide();
                }
            }
            else{
                $("#user").hide();
                $("#logout").hide();
                $("#admin").hide();
                $("#login").show();
                $("#register").show();
            }
        },
        error:function () {
            $("#user").hide();
            $("#logout").hide();
            $("#login").show();
            $("#register").show();
        }
    });

    /**
     * 点击退出
     */
    $("#logout").click(function () {
        $.ajax({
            type:"get",
            url:"closeSession",
            success:function () {
                showAlertMsg("退出成功！");
                window.location.href='index.h';
            }
        })

    })

});

