package com.upc.common;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class WxpayParam {


    /** 微信支付的金额是String类型 并且是以分为单位
     * 下面举个例子单位是元是怎么转为分的
     * */
    BigDecimal totalPrice  = new BigDecimal(1); //此时的单位是元

    private String body = "诊断费用信息";
    private String totalFee = totalPrice.multiply(new BigDecimal(1)).toBigInteger().toString();
    /** 随机数字字符串*/
    Random random = new Random();
    int x = random.nextInt(100000)+100000000;
    String str = String.valueOf(x);
    Date time = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    private String outTradeNo = df.format(time)+str;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
}