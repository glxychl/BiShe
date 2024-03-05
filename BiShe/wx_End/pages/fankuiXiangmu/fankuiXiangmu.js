// pages/fankuiXiangmu/fankuiXiangmu.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    fanKui:''
  },

  getFankui(e){
    this.setData({
      fanKui:e.detail.value
    })
  },

  tiJiao(){
    wx.request({
      url: 'http://localhost:9000/fanKui/fankuiXiangmu',
      data:{
        xiangMu_id:this.data.xiangmu.id,
        xiangMu_name:this.data.xiangmu.xiangMuMing,
        fanKuiRen_id:this.data.userInfo.id,
        fanKuiRen_name:this.data.userInfo.name,
        fanKui:this.data.fanKui
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '提交成功',
          })
        }
      },
    })
  },
  onShow() {
    this.setData({
      userInfo: wx.getStorageSync('userInfo'),
      xiangmu:wx.getStorageSync('fanKui')
    })
  },
})