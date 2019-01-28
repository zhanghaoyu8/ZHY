Page({
  data: {
    imgUrls: [
      '../../image/1.jpg',
      '../../image/2.jpg',
      '../../image/3.jpg',
      '../../image/4.jpg',
      '../../image/5.jpg',
      '../../image/6.jpg',
      '../../image/7.jpg',

    ],
    indicatorDots: false,
    vertical: false,
    autoplay: true,
    interval: 3000,
    duration: 1200,
    iconArray1: [
      {
        "iconUrl": '../../image/erke.png',
        "iconText": '儿科',
        "id": "erke"
      },
    ],
    iconArray3: [
      {
        "iconUrl": '../../image/neike.png',
        "iconText": '内科', "id": "neike"
      },
    ],
    iconArray4: [
      {
        "iconUrl": '../../image/waike.png',
        "iconText": '外科', "id": "waike"
      },
    ],
    iconArray2: [
      {
        "iconUrl": '../../image/fuchanke.png',
        "iconText": '妇产科', "id": "fuchanke"
      },
    ],
      iconArray5: [
       
        {
          "iconUrl": '../../image/wuguanke.png',
          "iconText": '五官科', "id": "wuguanke"
        },
    ],
      iconArray6: [
        {
          "iconUrl": '../../image/changjianjibing.png',
          "iconText": '常见病', "id": "changjianjibing"
        }
      ],
    list: [
      {
        id: 'ganmao',
        name: '感冒',
        open: false,
      }, {
        id: 'weitong',
        name: '胃痛',
        open: false,

      }, {
        id: 'bumei',
        name: '不寐',
        open: false,
      }, {
        id: 'futong',
        name: '腹痛',
        open: false,
      }, {
        id: 'fuxie',
        name: '腹泻',
        open: false,
      }
    ]
  },
  
  kindToggle: function (e) {
    var id = e.currentTarget.id, list = this.data.list;
    for (var i = 0, len = list.length; i < len; ++i) {
      if (list[i].id == id) {
        list[i].open = !list[i].open
      } else {
        list[i].open = false
      }
    }
    this.setData({
      list: list
    });
  },
  cusImageLoad: function (e) {
    var that = this;
    that.setData(WxAutoImage.wxAutoImageCal(e));
  }
})
