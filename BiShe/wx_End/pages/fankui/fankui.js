Page({

  data: {

  },
  jumpFankuiPingtai:function(){
    wx.navigateTo({
     url: '../fankuiPingtai/fankuiPingtai',
    })
  },

  jumpFankuiXiangmu:function(e){
    var index = e.currentTarget.dataset.index;//获取鼠标点击的index
    var item = this.data.xiangmu[index];
    wx.setStorageSync('fanKui', item);
    wx.navigateTo({
      url: '../fankuiXiangmu/fankuiXiangmu',
    })
  },

  onShow(){
    this.setData({
      userInfo: wx.getStorageSync('userInfo'),
    })
    wx.request({
      url: 'http://localhost:9000/XiangMu/getXiangMuNameByDuizhangId',
      data:{
        duizhang_id:this.data.userInfo.id,
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