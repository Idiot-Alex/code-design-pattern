package com.hotstrip.code.design.adapter.base.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class POPOrderService {

    /**
     * 查询用户订单是否是首单
     * @param userId
     * @return
     */
    public boolean isFirstOrder(final String userId) {
        log.info("POP 商家，查询用户的订单是否为首单：{}", userId);
        return true;
    }
}
