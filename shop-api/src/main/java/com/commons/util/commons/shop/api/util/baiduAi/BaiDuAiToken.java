package com.commons.util.commons.shop.api.util.baiduAi;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cxk
 * @date 2021/4/15 16:22
 */
@Data
public class BaiDuAiToken implements Serializable {
   private  String refresh_token;
   private  String expires_in;
   private  String scope;
   private  String session_key;
   private  String access_token;

}
