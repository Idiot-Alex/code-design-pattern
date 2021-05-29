package com.hotstrip.code.design.adapter.base.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * 内部订单 service
 */
@Slf4j
public class OrderService {

    /**
     * 查询用户内部订单数量
     * @param userId
     * @return
     */
    public long queryUserOrderCount(final String userId) {
        log.info("内部商家，查询用户的下单数量：{}", userId);
        return 10L;
    }
}
