package com.hotstrip.code.design.adapter.good.service.impl;

import com.hotstrip.code.design.adapter.base.service.OrderService;
import com.hotstrip.code.design.adapter.good.service.OrderAdapterService;

/**
 * @author hotstrip
 * 内部订单 service 适配器
 */
public class InsideOrderAdapterServiceImpl implements OrderAdapterService {
    private OrderService orderService = new OrderService();
    @Override
    public boolean isFirst(final String userId) {
        return orderService.queryUserOrderCount(userId) <= 1;
    }
}
