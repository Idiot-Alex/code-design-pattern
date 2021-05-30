package com.hotstrip.code.design.adapter.good.service.impl;

import com.hotstrip.code.design.adapter.base.model.POPOrderDelivered;
import com.hotstrip.code.design.adapter.base.service.POPOrderService;
import com.hotstrip.code.design.adapter.good.service.OrderAdapterService;

/**
 * @author hotstrip
 * POP 商家订单适配器
 */
public class POPOrderAdapterServiceImpl implements OrderAdapterService {
    private POPOrderService popOrderService = new POPOrderService();
    @Override
    public boolean isFirst(final String userId) {
        return popOrderService.isFirstOrder(userId);
    }
}
