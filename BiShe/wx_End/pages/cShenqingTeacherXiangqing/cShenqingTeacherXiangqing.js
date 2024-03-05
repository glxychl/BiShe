// pages/cShenqingTeacherXiangqing/cShenqingTeacherXiangqing.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    duiwu:''
  },

  tongYi(){
     if (this.data.duiwu=="有队伍") {
      wx.request({
        url: 'http://localhost:9000/DuiWu/duiwuJiequChengong',
        data:{
          id:this.data.userInfo.id,
          xiangMu_id:this.data.xiangmu.id
        },
        method: 'GET',
        success: res => {
          if(res.data.code == "200"){
            console.log("队伍接取成功");
          }
        },
      })
     }
     wx.request({
      url: 'http://localhost:9000/Mix/acceptShenqing',
      data:{
        xiangMu_id:this.data.xiangmu.id,
        beiTongZhiRen_id:this.data.userInfo.id,
        beiTongZhiRen_name:this.data.userInfo.name,
        tongZhiRen_id:this.data.userInfoQiye.id,
        tongZhiRen_name:this.data.userInfoQiye.name,
        xiangMuMing:this.data.xiangmu.xiangMuMing
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '已同意',
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
    wx.request({
      url: 'http://localhost:9000/user/gengXingUser',
      data:{
        id:this.data.shenqingTeacher.shenQingRen_id,
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
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
        }
      },
    })
  }
})