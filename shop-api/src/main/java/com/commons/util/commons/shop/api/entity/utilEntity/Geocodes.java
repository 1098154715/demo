package com.commons.util.commons.shop.api.entity.utilEntity;

import lombok.Data;

/**
 * 高德实体参数
 * @author cxk
 * @date 2021/3/26 15:15
 */
@Data
public class Geocodes {
    /**
     * 详细地址
     */
    private String formatted_address;
    /**
     * 国家
     */
    private String country;
    /**
     * 地址所在的省份名
     */
    private String province;
    /**
     * 地址所在的城市名
     */
    private String city;
    /**
     * 城市编码
     */
    private String citycode;
    /**
     * 地址所在的区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 门牌
     */
    private String number;
    /**
     * 区域编码
     */
    private String adcode;
    /**
     * 坐标点(经度，纬度)
     */
    private String location;
}
