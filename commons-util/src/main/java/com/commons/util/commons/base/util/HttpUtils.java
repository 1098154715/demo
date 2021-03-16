package com.commons.util.commons.base.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.Map;

/**
 * @author cxk
 * @date 2021/3/16 14:19
 */
public class HttpUtils {
    public static String post(String url, Map<String,Object> paramMap){
        String res = HttpRequest.post(url).form(paramMap).execute().body();

        return res;
    }
}
