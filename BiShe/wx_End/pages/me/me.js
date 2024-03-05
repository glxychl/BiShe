// pages/me/me.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:{},
    userRole:'',
    isCompany:false,
    isTeacher:false
  },
  jumplogin:function(){
    wx.navigateTo({
     url: '../login/login',
    })
  },
  jumpMessage:function(){
    wx.navigateTo({
     url: '../message/message',
    })
  },
  jumpFankui:function(){
    wx.navigateTo({
     url: '../fankui/fankui',
    })
  },
  jumpTongji:function(){
    wx.navigateTo({
     url: '../tongji/tongji',
    })
  },
  jumpLuruqy:function(){
    wx.navigateTo({
     url: '../luruqy/luruqy',
    })
  },
  jumpXuqiu:function(){
    wx.navigateTo({
     url: '../xuqiu/xuqiu',
    })
  },
  jumpLuru:function(){
    wx.navigateTo({
     url: '../luru/luru',
    })
  },
  jumpZudui:function(){
    wx.navigateTo({
     url: '../zudui/zudui',
    })
  },
  jumpDingdan:function(){
    wx.navigateTo({
     url: '../dingdan/dingdan',
    })
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.setData({
      userInfo: wx.getStorageSync('userInfo'),
    })
    var userRole = this.data.userInfo.role;
    if (userRole == '1') {
      this.setData({
        isCompany:true,
        isTeacher:false
      });
    } else if (userRole == '2'){
      this.setData({
        isTeacher:true,
        isCompany:false
      })
    }
  },
  
  onShow() {
    this.setData({
      userInfo: wx.getStorageSync('userInfo'),
    })
    var userRole = this.data.userInfo.role;
    if (userRole == '1') {
      this.setData({
        isCompany:true,
        isTeacher:false
      });
    } else if (userRole == '2'){
      this.setData({
        isTeacher:true,
        isCompany:false
      })
    }
    wx.request({
      url: 'http://localhost:9000/TongZhi/tongZhi',
      data:{
        beiTongZhiRen_id:this.data.userInfo.id,
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          if (res.data.data!=0) {
            wx.showToast({
              title: '您有未查看的通知',
              icon:'none'
            })
          }
        }
      },
    })
  },
})