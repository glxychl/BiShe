//引入echarts
import * as echarts from '../../ec-canvas/echarts';

Page({
    data: {
    ecage: {
      onInit: function (canvas, width, height, dpr) {
        const AgeChart = echarts.init(canvas, null, {
          width: width,
          height: height,
          devicePixelRatio: dpr // new
        });
        canvas.setChart(AgeChart);
        AgeChart.setOption(getBarOption());
        return AgeChart;
      }
    },
    ecage2: {
      onInit: function (canvas, width, height, dpr) {
        const AgeChart = echarts.init(canvas, null, {
          width: width,
          height: height,
          devicePixelRatio: dpr // new
        });
        canvas.setChart(AgeChart);
        AgeChart.setOption(getBarOption2());
        return AgeChart;
      }
    },
    xiangmu:[]
    },
//可以在方法请求中改变lineops数据

  onShow(){
    wx.request({
      url: 'http://localhost:9000/XiangMu/findXiangmuListWithZhuanye',
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.setStorageSync('Tu', res.data.data)
        }
      },
    })

    wx.request({
      url: 'http://localhost:9000/user/findUserListWithZhuanye',
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.setStorageSync('Tu2', res.data.data)
        }
      },
    })
  }
})

var Tu = wx.getStorageSync('Tu')
var Tu2 = wx.getStorageSync('Tu2')

function getBarOption() {
  return {
    legend: {
      bottom: 10,
      left: 'center'
    },
    series: [{
      type: 'pie',
      radius: ['30', '60%'],
      clockwise: false,
      center: ['50%', '40%'],
      labelLine: {
        smooth: true
      },
      label: {
        formatter: '{b}: {d}%'
      },
      itemStyle: {
        color: function (params) {
          let colorList = [
            ['#FFBBA8', '#FF3E3E'],
            ['#766EF9', '#FF9CF3'],
            ['#7DB6EE', '#90ECC7'],
            ['#FFE18F', '#FF9C62'],
          ]
          let index = params.dataIndex
          if (params.dataIndex >= colorList.length) {
            index = params.dataIndex - colorList.length
          }
          return new echarts.graphic.LinearGradient(0, 0, 0, 1,
            [{
              offset: 0,
              color: colorList[index][0]
            },
            {
              offset: 1,
              color: colorList[index][1]
            }
            ])
        }
      },
      data: Tu,
      },
    ]
  }
}
function getBarOption2() {
  return {
    legend: {
      bottom: 10,
      left: 'center'
    },
    series: [{
      type: 'pie',
      radius: ['30', '60%'],
      clockwise: false,
      center: ['50%', '40%'],
      labelLine: {
        smooth: true
      },
      label: {
        formatter: '{b}: {d}%'
      },
      itemStyle: {
        color: function (params) {
          let colorList = [
            ['#FFBBA8', '#FF3E3E'],
            ['#766EF9', '#FF9CF3'],
            ['#7DB6EE', '#90ECC7'],
            ['#FFE18F', '#FF9C62'],
          ]
          let index = params.dataIndex
          if (params.dataIndex >= colorList.length) {
            index = params.dataIndex - colorList.length
          }
          return new echarts.graphic.LinearGradient(0, 0, 0, 1,
            [{
              offset: 0,
              color: colorList[index][0]
            },
            {
              offset: 1,
              color: colorList[index][1]
            }
            ])
        }
      },
      data: Tu2,
      },
    ]
  }
}