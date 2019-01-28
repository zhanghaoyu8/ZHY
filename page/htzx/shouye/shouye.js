/* page/htzx/shouye/shouye.js */

Page({
  data:{
    moda: 'scaleToFill',
    src: '/image/shouye.jpg'
  },


  onLoad: function () {
    console.log('onLoad')
    //console.log(options.major)
    
    
    this.setData({
      
    })
    //console.log(this.data)
  },
  imageError: function (e) {
    console.log('image3发生error事件，携带值为', e.detail.errMsg)
  },







st:function(e){
  console.log('同意了免责声明')
  wx.switchTab({
    url: '/page/htzx/index',
   
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