package com.commons.util.commons.shop.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxk
 * @since 2021-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Pension对象", description="")
public class Pension implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String address;

    private String phone;

    private String contents;

    private String bedNum;

    private String type;

    private String orgType;

    private String area;

    private String createTime;

    private String tel;

    private String totalArea;

    private String ground;

    private String chargSection;

    @TableField("workPerson")
    private String workperson;

    private String descion;

    private String email;

    private String postalCode;

    private String trafficInfo;

    private String point;

    private String descion2;

    private String facilities;

    private String log;

    private String lat;

    private String logoPath;

    @TableField("isSettled")
    private String issettled;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
