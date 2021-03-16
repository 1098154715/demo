package com.commons.util.commons.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author cxk
 * @date 2021/3/16 14:28
 */
public class JsonUtils {

    public static <T> T parseObject(String s,Class<T> cls) {
        return JSONObject.parseObject(s,cls);

    }
}
