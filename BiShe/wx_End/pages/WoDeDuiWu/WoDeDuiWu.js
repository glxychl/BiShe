// pages/WoDeDuiWu/WoDeDuiWu.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isDuiZhang:''
  },

  jumpLookDuiWuShenQing(){
    if (this.data.duiWu.shenQing!=null) {
      wx.setStorageSync('shenQingRenId', this.data.duiWu.shenQing)
      wx.navigateTo({
        url: '../LookDuiWuShenQing/LookDuiWuShenQing',
      })
    } else {
      wx.showToast({
        title: '当前暂无申请',
        icon:'none'
      })
    }
  },

  jieSanDuiWu(){
    wx.request({
      url: 'http://localhost:9000/DuiWu/jieSanDuiWuToDuiWu',
      data:{
        id:this.data.userInfo.duiWu
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
          wx.setStorageSync('danGeDuiWu', res.data.data)
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
      url: 'http://localhost:9000/user/jieSanDuiWuToUser',
      data:{
        duiWu:this.data.userInfo.duiWu
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '解散成功',
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

  tuiChuDuiWu(){
    wx.request({
      url: 'http://localhost:9000/DuiWu/tuiChuDuiWuToDuiWu',
      data:{
        duiWuId:this.data.userInfo.duiWu,
        shu_liang:this.data.duiWu.shu_liang
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){

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
      url: 'http://localhost:9000/user/tuiChuDuiWuToUser',
      data:{
        id:this.data.userInfo.id
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.showToast({
            title: '退出成功',
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
      userInfo:wx.getStorageSync('userInfo'),
    })
    wx.request({
      url: 'http://localhost:9000/DuiWu/getDuiWuInfo',
      data:{
        duiWuId:this.data.userInfo.duiWu
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
          wx.setStorageSync('danGeDuiWu', res.data.data)
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
      url: 'http://localhost:9000/user/getDuiZhangInfo',
      data:{
        duiWu:this.data.userInfo.duiWu
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            duiZhang:res.data.data,
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
      url: 'http://localhost:9000/user/getDuiYuanInfo',
      data:{
        duiWu:this.data.userInfo.duiWu
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            duiYuan:res.data.data
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
    console.log(this.data.duiWu);
    wx.request({
      url: 'http://localhost:9000/XiangMu/getXiangMuName',
      data:{
        duizhang_id:this.data.userInfo.id
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            xiangMuMing:res.data.data
          })
        }
      },
    })
    this.setData({
      isDuiZhang:this.data.userInfo.isDuiZhang
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