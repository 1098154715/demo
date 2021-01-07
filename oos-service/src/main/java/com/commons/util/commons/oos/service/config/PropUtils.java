package com.commons.util.commons.oos.service.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
   public static  String ACCESSKEY_ID;
   public static  String ACCESSKEY_SECRET;
   public static  String ACCESSKEY_BUCKETNAME;
   public static  String ACCESSKEY_ENDPOINT;
   public static  String ALI_APPKEY;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESSKEY_ID=AccessKeyId;
        ACCESSKEY_SECRET=AccessKeySecret;
        ACCESSKEY_BUCKETNAME=BucketName;
        ACCESSKEY_ENDPOINT=Endpoint;
        ALI_APPKEY=aliAppKey;
    }
}
