// page/htzx/result/result.js
var dt = {
  "illname": "牙痛",
  "us": [1613, 1615, 1617, 1618, 1619, 1621]
};
Page({

  /**
   * 页面的初始数据
   */
  data: {
    medicine:[],
    medicineName:[],
    sick:'',
    modalHidden:true,
    inde:0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var req = {"illname":options.sick, "us":[]};
    var datas = options.req.split(',')
    for (var i=0; i<datas.length; ++i)
      req.us.push(parseInt(datas[i]));
    //console.log(options)
    dt.illname = req.illname;
    dt.us = req.us
    wx.setNavigationBarTitle({
      title: '药物诊断结果'

    });
    wx.setNavigationBarColor({
      frontColor: '#ffffff',
      backgroundColor: '#855eef'
    });
    wx.request({
      url: 'https://www.wyzyschool.com/htzx/msmapper',      
      method: 'POST',
      headers:{
        "Content-Type": "application/json"  
      },
      data: dt,
      success: function (res) {
        
        for (var i=0; i<res.data.medicines.length; ++i){
          if (res.data.medicines[i]){
          if (res.data.medicines[i].effect)
            res.data.medicines[i].effect = res.data.medicines[i].effect.slice(0,200);
          else
            res.data.medicines[i].effect = '暂无';
        }
        
        }
        that.setData({
          medicine:res.data.medicines,
          //medicineName:res.data.medicines.medicine_name,
          sick:res.data.sickname
        });
      },
      fail:function(){
        
      }
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },

btn:function (e) {
  inde:e.detail.value
    this.setData({
      modalHidden:false
    })
},
modalCancel:function (e){
  this.setData({
    modalHidden:true
  })
},
bindPickerChange:function (e){
  console.log("picker发送选择改变")
  console.log(e.detail.value)
  this.setData({
    inde:e.detail.value
  })
}

  
})