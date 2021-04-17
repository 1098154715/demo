package com.commons.util.commons.shop.api.util.gaode;





import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.commons.util.commons.base.util.HttpUtils;
import com.commons.util.commons.base.util.JsonUtils;
import com.commons.util.commons.shop.api.entity.utilEntity.Geocodes;
import com.commons.util.commons.shop.api.util.PropUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxk
 * @date 2020/11/19 16:25
 */
@Slf4j
public class GaoDeAddressUtil {
    /**
     * https://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&output=XML&key=<用户的key>
     * 根据详细地址获取省，市，区 字符串，如遇到直辖市，则在市中间加市辖区
     * @param address 详细地址
     */
    public static String getStringAddress(String address){
        String target=null;
        Map<String,Object> resp= new HashMap<>();
        try {
            HashMap<String,Object> map=new HashMap<>();
            map.put("address",address);
            map.put("output","JSON");
            map.put("key",PropUtils.GAODE_KEY);
            String s = HttpUtils.post(PropUtils.GAODE_URL_QUERYADDERSS, map,0);
            Map<String,Object> map1= JsonUtils.parseObject(s,Map.class);
            resp=((List<Map>)map1.get("geocodes")).get(0);
            target=resp.get("province")+","+resp.get("city")+","+resp.get("district");
             target= target.replace(",[]","");
        }catch (Exception e){
            log.error("地理编码查询报错");
        }
        return target;
    }

    /**
     * 根据地址获取当前地址信息
     * @param address
     * @return
     */
    public static  Geocodes getResult(String address){
        String target=null;
        if(address.length()>50){
            address=address.substring(0,50);
        }

        if(StringUtils.isEmpty(address)){
            return null;
        }
        Geocodes resp= null;
        try {
            HashMap<String,Object> map=new HashMap<>();
            map.put("address",address);
            map.put("output","JSON");
            map.put("key", PropUtils.GAODE_KEY);
            String s = HttpUtils.post(PropUtils.GAODE_URL_QUERYADDERSS, map,0);
            Map<String,Object> map1= JsonUtils.parseObject(s,Map.class);
            //resp=((List<Geocodes>)map1.get("geocodes")).get(0);
            resp=JSONObject.parseArray(map1.get("geocodes").toString(),Geocodes.class).get(0);
        }catch (Exception e){
            log.info("出错代码："+e.getMessage());
            log.error("地理编码查询报错");
        }
        return resp;
    }

    /**
     * https://restapi.amap.com/v3/geocode/regeo
     * 经纬度查询地理位置 （经度，纬度）log,lat
     * @param lng  经度
     * @param lat  纬度
     * @return
     */
    public static String getAddressLongitude(String lng,String lat){
            String location=lng+","+lat;
        return getAddressLongitudeString(location);
    }



    public static void main(String[] args) {
     String list=" and  fsjlfjls and ";
       list.replaceFirst("and","");
        System.out.println(list);
    }

    /**
     *  根据经纬度获取城市
     * @param location 经纬度：经度，纬度：例如 106，32
     * @return
     */
    public static String getAddressLongitudeString(String location) {
        String target=null;

        Map<String,Object> resp= new HashMap<>();
        try {
            HashMap<String,Object> map=new HashMap<>();
            map.put("location",location);
            map.put("output","JSON");
            map.put("key",PropUtils.GAODE_KEY);
            String s = HttpUtils.post(PropUtils.GAODE_URL_QUERYADDERSSBYLNGLAT, map,0);
            Map<String,Object> map1= (Map<String, Object>) JsonUtils.parseObject(s,Map.class).get("regeocode");
            resp= (Map<String, Object>) map1.get("addressComponent");
            String province =(String) resp.get("province");
            String  city =(String) resp.get("city");
            String district =(String) resp.get("district");
            target=province+","+city+","+district;

        }catch (Exception e){
            log.error("根据经纬度地理编码查询报错");
        }
        return target;
    }

    public static String getAddressByIp(String ip){
        String target=null;
        Map<String,Object> resp= new HashMap<>();
        try {
            HashMap<String,Object> map=new HashMap<>();
            map.put("ip",ip);
            map.put("output","JSON");
            map.put("key",PropUtils.GAODE_KEY);
            String s = HttpUtils.post("https://restapi.amap.com/v3/ip", map,0);
            Map<String,Object> map1= JsonUtils.parseObject(s,Map.class);
            target=map1.get("province")+","+map1.get("city");
            if(map1.get("province")=="[]"){
                target=null;
            }

        }catch (Exception e){
            log.error("地理编码查询报错");
        }
        return target;
    }
}
