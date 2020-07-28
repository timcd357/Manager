
var myChart = echarts.init(document.getElementById('main'));

var mainFirstoption = {
    /*dataZoom: [
        {   // 这个dataZoom组件，默认控制x轴。
            type: 'slider', // 这个 dataZoom 组件是 slider 型 dataZoom 组件
            start: 10,      // 左边在 10% 的位置。
            end: 60         // 右边在 60% 的位置。
        },
        {   // 这个dataZoom组件，也控制x轴。
            type: 'inside', // 这个 dataZoom 组件是 inside 型 dataZoom 组件
            start: 10,      // 左边在 10% 的位置。
            end: 60         // 右边在 60% 的位置。
        }
    ],*/
    toolbox: {
        show: true,
        orient: "vertical",
        feature: {
            dataZoom: {
                yAxisIndex: "none"
            },
            dataView: {
                readOnly: false
            },
            magicType: {
                type: ['line', 'bar', 'stack', 'tiled']
            },
            restore: {},
            saveAsImage: {}
        },
        showTitle: true
    },
    title: {
        text: '产品数量单价图'
    },
    dataset: {
        dimensions: ['itemname', 'num', 'price'],
        source: []
    },
    tooltip: {},
    legend: {
        data: ['数量','价格']
    },
    xAxis: {
        type: 'category',
        axisLabel: {
            rotate: 45
        }
    },
    yAxis: {},
    series: [{
        name:'数量',
        type: 'bar',
    },{
        name: '价格',
        type: 'line',
        symbolSize:10,
        connectNulls:true,
        itemStyle:{
            // shadowColor: 'rgba(0, 0, 0, 0.5)',
            // shadowBlur: 10,
            // borderWidth: 10
        },
        lineStyle:{
            width:0
        },
        markPoint: {
            data: [{
                type: "max"
            }],
            symbol: "pin"
        }
    }]
};

function variableOption() {
    //title的值
    // console.log($("#title").val())
    //
    var option =

        /*{
        color:['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83',  '#ca8622', '#bda29a','#6e7074', '#546570', '#c4ccd3'],
        textStyle: {
          color:'#000000',
          fontStyle:'normal',
          fontWeight:'normal',
          fontFamily:'sans-serif',
          fontSize:12
        },
        title:{
            text:$("#title").val(),
            textStyle:{
                fontStyle:'normal',
                fontSize:16
            }
        },
        toolbox: {
          show:true,
          orient:'horizontal'
        },
        brush: {
            xAxisIndex: 'all',
            brushLink: 'all',
            outOfBrush: {
                colorAlpha: 0.1
            }
        },
        legend:{
            show:true,
            itemGap:10,
            itemStyle: {
                fontStyle: 'normal',
                fontSize: 12
            }
        },
        grid:{
            show:false
        },
        xAxis: {
            show:true,
            // gridIndex:1,
            position:'bottom',
            type: 'category',
            // name:'x轴',
            nameLocation:'end',
            nameTextStyle:{
                fontStyle:'normal',
                fontSize:12
            },
            axisTick:{
                show:true,
                alignWithLabel:true,
                interval:'auto',
                inside:false,
            },
            axisLabel: {
                show:true,
                interval:'auto',
                inside:false,
                rotate: 0,
                fontStyle:'normal',
                fontSize:12,
                align:'auto'
            },
            axisPointer:{
                show:false
            }
        },
        yAxis: {
            show:true,
            // gridIndex:1,
            position:'bottom',
            // name:'',
            nameTextStyle:{
                fontStyle:'normal',
                fontsize:12
            },
            axisTick:{
                show:true,
                alignWithLabel:true,
                interval:'auto',
                inside:false,
            },
            axisLabel: {
                show:true,
                // interval:'auto',
                inside:false,
                rotate: 0,
                fontStyle:'normal',
                fontsize:12,
                // align:'auto'
            },
            axisPointer:{
                show:false
            }
        },
        series: [{
            name:'数量',
            type: 'bar',
        },{
            name: '价格',
            type: 'line',
            symbolSize:10,
            connectNulls:true,
            itemStyle:{
            },
            lineStyle:{
                width:0
            },
            markPoint: {
                data: [{
                    type: "max"
                }],
                symbol: "pin"
            }
        }]
    }*/
    option=$.extend({}, mainFirstoption, option)
    // console.log(option);
    myChart.setOption(option);
}

