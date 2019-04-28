$(document).ready(function () {
    initBar();
});


function initBar() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

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

















