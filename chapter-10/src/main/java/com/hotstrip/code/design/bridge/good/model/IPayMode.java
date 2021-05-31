package com.hotstrip.code.design.bridge.good.model;

/**
 * @author hotstrip
 * 支付的模式，比如密码支付、人脸支付、指纹支付
 */
public interface IPayMode {

    /**
     * 安全校验
     * @param userId
     * @return
     */
    boolean security(final String userId);
}
