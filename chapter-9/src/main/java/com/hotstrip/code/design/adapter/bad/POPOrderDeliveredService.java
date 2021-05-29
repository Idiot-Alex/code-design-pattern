package com.hotstrip.code.design.adapter.bad;

import com.alibaba.fastjson.JSON;
import com.hotstrip.code.design.adapter.base.model.POPOrderDelivered;

/**
 * @author hotstrip
 * 商家订单 service
 */
public class POPOrderDeliveredService {

    /**
     * 商家订单业务
     * @param message
     */
    public void onMessage(final String message) {
        POPOrderDelivered popOrderDelivered = JSON.parseObject(message, POPOrderDelivered.class);
        popOrderDelivered.getUId();
        popOrderDelivered.getOrderId();
        // 处理自己业务
    }
}
