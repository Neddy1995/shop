$(document).ready(function () {
    //加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

    selectAll();
});

/**
 * 查询所有的收藏记录
 */
function selectAll() {
    $.ajax({
        type: "get",
        url: "selectAllFavorite.do",
        success:function(data){
            var result = data.resultCode;
            var message = data.message;
            var list = data.data;
            console.log(result + message);
            console.log(list);
            if(result =="error"){
                notSession(message);
            }
            else if(result =="success"){
                var html='';
                for(var i=0 ;i<list.length ; i++){
                    var favoriteId = list[i].favoriteId;
                    var computerName = list[i].computerName;
                    var price = list[i].price;
                    var time = list[i].time;
                    html+='<div class="good_content" favoriteId="favoriteId" onclick="toDetail(this)">';
                    html+='<div class="good-top">';
                    html+='<div class="good-time">收藏时间：'+time+'</div>';
                    html+='<p class="good-p">已收藏</p></div>';
                    html+='<div class="good-body">';
                    html+='<img class="good-picture good" src="./images/logo.jpg"/>';
                    html+='<div class="good-name good">'+ computerName +'</div>';
                    html+='<div class="good-price good">'+price+'</div>';
                    html+='<div class="good-btn good">';
                    html+='<button class="layui-btn" favoriteId="'+ favoriteId +'" onclick="deleteOne(this)"><i class="layui-icon">&#xe640;</i></button>';
                    html+='</div>';
                    html+='</div>';
                    html+='</div>';
                }
                $("#favorite-div").html(html);
            }
            else{alert(message);}

        },
        error:function () {
            alert("报错了！");
        }
    });
}

/**
 * 删除一条收藏夹
 * @param favoriteId
 */
function deleteOne(pom){
    var favoriteId = pom.getAttribute("favoriteId");
    $.ajax({
        type:"post",
        url:"deleteFavorite.do",
        data:{
            "favoriteId":favoriteId
        },
        success:function (data) {
            var result = data.resultCode;
            var message = data.message;
            console.log(result + message);
            if(result == "success"){
                alert(message);
                window.location.href="favorite.h";
            }
        },
        error:function () {
            alert("报错了");
        }
    })
}

/**
 *
 */
function toDetail(pom){
    var favoriteId = pom.getAttribute("favoriteId");
    var type = pom.getAttribute("type");
    if (type == "电脑") {
        var url = "diannao_detail.html?goodId=" + favoriteId;
        window.open(encodeURI(url));
    } else if (type == "手机") {
        var url = "shouji_detail.html?goodId=" + favoriteId;
        window.open(encodeURI(url));
    }
}