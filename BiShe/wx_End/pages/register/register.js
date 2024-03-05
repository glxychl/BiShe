// pages/register/register.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    account:'',
    pwd:'',
    pwd2:'',
    safe:'',
    checked: false,
    role:'1'
  },

  getAccount(e){
    this.setData({
        account: e.detail.value
    })
  },
  getPwd(e){
    this.setData({
        pwd: e.detail.value
    })
  },
  getPwd2(e){
    this.setData({
        pwd2: e.detail.value
    })
  },
  getSafe(e){
    this.setData({
        safe: e.detail.value
    })
  },
  register(){
    if(!this.data.account || !this.data.pwd || !this.data.pwd2 || !this.data.safe){
      wx.showToast({
        title: '参数不能为空！',
        icon: 'error'
      })
      return;
    }
    if(this.data.pwd != this.data.pwd2){
      wx.showToast({
        title: '两次密码不同！',
        icon: 'error'
      })
      return;
    }
    wx.showLoading({
      title: '注册中',
    })
    wx.request({
      url: 'http://localhost:9000/user/register',
      data: {
        role:'1',
        username:this.data.account,
        password:this.data.pwd,
        safe:this.data.safe,
      },
      header: {
        'content-type': 'application/json' 
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          wx.switchTab({
            url: '/pages/me/me',
          })
        }else if(res.data.code == "502"){
          wx.showToast({
            title: '该用户名已注册！',
            icon: 'error'
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
