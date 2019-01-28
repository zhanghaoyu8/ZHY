package com.upc.controller;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.upc.common.OurWxPayConfig;
import com.upc.common.WxpayParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WeixinPayController {

    @RequestMapping(path = {"/WxPay"},method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String,String> wxPayFunction(String openid/*调用下个界面所需参数*/) throws Exception{

        WxpayParam wxpayParam = new WxpayParam();
        String notifyUrl = "https://www.wyzyschool.com";  //回调地址
        //System.out.println(openid);
        OurWxPayConfig ourWxPayConfig = new OurWxPayConfig();
        WXPay wxPay = new WXPay(ourWxPayConfig);

        //根据微信支付api来设置
        Map<String,String> data = new HashMap<>();
        data.put("appid",ourWxPayConfig.getAppID());
        data.put("mch_id",ourWxPayConfig.getMchID());
        data.put("body",wxpayParam.getBody());
        data.put("device_info","001");
        data.put("nonce_str","bfrhncjkfdkfd");   // 随机字符串小于32位
        String s = WXPayUtil.generateSignature(data, ourWxPayConfig.getKey());  //签名//商户号
        data.put("trade_type","JSAPI");                         //支付场景 APP 微信app支付 JSAPI 公众号支付  NATIVE 扫码支付
        data.put("notify_url",notifyUrl);                     //回调地址
        data.put("spbill_create_ip","127.0.0.1");             //终端ip
        data.put("total_fee","1");       //订单总金额（单位：分）
        data.put("fee_type","CNY");                           //默认人民币
        data.put("out_trade_no",wxpayParam.getOutTradeNo());   //交易号
        data.put("body",wxpayParam.getBody());
        data.put("sign",s);
        data.put("openid",openid);

        /** wxPay.unifiedOrder 这个方法中调用微信统一下单接口 */
        Map<String, String> respData = wxPay.unifiedOrder(data);
        if (respData.get("return_code").equals("SUCCESS")){
            //返回给APP端的参数，APP端再调起支付接口
            Map<String,String> repData = new HashMap<>();
            repData.put("appId",ourWxPayConfig.getAppID());
            repData.put("nonceStr",respData.get("nonce_str"));
            //repData.put("partnerid",ourWxPayConfig.getMchID());
            repData.put("package","prepay_id="+respData.get("prepay_id"));
            repData.put("signType","MD5");
            repData.put("timeStamp",String.valueOf(System.currentTimeMillis()/1000));
            //repData.put("key",ourWxPayConfig.getKey());
            String sign = WXPayUtil.generateSignature(repData,ourWxPayConfig.getKey()); //签名
            respData.put("timestamp",repData.get("timeStamp"));
            respData.put("package",sign);
            return respData;
        }

        throw new Exception(respData.get("return_msg"));
    }
}

