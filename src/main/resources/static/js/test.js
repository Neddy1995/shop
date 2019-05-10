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

        "condition": 3,
        "markId": 3,
        "context": ""

    };
    $.ajax({
        url: "http://localhost:8081/recapping/queryNetworkResource.do",
        contentType : 'application/json',
        type: "get",
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
        "username": "李四啊--",
        "token": "token--",
        "pageSize": "10",
        "pageNum": "1",
        "name": "李四啊",
        "businessType": "勘察",
        "orderStatus": "todo",
        "specialType": "internet",
        "taskName": "勘察预约",
        "appointTime": "当天",
        "orderId": "工单编号",
        "customerNo": "客户编码",
        "taskId": "流程任务id",
        "technicalContact": "技术联系人",
        "technicalContactPhone": "987654321",
        "picList": [
            {
                "fileId": "啊呸",
                "fileName": "啊呸",
                "filePath": "啊呸",
                "fileUse": "啊呸"
            },{
                "fileId": "啊呸",
                "fileName": "啊呸",
                "filePath": "啊呸",
                "fileUse": "啊呸"
            }
        ],
    };
    $.ajax({
        url: "http://localhost:8081/js/pboss/sign/save",
        contentType:"application/json;charset=utf-8",
        type: "post",
        dataType: "json",
        data: JSON.stringify(json),
        success: function (data) {
            console.log(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
}


















