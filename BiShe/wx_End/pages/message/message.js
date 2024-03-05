// pages/message/message.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  isread(){
    wx.request({
      url: 'http://localhost:9000/TongZhi/allRead',
      data: {
        beiTongZhiRen_id:this.data.userInfo.id
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '全部已读成功',
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
      userInfo:wx.getStorageSync('userInfo')
    })
    wx.request({
      url: 'http://localhost:9000/TongZhi/noRead',
      data:{
        beiTongZhiRen_id:this.data.userInfo.id,
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            noRead:res.data.data
          })
        }
      },
    })
    wx.request({
      url: 'http://localhost:9000/TongZhi/read',
      data:{
        beiTongZhiRen_id:this.data.userInfo.id,
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            isRead:res.data.data
          })
        }
      },
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