$(document).ready(function () {

    loadData();

    $("#user-info-update").click(function () {
        var userName=$.trim($("#user-name").val());
        var userAge=$.trim($("#user-age").val());
        var userSex=$.trim($("#user-sex").val());
        var userPro=$.trim($("#user-profession").val());
        console.log(userName+":"+userAge+":"+userSex+":"+userPro);
        $.ajax({
            type:"post",
            url:"userUpdate.do",
            data:{
                "userName":userName,
                "userAge":userAge,
                "userSex":userSex,
                "userPro":userPro
            },
            success:function (data) {
                var message=data.message;
                var resultCode=data.resultCode;
                console.log(message+resultCode);
                if(resultCode=="success"){
                    window.location.href="user.h";
                }
            },
            error:function (data) {
                alert("报错了");
            }
        });
    });
});

/**
 * 加载用户信息
 */
function loadData() {
    $.ajax({
        type:"get",
        url:"userInfo.do",
        success:function (data) {
            var message=data.message;
            var resultCode=data.resultCode;
            console.log(message+resultCode);
            var user=data.data;
            var userName=user.userName;
            var age=user.age;
            var sex=user.sex;
            var profession=user.profession;
            var regtime=user.regtime;
            var time=regtime.substring(1,4)+"-"+regtime.substring(5,6)+"-"+regtime.substring(7,8)+" "+regtime.substring(9,10)+":"+regtime.substring(11,12)+":"+regtime.substring(13,1);
            console.log(time);
            if(resultCode=="success"){
                $("#user-name").attr("value",userName);
                $("#user-age").attr("value",age);
                $("#user-sex").attr("value",sex);
                $("#user-profession").attr("value",profession);
                $("#regTime").attr("value",regtime);
            }
            else if(resultCode=="fail"){
                alert("报错了！"+message);
            }
            else{
                alert("报错了!"+message);
            }
        },
        error:function (data) {
            alert("报错了error");
        }
    });
}



