$(document).ready(function () {
    $("#test").click(function () {
        test3();
    });
});

function test1(pageNum, pageSize) {
    var json = {
        "objectId": "2339269304",
        "layerMarkId": 1,
        "maxLatitude": "39.96790810957493",
        "maxLongitude": "116.31316858902962",
        "minLatitude": "39.95892589042508",
        "minLongitude": "116.3014494109704",
        "pageNum": pageNum,
        "pageSize": pageSize,
        "layerMarkIdArray": [1],
        "customerCode": "SCM6QYUQ",
        "intId": "245486951",
        "conText": "昌平区八仙",
        "longitude": "104.06896786",
        "latitude": "30.68084107",

    };
    $.ajax({
        url: "http://localhost:8081/recapping/queryBuildingDetail.do",
        contentType : 'application/json',
        type: "post",
        data: JSON.stringify(json),
        success: function (data) {
            console.log(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
}

function test2() {
    $.ajax({
        url: "http://localhost:8081/recapping/queryLocation.do",
        type: "post",
        data: {
            "conText": "菜市口地铁站",
            "longitude": "104.06896786",
            "latitude": "30.68084107",
            "pageNum": 1,
            "pageSize": 10
        },
        success: function (data) {
            console.log(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
}

function test3() {
    var json = {
        "password": "123456",
        "desc": "123456"
    };
    $.ajax({
        url: "http://localhost:8081/js/pboss/order/test",
        contentType : 'application/json;charset=UTF-8',
        type: "post",
        dataType: 'json',
        data: JSON.stringify(json),
        success: function (data) {
            console.log(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
}


















