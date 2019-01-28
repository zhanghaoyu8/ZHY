package com.upc.service;

import com.upc.util.OrderInfoUtil2_0;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AliPayService {
  // 支付宝支付业务：入参app_id
  //sandbox:2016091500517790
  public static final String APPID = "2018050960104173";
  //支付宝账户登录授权业务：入参pid值
  public static final String PID = "2088131163716252";
  //商户私钥
  public static final String RSA2_PRIVATE="MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCyrhkXkwo0Kgdk79hA1/Ia/n2xma1TOslZshVw1N7FxRTe05LWD27UDa1iLSMQ0AX9YDg0mLG4pjbqmdgZx+OD01fAG6bZ92/7I04ho0yfeCVovg+ifjmwnowdytl0qClXGsoiOVqnCaxHXvZkMpSVPjWJeDifcmNAPxPbCZny3+LGfE6gv9zChkns7BryJW0ZCTW/H3Lw9iDjJhDBuKSNkE1u2pHq8Ni2rCftXnBHU1pDD5ppBbgOvkuP50qQgPe2jLyc5LRTrgiwHqg8tKcWRoS+O4pD5h8ukdiLvP0f8S4tKv79UF8gi0mrfjhnDco8n3ZWhBDoqHM9zsPqjwGBAgMBAAECggEBAJTyKfqL2Rqo2mcaxFMxcCFueYrdxy01OPlrSRI4cMe9xOsGxUVpsgJUsG7Bn5R5RDT1y4SUsLly3R5tRkYfaZnPSDvdERZrfE6GHLBPtyTL+6s3nELhI+gGElkXanQjZeq1a0BiPR43IwSPtabKvy81n11L+S95JCE/M6cIduuMrny5QTiVrF6Q5D/vqYpY2i2/6L72rKJrJnk3J86w+tea7ZwibcdXqPFKkSXauztazDbOefj2Q2e+ooKP70/58EzziSPrxUNESDDsAvT0ohBkWMHfvbkVvm1CmH9+wx7AANDw4Fwfp70/GpNWIH0cLA0ij5BifB4oW/O/MO9x0QECgYEA58p2t6oDEqJHPiTsfahbK62RApWvjD1GzomMLzApr0uWshM469DSK8uo5c71o6kcpNc+yxgT72QMfi8fkXv7Ta/2GFSwq+l3IDhKMYIL9f0UMe9SFvMrEqLkmDc/NiaBbVkcagg9YUj+0vJB34dog9iiqL87Eau9BylklvnBsRECgYEAxVeT6tf73PUzGP3pQV4w5RbLG00qcCL99l36w4She+If0e9vwyMwmReDXJVP5cbTtbyqFfz3QV99LqFKPzi4XX6ofrGRag+u85Pdf7n0CtW8N5wZddK7UrV2Kftu1xKwUGcIx3oXKHYjHnYERVPHqiYoY4ruwuhYQO913SdySXECgYEA4cgoCBPFVntYZkJVUrmRxWQWYqwoCbUOqdT2Bmkl0akRq3hp89q/PwXtCZ2lTLxIOJGqiu5zTLbqLGf+mhpo2m3SjDTCu1J5RZtPOhZxTDYvW8zA67YGeOrPPS5jln2/iSJKOUa5c3BFOHnejLw7pGJ7X2CXS0k8oiNB5oZ2k+ECgYEAlTxinxGQ5YsEhlzWPdnWThjLpizX8A92UQ7HKX6uhDn/6EoTEdYV1WBjteswjcqrpd80HQa9kVF+IHpW5LKnMgUrtQvhtPyBSLDEq+fbNypleQRyeJjRkn2qC5uaOclnTpZsnDWnN7EHY+zJ1AfEkdbjakvRvdHpk8nDL2i6U/ECgYEAupFJIqx/m6o9ORt0Oius+PNeZkBtE3i3ifdguhr0+EFTadzRdz8PoY+P+XwmiKHkRUmNLojALgU+KQFjakYjYluEdvL1lZv2w7u5u/XoLn6T/D+Ew/OofrQntpa919yxeJ+sO5w75Jd6PtnUduE7HOo1GfqfUsaPN4WPkKl1f+A=";

  private static final int SDK_PAY_FLAG = 1;
  private static final int SDK_AUTH_FLAG = 2;

  public String getOrderInfo(){

    boolean rsa2 = true;
    //进入此函数可设置商品的参数和价格
    Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
    String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

    String privateKey = RSA2_PRIVATE;
    String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
    final String orderInfo = orderParam + "&" + sign;

    return orderInfo;
  }

}
