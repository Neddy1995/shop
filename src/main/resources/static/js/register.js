layui.use('form', function(){
    var form = layui.form;
});

$(document).ready(function () {

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

    $("#layui-btn").click(function () {
        var username = $.trim($("#userName").val());
        var password = $.trim($("#password").val());
        var passwordAgain = $.trim($("#passwordAgain").val());
        var sex = $('input[name="sex"]:checked').val();
/*        var age = $('select[name="age"]').val();
        var profession = $('select[name="profession"]').val();*/

        var age = 1;
        var profession = 2;

        if (username == "") {
            showAlertMsg("用户名为空");
            return;
        }

        if (password == "") {
            showAlertMsg("密码为空");
            return;
        }

        if (passwordAgain == "") {
            showAlertMsg("确认密码为空");
            return;
        }

        if (password == passwordAgain) {
            showAlertMsg("两次密码不一致");
            return;
        }

        if (age == "") {
            showAlertMsg("未选择年龄");
            return;
        }

        if (profession == "") {
            showAlertMsg("为选择职业");
            return;
        }

        register(username, password, sex, age, profession);
    });
});

/**
 *
 * @param username
 * @param password
 * @param sex
 * @param age
 * @param profession
 */
function register(username,password,sex,age,profession) {
    $.ajax({
        type:"past",
        url:"register.do",
        data:{
            "username":username,
            "password":password,
            "sex":sex,
            "age":age,
            "profession":profession
        },
        success:function (data) {
            console.log(data);
            var resultCode = data.resultCode;
            var message = data.message;
            showAlertMsg(resultCode + message);
            if(resultCode == "fail"){
                showAlertMsg(message);
            }
            else{
                showAlertMsg(message);
                window.location.href='login.h';
            }
            },
        error:function (data) {
            console.log(data);
        }
    });
}

