/* page/htzx/middle/middle.js */
var o1 = [];
var o2 = '';
var dt = {
  "illname": "牙痛",
  "us": [1613, 1615, 1617, 1618, 1619, 1621]
};
Page({
  data: {
    sick: '',
    modalHidden: true,
    inde: 0
  },


  onLoad: function (options) {
    var that = this;
    o1 = options.req;
    o2 = options.sick;
    var req = { "illname": options.sick, "us": [] };
    var datas = options.req.split(',')
    for (var i = 0; i < datas.length; ++i)
      req.us.push(parseInt(datas[i]));
    //console.log(options)
    dt.illname = req.illname;
    dt.us = req.us
    wx.setNavigationBarTitle({
      title: '诊断结果'

    });
    wx.setNavigationBarColor({
      frontColor: '#ffffff',
      backgroundColor: '#855eef'
    });
    wx.request({
      url: 'https://www.wyzyschool.com/htzx/msmapper',
      method: 'POST',
      headers: {
        "Content-Type": "application/json"
      },
      data: dt,
      success: function (res) {
        that.setData({
          sick: res.data.sickname
        });
      },
      fail: function () {

      }
    });
  },






  st1: function (e) {
    console.log('访问对应外治法的申请')
    wx.navigateTo({
      url: '/page/htzx/outsideoperation/outsideoperation?req=' + o1 + '&sick=' + o2,

    })
  },

  st2: function (e) {
    console.log('访问对应药物疗法的申请')
    wx.navigateTo({
      url: '/page/htzx/result/result?req=' + o1 + '&sick=' + o2,

    })
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

  }



})