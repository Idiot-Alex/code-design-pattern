package com.hotstrip.code.design.bridge.good.channel;

import com.hotstrip.code.design.bridge.bad.Paycontroller;
import com.hotstrip.code.design.bridge.good.model.PayFaceMode;
import com.hotstrip.code.design.bridge.good.model.PayFingerprintMode;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

@Slf4j
public class PayTest extends TestCase {


    @Test
    public void testPay() {
        Pay wxPay = new WxPay(new PayFaceMode());
        log.info("\r\n模拟测试场景：微信支付，人脸方式：");
        wxPay.transfer("weixin_1092033111", "100000109893", BigDecimal.valueOf(100));

        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        log.info("\r\n模拟测试场景：支付宝支付，指纹方式：");
        zfbPay.transfer("zfb1092033111", "100000109894", BigDecimal.valueOf(100));
    }
}