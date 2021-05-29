package com.hotstrip.code.design.adapter.bad;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.adapter.base.model.OrderMQ;

/**
 * @author hotstrip
 * 内部订单 service
 */
public class OrderMQService {

    /**
     * 内部订单业务
     * @param message
     */
    public void onMessage(final String message) {
        OrderMQ orderMQ = JSON.parseObject(message, OrderMQ.class);
        orderMQ.getUid();
        orderMQ.getOrderId();
        // 处理自己的业务
    }
}
