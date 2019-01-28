var testurl = 'https://www.wyzyschool.com/htzx/symptoms';
var illname ={"erke":"儿科"
,"neike":"内科"
,"waike":"外科"
,"fuchanke":"妇产科"
,"wuguanke":"五官科"
,"changjianjibing":"常见病"};
Page({

  /**
   * 页面的初始数据
   * mvn clean install
   */
  data:{
    datas: '',
    us:[],/*所选的选项*/
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
      url:testurl,
      data:{ 
      "illname":options.sick
      },
      method:'GET',
      success: function (result) {
        wx.showToast({
          title: '请求成功',
          icon: 'success',
          mask: true,
          duration: 100
        });
        that.setData({
          datas: result.data
        });
        //此处先将调查结果设置为全都没有症状
        for (var i=0; i<result.data.length; ++i){
            that.data.us.push(0);
          
        }
        /*for (var i = 0; i<result.data.datas.length; ++i) {
          if (result.data.datas[i].sdPerformance[0] == '无') {
            console.log("aaa");
            const a = that.data.datas[i].sdPerformance[0];
            that.data.datas[i].sdPerformance[0]= that.data.datas[i].sdPerformance[1];
            that.data.datas[i].sdPerformance[1]=a;
            const b = that.data.datas[i].sdId[0];
            that.data.datas[i].sdId[0] = that.data.datas[i].sdId[1];
            that.data.datas[i].sdId[1] = b;
            that.setData({
              sdPerformance:that.data.datas[i].sdPerformance,
              sdId:that.data.datas[i].sdId
            })
          }
        }*/
        console.log(that.data.us)
        that.setData({
          sick:options.sick,
          results:that.data.us
        });//设置截止
        //console.log(result);
        //console.log('request success', result)
        //console.log(that.data.datas)
      },
      fail: function ({ errMsg }) {
        console.log('request fail', errMsg)
        self.setData({
          loading: false
        })
      }
    })
  },
  //此处监听radio的变换变化后替换相应位置的病症参数
  radioChange: function (e) {
    this.data.us[e.target.id/*以id作为下标*/] = parseInt(e.detail.value/*获取group的值*/);
    console.log(this.data.us)
    this.setData({
      results:this.data.us
    })
    console.log(this.data.results)
  },
  probe:function(e){
    var that = this;
        var flag = 1;
        var a=[0];
        for (var i=0; i<this.data.results.length; ++i){
          if (this.data.results[i] == 0 && this.data.datas[i].sdPerformance.length != 0)
          {
            flag = 0;
            a[i]=i+1;
          }
          else
          {
            a[i]=0;
          }
        }
        if (flag == 1){
          wx.redirectTo({
            url: '../../../page/htzx/middle/middle?req='+that.data.results+'&sick='+that.data.sick,
            success: function(res) {},
            fail: function(res) {},
            complete: function(res) {},
          })
        }
        else{
          var str = '您有选项未选择!未选择的项编号为：';
          for (var i = 0; i < this.data.results.length; ++i) {
            if (a[i]!=0) {
              str=str+a[i]+" ";
            }
          }
          wx.showModal({
            title: '提示',
            showCancel:false,
            content: str
          });
        }

  }
})