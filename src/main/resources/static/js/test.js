$(document).ready(function () {
    $("#test").click(function () {
        test1(1,3);
    });
});

function test1(pageNum, pageSize) {
    var json = {
        "objectId": "fgq_001",
        "layerMarkId": 7,
        "maxLongitude": "104.06896786651129",
        "minLongitude": "104.06687905348872",
        "maxLatitude": "30.680841071914987",
        "minLatitude": "30.679044628085016",
        "pageNum": pageNum,
        "pageSize": pageSize,
        "layerMarkIdArray": [1,2,3,4,5,6,7]

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
            "conText": "朝阳区新源西里",
            "longitude": "104.06896786",
            "latitude": "30.68084107",
            "pageNum": 1,
            "pageSize": 2
        },
        success: function (data) {
            console.log(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
}



















