// pages/duiwuXiangqing/dingdanXiangqing.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  shenQing(){
    if (this.data.userInfo.duiWu != 0) {
      wx.showToast({
        title: '您已有队伍，请先退出或解散队伍',
        icon:'none'
      })
    } else {
      if (this.data.duiWu.shenQing==null) {
        wx.request({
          url: 'http://localhost:9000/DuiWu/shenQingRuDui',
          data:{
            id:this.data.userInfo.id,
            duiWuId:this.data.duiWu.id
          },
          method: 'GET',
          success: res => {
            if(res.data.code == "200"){
              wx.showToast({
                title: '申请成功',
              })
            }
          },
        })
      } else {
        wx.showToast({
          title: '此队伍暂时不能申请',
        })
      }
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.setData({
      duiWu: wx.getStorageSync('danGeDuiWu'),
      userInfo: wx.getStorageSync('userInfo')
    })
    // console.log(this.data.duiWu);
    //获取队长信息
    wx.request({
      url: 'http://localhost:9000/user/gengXingUser',
      data:{
        id:this.data.duiWu.duizhang_id
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          // console.log(res);
          this.setData({
            duiZhang:res.data.data
          })
        }
      },
    })
    wx.request({
      url: 'http://localhost:9000/XiangMu/getXiangMuName',
      data:{
        duizhang_id:this.data.duiWu.duizhang_id
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          // console.log(res);
          this.setData({
            xiangMuMing:res.data.data
          })
        }
      },
    })
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