// pages/cTuijianTeacherXiangqing/cTuijianTeacherXiangqing.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  yaoqing(){
    wx.request({
      url: 'http://localhost:9000/TongZhi/yaoQingTeacher',
      data:{
        beiTongZhiRen_id:this.data.shenqingTeacher.id,
        beiTongZhiRen_name:this.data.shenqingTeacher.name,
        tongZhiRen_id:this.data.userInfoQiye.id,
        tongZhiRen_name:this.data.userInfoQiye.name,
        xiangMuMing:this.data.xiangmu.xiangMuMing
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '信息已发送',
          })
        }
      },
    })
  },

  onShow(){
    this.setData({
      shenqingTeacher: wx.getStorageSync('shenqingTeacher'),
      xiangmu:wx.getStorageSync('cXiangmu'),
      userInfoQiye:wx.getStorageSync('userInfo')
    })
    if (this.data.shenqingTeacher.duiWu==0) {
      this.setData({
        duiwu:"单人"
      })
    } else {
      this.setData({
        duiwu:"有队伍"
      })
    }
  }
})