package com.commons.util.commons.shop.api.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.commons.util.commons.shop.api.entity.enums.SexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author cxk
 * @since 2021-01-07
 */
@ApiModel(value="User对象", description="用户表")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String user_name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "枚举SexEnum")
    private SexEnum sex;


    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", user_name=" + user_name +
        ", password=" + password +
        ", create_time=" + create_time +
        ", update_time=" + update_time +
        ", sex=" + sex +
        "}";
    }
}
