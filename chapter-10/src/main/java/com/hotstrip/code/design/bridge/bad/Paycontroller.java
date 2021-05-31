package com.hotstrip.code.design.bridge.bad;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author hotstrip
 * 支付接口，支持多种支付方式
 */
@Slf4j
public class Paycontroller {

    /**
     * 模拟微信和支付宝支付
     * @param userId
     * @param tradeId
     * @param amount
     * @param channelType
     * @param modeType
     * @return
     */
    public boolean doPay(final String userId, final String tradeId,
                         final BigDecimal amount, final int channelType, final int modeType) {
        // 微信支付
        if (1 == channelType) {
            log.info("模拟微信渠道支付划账开始。userId：{}，tradeID：{}，amount：{}", userId, tradeId, amount);
            if (1 == modeType) {
                log.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        }
        // 支付宝支付
        else if (2 == channelType) {
            log.info("模拟支付宝渠道支付划账开始。userId：{}，tradeID：{}，amount：{}", userId, tradeId, amount);
            if (1 == modeType) {
                log.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                log.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                log.info("指纹支付，风控校验指纹信息");
            }
        }
        return true;
    }
}
