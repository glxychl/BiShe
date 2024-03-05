// pages/chengjieRenXingxi/chengjieRenXingxi.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  onShow(){
    this.setData({
      xiangmu:wx.getStorageSync('cXiangmu')
    })
    wx.request({
      url: 'http://localhost:9000/user/gengXingUser',
      data:{
        id:this.data.xiangmu.duizhang_id,
      },
      method: 'GET',
      success: res => {
        this.setData({
          userInfo:res.data.data
        })
        if (res.data.data.duiWu==0) {
          this.setData({
            duiwu:"单人"
          })
        } else {
          this.setData({
            duiwu:"有队伍"
          })
        }
      },
    })
  }
})