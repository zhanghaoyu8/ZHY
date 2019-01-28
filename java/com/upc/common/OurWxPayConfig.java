package com.upc.common;



import com.github.wxpay.sdk.WXPayConfig;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/** 配置我们自己的信息  */

public class OurWxPayConfig implements WXPayConfig {

    /** 加载证书  这里证书需要到微信商户平台进行下载*/
    private byte [] certData;

    public OurWxPayConfig() throws  Exception{
        InputStream certStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cert/wxpay/apiclient_cert.p12");
        this.certData = IOUtils.toByteArray(certStream);
        certStream.close();
    }
    public OurWxPayConfig(Boolean b){

    }

    /** 设置我们自己的appid
     * 商户号
     * 秘钥
     * */

    @Override
    public String getAppID() {
        return "wx28c117f224301396";//设置appid(written by duke)
    }

    @Override
    public String getMchID() {
        return "1503963151";//商户号(written by duke)
    }

    @Override
    public String getKey() {
        return "9381shizhangwanyideshizhangwanyi";//秘钥(written by duke)
    }

    @Override
    public InputStream getCertStream() {
        return new ByteArrayInputStream(this.certData);
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 0;
    }
}
