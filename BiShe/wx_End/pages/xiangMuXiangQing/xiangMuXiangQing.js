// pages/xiangMuXiangQing/xiangMuXiangQing.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    jie_duan:''
  },
  shenQing(){
    if (this.data.userInfo.isDuiZhang==1 || this.data.userInfo.duiWu==0) {//保证是队长或者无队伍之人
      wx.request({
        url: 'http://localhost:9000/Mix/shenQing',
        data:{
          xiangMu_id:this.data.xiangMu.id,
          xiangMu_name:this.data.xiangMu.xiangMuMing,
          shenQingRen_id:this.data.userInfo.id,
          shenQingRen_name:this.data.userInfo.name,
          qiYe_id:this.data.qiye.id,
          qiYe_name:this.data.qiye.name,
        },
        method: 'GET',
        success: res => {
          if(res.data.code == "200"){
            // console.log(res);
            wx.showToast({
              title: '已提交申请',
            })
          }
        },
      })
    } else {
      wx.showToast({
        title: '请等待队长接取',
      })
    }
    
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.setData({
      xiangMu:wx.getStorageSync('danGeXiangMu'),
      userInfo:wx.getStorageSync('userInfo')
    })
    wx.request({
      url: 'http://localhost:9000/user/gengXingUser',
      data:{
        id:this.data.xiangMu.qiye_id
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          // console.log(res);
          this.setData({
            qiye:res.data.data
          })
        }
      },
    })
    switch(this.data.xiangMu.jie_duan) {
      case 0:
        this.setData({
          jie_duan:'可接取'
        })
        break;
      case 4:
        this.setData({
          jie_duan:'已结束'
        })
        break;
      default:
        this.setData({
          jie_duan:'已被接取'
        })
    }

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