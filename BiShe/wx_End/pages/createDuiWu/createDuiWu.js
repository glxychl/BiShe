// pages/createDuiWu/createDuiWu.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    formData: {},
    userInfo: {},
  },
  submitForm: function(e) {
    var formData = e.detail.value;
    // console.log(formData);
    this.setData({
      userInfo: wx.getStorageSync('userInfo'),
    })
    // console.log(this.data.userInfo.id);
    wx.request({
      url: 'http://localhost:9000/DuiWu/createDuiWu',
      method: 'GET',
      data: {
        duiwuName: formData.duiwuName,
        zhuan_ye: formData.zhuan_ye,
        shan_chang: formData.shan_chang,
        jian_jie: formData.jian_jie,
        duizhang_id: this.data.userInfo.id
      },
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '创建成功',
          })
        }else{
          wx.showToast({
            title: '服务出错！',
            icon: 'error'
          })
        }
      }
    })
    wx.request({
      url: 'http://localhost:9000/user/gengXingUser',
      data:{
        id:this.data.userInfo.id
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.setStorageSync('userInfo', res.data.data)
          console.log(res);
          console.log("更新userInfo成功");
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
      url: 'http://localhost:9000/DuiWu/findAllDuiwu',
      data:{
        zhuan_ye:this.data.userInfo.zhuan_ye,
        shan_chang:this.data.userInfo.shan_chang,
        bu_shanchang:this.data.userInfo.bu_shanchang
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.setStorageSync('duiwuInfo', res.data.data)
          console.log(res);
          console.log("更新duiwuInfo成功");
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