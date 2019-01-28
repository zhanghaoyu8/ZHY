package com.upc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.upc.common.OurWxPayConfig;
import com.upc.common.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @RequestMapping(path = {"/wxLogin"},method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JSONObject getOpenId(String code){
        OurWxPayConfig ourWxPayConfig = new OurWxPayConfig(false);
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String,String> data = new HashMap<String,String>();
        data.put("appid",ourWxPayConfig.getAppID());
        data.put("secret","0d9f217abe53ca2551a1399de1c43235");
        data.put("js_code",code);
        data.put("grant_type","authorization_code");
        //data.put("openid",ourWxPayConfig.get)
        //System.out.println(code);
        JSONObject jsonObject = JSON.parseObject(RequestUtil.sendPost(url, data));
        return jsonObject;
    }
}
