package com.hotstrip.code.design.adapter.good.service;

/**
 * @author hotstrip
 * 统一订单适配器接口
 */
public interface OrderAdapterService {

    /**
     * 是否是第一个
     * @param userId
     * @return
     */
    boolean isFirst(final String userId);
}
