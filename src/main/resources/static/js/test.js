$(document).ready(function () {
    $("#test").click(function () {
        test1(0, 0);
    });
});

function test1(pageNum, pageSize) {
    var json = {
        "objectId": "9737B6C8413F4343B920DC09E10F6A8E",
        "layerMarkId": 2,
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
        url: "http://localhost:8081/recapping/queryLayers.do",
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
            "conText": "北京",
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



















