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
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Test1pensioninstitutions对象", description="")
public class Test1pensioninstitutions implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "机构名称")
    private String name;

    private String creatTime;

    @ApiModelProperty(value = "床位数")
    private String bedNum;

    @ApiModelProperty(value = "占地面积")
    private String landOccupation;

    private String scopeOfBusiness;

    @ApiModelProperty(value = "收费区间")
    private String chargeArea;

    @ApiModelProperty(value = "员工人数")
    private String staffNum;

    @ApiModelProperty(value = "经营性质")
    private String managementType;

    @ApiModelProperty(value = "机构类型")
    private String organizationType;

    @ApiModelProperty(value = "机构介绍")
    private String content;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    private String tel;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "电子邮件")
    private String email;

    @ApiModelProperty(value = "邮政编码")
    private String zipCode;

    @ApiModelProperty(value = "所属区域")
    @TableField("addrArea")
    private String addrarea;

    @ApiModelProperty(value = "详细地址")
    private String contactAddress;

    @ApiModelProperty(value = "交通信息")
    private String trafficInfo;

    @ApiModelProperty(value = "经纬度")
    private String addrPoint;

    @ApiModelProperty(value = "简介")
    private String remarks;

    @ApiModelProperty(value = "消防设施")
    private String fireProtectionFacilities;

    @TableField("GDlng")
    private String gdlng;

    @TableField("GDlat")
    private String gdlat;

    @ApiModelProperty(value = "行政区划")
    private Long administrativedivision;

    @ApiModelProperty(value = "公司logo")
    private String logoPath;

    @TableField("isSettled")
    private Integer issettled;

    @TableField("InvitationTimes")
    private Integer invitationtimes;

    @ApiModelProperty(value = "兜底保障人数")
    private Integer minimumGuarantees;

    @ApiModelProperty(value = "备注")
    private String remark;


}
