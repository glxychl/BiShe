// pages/cooperation/cooperation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  jumpXiangmu:function(e){
    var index = e.currentTarget.dataset.index;//获取鼠标点击的index
    var item = this.data.xiangmu[index];
    wx.setStorageSync('cXiangmu', item);
    wx.navigateTo({
      url: '../cQiyeXiangmuXiangQing/cQiyeXiangmuXiangQing',
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

  onShow(){
    this.setData({
      userInfo: wx.getStorageSync('userInfo'),
    })
    wx.request({
      url: 'http://localhost:9000/XiangMu/getXiangMuByQiyeId',
      data:{
        qiye_id:this.data.userInfo.id,
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            xiangmu:res.data.data
          })
        }
      },
    })
  }
})