// pages/zudui/zudui.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    zhuan_ye:"",
    shan_chang:"",
    bu_shanchang:"",
    duiwu: {}
  },
  jumpWoDeDuiWu:function(){
    if (this.data.userInfo.duiWu == 0) {
      wx.showToast({
        title: '您未有队伍，请先加入或创建队伍',
        icon:'none'
      })
    } else {
      wx.navigateTo({
        url: '../WoDeDuiWu/WoDeDuiWu',
      })
    }
  },
  jumpCreateDuiWu:function(){
    // console.log(this.data.userInfo);
    if (this.data.userInfo.duiWu != 0) {
      wx.showToast({
        title: '您已有队伍，请先退出或解散队伍',
        icon:'none'
      })
    } else {
      wx.navigateTo({
        url: '../createDuiWu/createDuiWu',
      })
    }
  },
  jumpDuiWuXiangQing:function(e){
    var index = e.currentTarget.dataset.index;//获取鼠标点击的index
    var item = this.data.duiwu[index];
    console.log(item);
    wx.setStorageSync('danGeDuiWu', item)
    wx.navigateTo({
      url: '../duiwuXiangqing/duiwuXiangqing',
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
      userInfo: wx.getStorageSync('userInfo'),
    })
    wx.request({
      url: 'http://localhost:9000/DuiWu/findAllDuiwu',
      data:{
        zhuan_ye:this.data.userInfo.zhuan_ye,
        shan_chang:this.data.userInfo.shan_chang,
        bu_shanchang:this.data.userInfo.bu_shanchang
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          // console.log(res);
          this.setData({
            duiwu:res.data.data
          })
          wx.setStorageSync('duiwuInfo', res.data.data)
        }
      },
    })
    wx.request({
      url: 'http://localhost:9000/user/gengXingUser',
      data:{
        id:this.data.userInfo.id
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.setStorageSync('userInfo', res.data.data)
          this.setData({
            userInfo:res.data.data
          })
        }
      },
    })
    console.log("运行onShow,获取队伍");
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