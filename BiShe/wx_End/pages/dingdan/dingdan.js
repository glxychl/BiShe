// pages/dingdan/dingdan.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  jieduan1To2(){
    wx.request({
      url: 'http://localhost:9000/Mix/jieduan1To2',
      data:{
        id:this.data.xiangmu.id,
        id1:this.data.xiangmu.duizhang_id,
        id2:this.data.xiangmu.qiye_id,
        xiangMuMing:this.data.xiangmu.xiangMuMing
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '合同已签署',
          })
        }
      },
    })
  },

  jieduan2To3(){
    wx.request({
      url: 'http://localhost:9000/Mix/jieduan2To3',
      data:{
        id:this.data.xiangmu.id,
        id1:this.data.xiangmu.duizhang_id,
        id2:this.data.xiangmu.qiye_id,
        xiangMuMing:this.data.xiangmu.xiangMuMing
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '合同已完成',
          })
        }
      },
    })
  },

  jieduan3To4(){
    if (this.data.userInfo.isDuiZhang==1) {
      wx.request({
        url: 'http://localhost:9000/DuiWu/duiwuEndXiangmu',
        data:{
          duizhang_id:this.data.xiangmu.duizhang_id
        },
        method: 'GET',
        success: res => {
          if(res.data.code == "200"){
            console.log("队伍请空项目成功");
          }
        },
      })
     }
     wx.request({
      url: 'http://localhost:9000/Mix/jieduan3To4',
      data:{
        xiangmuId:this.data.xiangmu.id,
        qiYeId:this.data.xiangmu.qiye_id,
        teacherId:this.data.xiangmu.duizhang_id,
        xiangMuMing:this.data.xiangmu.xiangMuMing,
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '已全部结束',
          })
        }
      },
    })
  },

  onShow(){
    this.setData({
      userInfo: wx.getStorageSync('userInfo'),
    })
    wx.request({
      url: 'http://localhost:9000/XiangMu/findXiangmuById',
      data:{
        id:this.data.userInfo.xiangMu_id
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            xiangmu:res.data.data
          })
          switch(res.data.data.jie_duan) {
            case 0:
              this.setData({
                jie_duan:'待接取'
              })
              break;
            case 1:
              this.setData({
                jie_duan:'待合同签署'
              })
              break;
            case 2:
              this.setData({
                jie_duan:'合作中'
              })
              break;
            case 3:
              this.setData({
                jie_duan:'待资金资金结算'
              })
              break;
            case 4:
              this.setData({
                jie_duan:'已结束'
              })
              break;
            default:
              this.setData({
                jie_duan:'错误'
              })
          }
        }
      },
    })
  }
})