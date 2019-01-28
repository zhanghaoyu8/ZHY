// page/htzx/sickness/sickness.js
var illnessName = {
  '妇产科': {
    'ins': '气之根，肾中真阳也；血之根，肾中真阳也',
    'img': 'majorImg/fuchanke.png', 
    'value': [
      "月经过少",
      "月经后期",
      "月经先期",
      "月经过多",
      "月经先后不定期",
      "外阴瘙痒",
      "妊娠肿胀",
      "经期延长",
      "经行头痛",
      "卵巢功能早衰",
      "经行泄泻",
      "妊娠小便淋痛(尿道炎、膀胱炎)",
      "经行乳房胀痛",
      "经行发热",
      "经间期出血（排卵期出血）",
      "更年期综合征",
      "黄褐斑",
      "闭经",
      "产后缺乳",
      "产后小便不通（产后尿潴留）",
      "崩漏（无排卵性功能性子宫出血）",
      "痛经",
    ]},
  '儿科': { 
    'ins': '气之根，肾中真阳也；血之根，肾中真阳也', 
  'img': 'majorImg/erke.png', 
  'value': [
  "小儿喘息",
  "小儿发热",
  "小儿便秘",
  //"小儿发热",
  "小儿肥胖",
  "小儿腹泻",
  "小儿感冒",
  "小儿咳嗽",
  "小儿湿疹",
  "小儿厌食",
  ] },
'五官科': {
  'ins': '气之根，肾中真阳也；血之根，肾中真阳也',
  'img':'majorImg/wuguanke.png', 
  'value': [
    "耳鸣耳聋",
    "赤眼（急性结膜炎）",
    "唇风（慢性唇炎、继发感染性唇炎）",
    "耳眩晕（美尼尔综合征）",
    "流泪症（泪溢症）",
    "伤风鼻塞（急性鼻炎）",
    "牙痛",
    "喉痹（急、慢性咽炎）",
    "针眼（麦粒肿）",
    "鼻渊（鼻窦炎）",
    "鼻衄",
  ] },
  '内科': { 
    'ins': '气之根，肾中真阳也；血之根，肾中真阳也', 
  'img': 'majorImg/neike.png', 
  'value': [
    "痹证（关节炎）",
    "水肿",
    "胃痛",
    "癃闭（尿潴留、小便不通）",
    "心悸（心律失常、神经官能症）",
    "便秘",
    "喘证（支气管炎、哮喘等）",
    "胸痹（冠心病、心绞痛）",
    "泄泻（腹泻）",
    "汗证（植物神经功能紊乱）",
    "腰痛",
    "咳嗽",
    "遗尿",
    "眩晕",
    "郁证（神经衰弱、癔症、焦虑症）",
    "中风（脑梗塞、脑栓塞）",
    "淋证（急慢性尿路感染，尿道综合征）",
    "感冒",
    "头痛",
    "不寐（失眠）",
  ] },
  '外科': { 
    'ins': '气之根，肾中真阳也；血之根，肾中真阳也', 
    'img': 'majorImg/waike.png', 
    'value': [
      "粉刺",
      "乳核（乳腺纤维瘤）",
      "乳疬（乳房异常发育症）",
      "乳癖（乳腺囊性增生病）",
      "乳岩（乳腺癌）",
      "乳痈（急性化脓性乳腺炎）",
      "褥疮（压疮、压力性溃疡）",
      "痔疮",
      "斑秃",
      "牛皮癣",
      "颈椎病",
      "肩周炎"
    ] },
  '常见病': {
    'ins': '气之根，肾中真阳也；血之根，肾中真阳也',
    'img': 'majorImg/changjianjibing.png',
    'value': [
      "咳嗽",
      "感冒",
      "头痛",
      "便秘",
      "不寐（失眠）",
      "小儿腹泻",
      "小儿感冒",
      "小儿咳嗽",
    ]
  },
}
Page({

  /**
   * 页面的初始数据
   */
  data: {
    illnessName: [],
    ins: '',
    major: '2131231',
    img:'',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //console.log(illnessName)
    //console.log(options.major)
    wx.setNavigationBarTitle({
      title:''
      
    })
    wx.setNavigationBarColor({
      frontColor:'#ffffff',
      backgroundColor:'#855eef'
    })
    this.setData({
      illnessName: illnessName[options.major]['value'],
      ins: illnessName[options.major]['ins'],
      major: options.major,
      img: illnessName[options.major]['img']
    })
    //console.log(this.data)
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