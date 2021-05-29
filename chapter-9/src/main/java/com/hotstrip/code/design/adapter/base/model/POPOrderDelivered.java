package com.hotstrip.code.design.adapter.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hotstrip
 * 第三方订单 MQ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class POPOrderDelivered {
    // 用户 ID
    private String uId;
    // 订单号
    private String orderId;
    // 下单时间
    private Date orderTime;
    // 商品编号
    private String sku;
    // 商品名称
    private String skuName;
    // 商品金额
    private BigDecimal decimal;
}
