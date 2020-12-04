package com.itguigu.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单
 * <p>Table name:tb_order</p>
 * <p>Create time:2020-08-20 13:47:24</p>
 *
 * @author Ljun
 */
@Data
public class Order implements Serializable {
    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 数据来源id
     */
    private String dataId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 买家名称
     */
    private String buyerName;

    /**
     * 买家联系方式
     */
    private String contact;

    /**
     * 订单摘要
     */
    private String subject;

    /**
     * 订单金额
     */
    private BigDecimal orderMoney;

    /**
     * 优惠金额
     */
    private BigDecimal districtMoney;

    /**
     * 支付金额
     */
    private BigDecimal paymentMoney;

    /**
     * 收货省
     */
    private String receivingProvince;

    /**
     * 收货-市
     */
    private String receivingCity;

    /**
     * 收货区
     */
    private String receivingArea;

    /**
     * 收货详细地址
     */
    private String receivingAddress;

    /**
     * 创建地址
     */
    private LocalDateTime createTime;

    /**
     * 支付时间
     */
    private LocalDateTime paymentTime;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 评价时间
     */
    private LocalDateTime evaluationTime;

    /**
     * 完成时间
     */
    private LocalDateTime completionTime;

    /**
     * 逻辑删除标识
     */
    private Integer markDelete;

    /**
     * 物流单号
     */
    private String logisticsNo;

    /**
     * 物流公司
     */
    private String logisticsCompany;

    /**
     * 接单人员名称
     */
    private String orderReceiverName;

    /**
     * 接单人员id
     */
    private String orderReceiverId;

    /**
     * 接单人员联系方式
     */
    private String orderReceiverContact;

    /**
     * 签收时间
     */
    private LocalDateTime signTime;


}