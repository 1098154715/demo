package com.commons.util.commons.base.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.Map;

/**
 * @author cxk
 * @date 2021/3/16 14:19
 */
public class HttpUtils {
    public static String post(String url, Map<String,Object> paramMap,Integer count){
        String res=null;
        try {
             res = HttpRequest.post(url).form(paramMap).timeout(10000).execute().body();
             count=0;
        }catch (Exception e){
            if(count==5){
                System.out.println("超时连接失败："+paramMap);
                return null;
            }
            count++;
            post(url,paramMap,count);
        }


        return res;
    }
}
