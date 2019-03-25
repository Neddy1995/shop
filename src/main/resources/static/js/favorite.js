$(document).ready(function () {
    //加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

});

/**
 * 查询所有的收藏记录
 */
function selectAll() {
    $.ajax({
        type: "post",
        url: "selectAllFavorite.do",
        success:function(data){
            var result = data.resultCode;
            var message = data.message;
            var list = data.data;
            console.log(result + message);
            if(result =="success"){
                for(var favoritePo in list){

                }
            }
            alert(message);
        }

    });
}

/**
 * 删除一条收藏夹
 * @param favoriteId
 */
function deleteOne(favoriteId){
    $.ajax({
        type:"post",
        url:"DeleteFavorite.do",
        data:{
            "favoriteId":favoriteId
        },
        success:function (data) {
            var result = data.resultCode;
            var message = data.message;
            console.log(result + message);
            if(result == "success"){
                alert(message);
                window.location.href("favorite.h");
            }
        }
    })
}