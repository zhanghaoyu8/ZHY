package com.upc.controller;

import com.upc.service.AliPayService;
import com.upc.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AliPayController {
  private static final Logger logger = LoggerFactory.getLogger(AliPayController.class);
  @Autowired
  AliPayService aliPayService;

  /**
   * 获取订单详情
   * @return
   */
  @RequestMapping(value="/orderinfo",method = {RequestMethod.GET,RequestMethod.POST})
  @ResponseBody
  public String getOrderInfo(){
    logger.info("getting orders ...");
    String orderInfo = aliPayService.getOrderInfo();
    if(orderInfo !=null && orderInfo.length()!=0){
      logger.info(orderInfo);
      return orderInfo;
    }
    return "getOrderInfoError";
  }
}
