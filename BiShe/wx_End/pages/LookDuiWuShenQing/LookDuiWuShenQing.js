// pages/LookDuiWuShenQing/LookDuiWuShenQing.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  tongYi(){
    wx.request({
      url: 'http://localhost:9000/user/tongYiShenQingToUser',
      data:{
        duiWuId:this.data.duiWu.id,
        id:this.data.userInfo.id
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            duiWu:res.data.data
          })
        }else{
          wx.showToast({
            title: '服务出错！',
            icon: 'error'
          })
        }
      },
      fail: res=>{
        wx.showToast({
          title: '连接超时！',
          icon: 'error'
        })
      }
    })
    wx.request({
      url: 'http://localhost:9000/DuiWu/tongYiShenQingToDuiwu',
      data:{
        duiWuId:this.data.duiWu.id,
        shu_liang:this.data.duiWu.shu_liang
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '已同意',
          })
        }else{
          wx.showToast({
            title: '服务出错！',
            icon: 'error'
          })
        }
      },
      fail: res=>{
        wx.showToast({
          title: '连接超时！',
          icon: 'error'
        })
      }
    })
  },

  juJue(){
    wx.request({
      url: 'http://localhost:9000/DuiWu/juJueShenQingToDuiWu',
      data:{
        duiWuId:this.data.duiWu.id,
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '已拒绝',
            icon:'icon'
          })
        }else{
          wx.showToast({
            title: '服务出错！',
            icon: 'error'
          })
        }
      },
      fail: res=>{
        wx.showToast({
          title: '连接超时！',
          icon: 'error'
        })
      }
    })
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    this.setData({
      shenQingRenId:wx.getStorageSync('shenQingRenId'),
      duiWu:wx.getStorageSync('danGeDuiWu')
    })
    wx.request({
      url: 'http://localhost:9000/user/gengXingUser',
      data:{
        id:this.data.shenQingRenId
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            userInfo:res.data.data
          })
        }else{
          wx.showToast({
            title: '服务出错！',
            icon: 'error'
          })
        }
      },
      fail: res=>{
        wx.showToast({
          title: '连接超时！',
          icon: 'error'
        })
      }
    })
   
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})