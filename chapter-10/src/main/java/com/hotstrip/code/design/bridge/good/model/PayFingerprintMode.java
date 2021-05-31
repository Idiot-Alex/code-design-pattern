package com.hotstrip.code.design.bridge.good.model;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * 指纹支付模式
 */
@Slf4j
public class PayFingerprintMode implements IPayMode {

    @Override
    public boolean security(String userId) {
        log.info("指纹支付，风控校验指纹信息");
        return true;
    }
}
