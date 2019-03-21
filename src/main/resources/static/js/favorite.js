$(document).ready(function () {
    //加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    // 加载底部代码
    $('.bottom-html').load('./static/html/bottomhtml.html');

});

var user = getsession();

$(window).load(selectAll(user.));

function selectAll(userId) {
    $.ajax({
        type: "post",
        url: "selectAllFavorite.do",
        data: {

        },
    });
}