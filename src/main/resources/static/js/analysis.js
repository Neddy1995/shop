

$(document).ready(function () {

    layui.use('form', function(){
        var form = layui.form;

        //监听
        form.on('select()', function(data){
            queryData();
        });
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
            ,format: 'yyyyMMdd'
            ,done: function(value, date, endDate){
                queryData();
            }
        });

        $("#test1").val('20190510');

        queryData();
    });

});


/*查询数据*/
function queryData() {
    // 获取参数
    var type = $("#type").val();
    var time = $("#test1").val();


    $.ajax({
        url: "/queryAnalysis.do",
        type: "get",
        data: {
            "type": type,
            "time": time
        },
        success: function (data) {
            var data1 = data.data.data1;
            var data2 = data.data.data2;
            var data3 = data.data.data3;
            var data4 = data.data.data4;

            initBar1(data1);
            initBar2(data2);
            initBar3(data3);
            initBar4(data4);

        },
        error: function (data) {
            console.log(data);
        }
    });
}



<!-- 1 浏览折线图 -->
function initBar1(data1) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main1'));

    // 模拟数据
    var xData = [];
    var yData = [];
    for (var i = 0; i < data1.length; i++) {
        var hourId = data1[i].hourId;
        var number = data1[i].number;

        xData.push(hourId);
        yData.push(number);
    }

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '浏览趋势图',
            textStyle: {
                color: '#1E9FFF',
                fontSize: 15
            }
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        xAxis: {
            type: 'category',
            data: xData
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: yData,
            type: 'line'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

<!-- 2 购买折现图 -->
function initBar2(data2) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main2'));

    // 模拟数据
    var xData = [];
    var yData = [];
    for (var i = 0; i < data2.length; i++) {
        var hourId = data2[i].hourId;
        var number = data2[i].number;

        xData.push(hourId);
        yData.push(number);
    }

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '购买趋势图',
            textStyle: {
                color: '#1E9FFF',
                fontSize: 15
            }
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        xAxis: {
            type: 'category',
            data: xData
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: yData,
            type: 'line'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

<!-- 3 浏览排行榜 -->
function initBar3(data3) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main3'));

    // 模拟数据
    var xData = [];
    var yData = [];
    for (var i = 0; i < data3.length; i++) {
        var goodName = data3[i].goodName;
        var number = data3[i].number;

        xData.push(number);
        yData.push(goodName);
    }


    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '浏览排行榜',
            textStyle: {
                color: '#1E9FFF',
                fontSize: 15
            }
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01]
        },
        yAxis: {
            type: 'category',
            data: yData
        },
        series: [{
            type: 'bar',
            data: xData,
            barWidth: '50%',
            itemStyle: {
                color: '#FF5722'
            }
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

<!-- 4 购买排行榜 -->
function initBar4(data4) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main4'));

    // 模拟数据
    var xData = [];
    var yData = [];
    for (var i = 0; i < data4.length; i++) {
        var goodName = data4[i].goodName;
        var number = data4[i].number;

        xData.push(number);
        yData.push(goodName);
    }

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '购买排行榜',
            textStyle: {
                color: '#1E9FFF',
                fontSize: 15
            }
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01]
        },
        yAxis: {
            type: 'category',
            data: yData
        },
        series: [{
            type: 'bar',
            data: xData,
            barWidth: '50%',
            itemStyle: {
                //color: ['#009688', '#5FB878', '#1E9FFF', '#FFB800', '#FF5722']
                color: '#009688'
            }
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

















