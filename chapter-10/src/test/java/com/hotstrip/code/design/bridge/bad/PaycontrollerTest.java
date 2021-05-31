package com.hotstrip.code.design.bridge.bad;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

@Slf4j
public class PaycontrollerTest extends TestCase {

    @Test
    public void testPay() {
        Paycontroller paycontroller = new Paycontroller();
        log.info("\r\n模拟测试场景：微信支付，人脸方式：");
        paycontroller.doPay("weixin_1092033111", "100000109893", BigDecimal.valueOf(100), 1, 2);


        log.info("\r\n模拟测试场景：支付宝支付，指纹方式：");
        paycontroller.doPay("zfb1092033111", "100000109894", BigDecimal.valueOf(100), 2, 3);

    }
}