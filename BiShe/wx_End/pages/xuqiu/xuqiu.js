// pages/xuqiu/xuqiu.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    formData: {},
    userInfo: {},
  },
  bindDateChange: function(e) {
    // console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      date: e.detail.value
    })
  },
  bindTimeChange: function(e) {
    // console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      time: e.detail.value
    })
  },
  submitForm: function(e) {
    var end_shijian = this.data.date+" "+this.data.time+":00";
    // console.log(end_shijian);
    var formData = e.detail.value;
    // console.log(formData);
    this.setData({
      userInfo: wx.getStorageSync('userInfo'),
    })
    // console.log(this.data.userInfo.id);
    wx.request({
      url: 'http://localhost:9000/XiangMu/xuQiuSend',
      method: 'GET',
      data: {
        xiangMuMing: formData.xiangMuMing,
        zhuan_ye: formData.zhuan_ye,
        shan_chang: formData.shan_chang,
        xiang_qing: formData.xiang_qing,
        qiye_id: this.data.userInfo.id,
        str_end_shijian: end_shijian,
      },
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '录入成功',
          })
          setTimeout(function () {
            wx.switchTab({
              url: '/pages/me/me',
            })
           }, 300)
        }else{
          wx.showToast({
            title: '服务出错！',
            icon: 'error'
          })
        }
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