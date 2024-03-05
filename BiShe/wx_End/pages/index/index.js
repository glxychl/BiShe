// index.js
const app = getApp()
Page({
  data: {
    userInfo:{},
    userRole:'',
    isCompany:false,
    isTeacher:false
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

  jumpXiangMuXiangQing:function(e){
    var index = e.currentTarget.dataset.index;//获取鼠标点击的index
    var item = this.data.xiangMu[index];
    wx.setStorageSync('danGeXiangMu', item)
    wx.navigateTo({
      url: '../xiangMuXiangQing/xiangMuXiangQing',
    })
  },
  onLoad(options) {

  },
  onShow(options){
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
    if (this.data.userInfo.isDuiZhang == 1) {
      wx.request({
        url: 'http://localhost:9000/DuiWu/haveShenQing',
        data:{
          duiWuId:this.data.userInfo.duiWu
        },
        method: 'GET',
        success: res => {
          if(res.data.code == "200"){
            if (res.data.data!=null) {
              wx.showToast({
                title: '您的队伍有一条申请',
                icon:'none'
              })
            }
          }
        },
      })
    }
    wx.request({
      url: 'http://localhost:9000/XiangMu/findAllXiangMu',
      data:{
        zhuan_ye:this.data.userInfo.zhuan_ye,
        shan_chang:this.data.userInfo.shan_chang,
        bu_shanchang:this.data.userInfo.bu_shanchang
      },
      method: 'GET',
      success: res => {
        if(res.data.code == "200"){
          this.setData({
            xiangMu:res.data.data
          })
        }
      },
    })
  }
})
