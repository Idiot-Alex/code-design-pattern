package com.hotstrip.code.design.bridge.good.model;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hotstrip
 * 人脸支付模式
 */
@Slf4j
public class PayFaceMode implements IPayMode {

    @Override
    public boolean security(String userId) {
        log.info("人脸支付，风控校验脸部识别");
        return true;
    }
}
