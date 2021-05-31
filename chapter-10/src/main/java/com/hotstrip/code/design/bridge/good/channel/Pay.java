package com.hotstrip.code.design.bridge.good.channel;

import com.hotstrip.code.design.bridge.good.model.IPayMode;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 支付抽象类，指支付的类型，比如微信支付、支付宝支付
 */
@Slf4j
public abstract class Pay {

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    /**
     * 支付逻辑的抽象方法
     * @param userId
     * @param tradeId
     * @param amount
     * @return
     */
    public abstract String transfer(final String userId, final String tradeId, final BigDecimal amount);
}
