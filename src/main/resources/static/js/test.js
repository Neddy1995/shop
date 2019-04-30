$(document).ready(function () {
    $("#test").click(function () {
        test1(1,10);
        //test2();
    });
});

function test1(pageNum, pageSize) {
    var json = {
        "objectId": "F1916162235047BAAB491948ED68C49D",
        "layerMarkId": 1,
        "maxLongitude": "116.28798258314056",
        "minLongitude": "116.27628525942858",
        "maxLatitude": "39.83999859182575",
        "minLatitude": "39.831016372675904",
        "pageNum": pageNum,
        "pageSize": pageSize,
        "layerMarkIdArray": [1,2,3,4,5,7],
        "customerCode": "SCM6QYUQ",
        "intId": "245486951",
        "conText": "昌平区八仙",
        "longitude": "104.06896786",
        "latitude": "30.68084107",

    };
    $.ajax({
        url: "http://localhost:8081/recapping/queryNetworkResource.do",
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



















