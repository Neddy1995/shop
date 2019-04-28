$(document).ready(function () {
    //加载头部代码
    $('.top-html').load('./static/html/tophtml.html');

    //加载内容界面
    $('.user-page').load('./static/html/address_info.html');
});


/**
 * 点击切换
 * @param id
 */
function search(id) {
    switch (id){
        case "user-info":
            $('.user-page').load('./static/html/user_info.html');
            break;
        case "order-info":
            $('.user-page').load('./static/html/order_info.html');
            break;
        case "address-info":
            $('.user-page').load('./static/html/address_info.html');
            break;
        default:
            break;
    }
}