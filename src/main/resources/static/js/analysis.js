$(document).ready(function () {

    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
            ,value: new Date(1534766888000)
        });
    });

    initBar1();
    initBar2();
    initBar3();
    initBar4();
});

<!-- 1 浏览折线图 -->
function initBar1() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main1'));

    // 模拟数据
    var xData = [];
    var yData = [];
    for (var i = 0; i < 100; i++) {
        xData.push(i);
        yData.push(200 + Math.random() * 21 - 10);
    }

    // 指定图表的配置项和数据
    var option = {
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
function initBar2() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main2'));

    // 模拟数据
    var xData = [];
    var yData = [];
    for (var i = 0; i < 100; i++) {
        xData.push(i);
        yData.push(200 + Math.random() * 21 - 10);
    }

    // 指定图表的配置项和数据
    var option = {
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
function initBar3() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main3'));

    // 模拟数据
    var xData = [];
    var yData = [];
    for (var i = 0; i < 20; i++) {
        xData.push(i);
        yData.push(200 + Math.random() * 21 - 10);
    }

    // 指定图表的配置项和数据
    var option = {
        xAxis: {
            type: 'category',
            data: xData
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: yData,
            type: 'bar'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

<!-- 4 购买排行榜 -->
function initBar4() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main4'));

    // 模拟数据
    var xData = [];
    var yData = [];
    for (var i = 0; i < 20; i++) {
        xData.push(i);
        yData.push(200 + Math.random() * 21 - 10);
    }

    // 指定图表的配置项和数据
    var option = {
        xAxis: {
            type: 'category',
            data: xData
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: yData,
            type: 'bar'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

















