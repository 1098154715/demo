package com.commons.util.commons.shop.api.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author cxk
 * @date 2020/12/31 15:17
 */
@Component
public class PropUtils implements InitializingBean {
    @Value("${ali.file.AccessKey.ID}")
    private String AccessKeyId;
    @Value("${ali.file.AccessKey.Secret}")
    private String AccessKeySecret;
    @Value("${ali.file.AccessKey.BucketName}")
    private String BucketName;
    @Value("${ali.file.AccessKey.Endpoint}")
    private String Endpoint;
    @Value("${server.ali.AppKey}")
    private String aliAppKey;

    @Value("${gaode.key}")
    private String gaodeKey;
    @Value("${gaode.url.queryAdderss}")
    private String gaodeUrlQueryAdderss;
    @Value("${gaode.url.queryAdderssbylngLat}")
    private String gaodeUrlQueryAdderssbylngLat;

    @Value("${baiduAi.AppID}")
    private String baiduAiAppID;
    @Value("${baiduAi.APIKey}")
    private String baiduAiAPIKey;
    @Value("${baiduAi.Secret}")
    private String baiduAiSecretKey;

   public static  String ACCESSKEY_ID;
   public static  String ACCESSKEY_SECRET;
   public static  String ACCESSKEY_BUCKETNAME;
   public static  String ACCESSKEY_ENDPOINT;
    public static  String ALI_APPKEY;
    public static  String GAODE_KEY;
   public static  String GAODE_URL_QUERYADDERSS;
   public static  String GAODE_URL_QUERYADDERSSBYLNGLAT;
   public static  String BAIDUAI_APPID;
   public static  String BAIDUAI_APIKEY;
   public static  String BAIDUAI_SECRETKEY;


    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESSKEY_ID=AccessKeyId;
        ACCESSKEY_SECRET=AccessKeySecret;
        ACCESSKEY_BUCKETNAME=BucketName;
        ACCESSKEY_ENDPOINT=Endpoint;
        ALI_APPKEY=aliAppKey;
        GAODE_KEY=gaodeKey;
        GAODE_URL_QUERYADDERSS=gaodeUrlQueryAdderss;
        GAODE_URL_QUERYADDERSSBYLNGLAT=gaodeUrlQueryAdderssbylngLat;
        BAIDUAI_APPID=baiduAiAppID;
        BAIDUAI_APIKEY=baiduAiAPIKey;
        BAIDUAI_SECRETKEY=baiduAiSecretKey;
    }
}
