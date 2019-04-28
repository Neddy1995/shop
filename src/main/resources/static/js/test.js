$(document).ready(function () {
    $("#test").click(function () {
        test1(1,10);
    });
});

function test1(pageNum, pageSize) {
    var json = {
        "objectId": "1356590401",
        "layerMarkId": 7,
        "maxLongitude": "200",
        "minLongitude": "30",
        "maxLatitude": "200",
        "minLatitude": "30",
        "pageNum": pageNum,
        "pageSize": pageSize,
        "layerMarkIdArray": [1,2,3,4,5,7],
        "customerCode": "SCM6QYUQ",
        "intId": "245486951"

    };
    $.ajax({
        url: "http://localhost:8081/recapping/queryPortList.do",
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
        url: "http://localhost:8082/recapping/queryLocation.do",
        type: "post",
        data: {
            "conText": "昌平区八仙",
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



















