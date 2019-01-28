var testurl = 'https://www.wyzyschool.com/htzx/symptoms';
var illname = {
  "erke": "儿科"
  , "neike": "内科"
  , "waike": "外科"
  , "fuchanke": "妇产科"
  , "wuguanke": "五官科"
  , "changjianjibing": "常见病"
};
var sick = '小儿肥胖';
var describe = "此为小儿肥胖的简介"
Page({

  /**
   * 页面的初始数据
   * mvn clean install
   */
  data: {
    datas: '',
  },


  makeRequest: function () {
    var self = this

    self.setData({
      loading: true
    })

    wx.request({
      url: testurl,
      data: {
        noncestr: Date.now()
      },
      success: function (result) {
        wx.showToast({
          title: '请求成功',
          icon: 'success',
          mask: true,
          duration: 100
        })

        self.setData({
          loading: false
        })
        console.log('request success', result)
      },

      fail: function ({ errMsg }) {
        console.log('request fail', errMsg)
        self.setData({
          loading: false
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //console.log(illname["futong"]);
    console.log(options.id);//获取url中的参数

    var that = this;
    wx.request({
      url: testurl,
      data: {
        "illname": options.sick
      },
      method: 'GET',
      success: function (res) {
        wx.showToast({
          title: '请求成功',
          icon: 'success',
          mask: true,
          duration: 100
        });
        that.setData({
          sick: options.sick,
          describe:res.data.describe
        });
      },
      fail: function ({ errMsg }) {
        console.log('request fail', errMsg)
        self.setData({
          loading: false
        })
      }
    })
  },
  
  probe: function (e) {
    var that = this;
    
      wx.redirectTo({
        url: '../../../page/htzx/qs/index?sick=' + that.data.sick,
        success: function (res) { },
        fail: function (res) { },
        complete: function (res) { },
      })
  
  }
})