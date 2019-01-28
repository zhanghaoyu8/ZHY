Page({
  data: {
    src:'https://www.wyzyschool.com/shipin.mp4',
  },
  videoErrorCallcack:function(e){
    console.log('视频错误信息：')
    console.log(e.detail.errMsg)
  }
})

