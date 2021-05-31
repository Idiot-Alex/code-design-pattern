package com.hotstrip.code.design.bridge.good.channel;

import com.hotstrip.code.design.bridge.good.model.IPayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 微信支付
 */
@Slf4j
public class WxPay extends Pay {

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String userId, String tradeId, BigDecimal amount) {
        log.info("模拟微信渠道支付划账开始。userId：{}，tradeID：{}，amount：{}", userId, tradeId, amount);
        boolean security = payMode.security(userId);
        log.info("模拟微信渠道支付风控校验，userId：{}，tradeId：{}，security：{}", userId, tradeId, security);
        if (!security) {
            log.info("模拟微信渠道支付划账拦截，userId：{}，tradeID：{}，amount：{}", userId, tradeId, amount);
            return "0001";
        }
        log.info("模拟微信渠道支付划账成功，userId：{}，tradeID：{}，amount：{}", userId, tradeId, amount);
        return "0000";
    }
}
