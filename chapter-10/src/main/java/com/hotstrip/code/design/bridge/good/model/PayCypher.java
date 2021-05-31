package com.hotstrip.code.design.bridge.good.model;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * 密码支付模式
 */
@Slf4j
public class PayCypher implements IPayMode {

    @Override
    public boolean security(String userId) {
        log.info("密码支付，风控校验环境安全");
        return true;
    }
}
