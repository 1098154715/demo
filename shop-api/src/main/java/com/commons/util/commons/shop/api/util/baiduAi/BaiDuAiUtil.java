package com.commons.util.commons.shop.api.util.baiduAi;

import com.alibaba.druid.util.StringUtils;
import com.commons.util.commons.base.util.HttpUtils;
import com.commons.util.commons.base.util.JsonUtils;
import com.commons.util.commons.shop.api.util.PropUtils;
import com.commons.util.commons.shop.api.util.redis.RedisUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxk
 * @date 2021/4/15 15:10
 */
public class BaiDuAiUtil {

    public static final  String getTokenUrl="https://aip.baidubce.com/oauth/2.0/token";

    /**
     * 获取token
     * @return
     */
    public String getToken(RedisUtils redisUtils){

        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("grant_type","client_credentials");
        paramMap.put("client_id",PropUtils.BAIDUAI_APIKEY);
        paramMap.put("client_secret",PropUtils.BAIDUAI_SECRETKEY);
        String resString = HttpUtils.post(getTokenUrl, paramMap, 2000);
        if(!StringUtils.isEmpty(resString)){
            BaiDuAiToken baiDuAiToken= JsonUtils.parseObject(resString,BaiDuAiToken.class);
            if(baiDuAiToken!=null){

                return baiDuAiToken.getAccess_token();
            }


        }
        return null;
    }


}
