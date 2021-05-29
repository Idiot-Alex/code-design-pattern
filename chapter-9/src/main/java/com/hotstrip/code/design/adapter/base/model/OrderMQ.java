package com.hotstrip.code.design.adapter.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hotstrip
 * 内部订单 MQ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMQ {
    // 用户 ID
    private String uid;
    // 商品编号
    private String sku;
    // 订单 ID
    private String orderId;
    // 下单时间
    private Date createOrderTime;
}
