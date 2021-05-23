package com.hotstrip.code.design.builder.bad;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class DecorationPackageServiceTest extends TestCase {

    /**
     * test decoration package
     */
    public void testDecorationPackageService() {
        DecorationPackageService decorationPackageService = new DecorationPackageService();

        log.info("豪华欧式");
        log.info(decorationPackageService.getMatterList(BigDecimal.valueOf(132.52), 1));
        log.info("轻奢田园");
        log.info(decorationPackageService.getMatterList(BigDecimal.valueOf(98.25), 2));
        log.info("现代简约");
        log.info(decorationPackageService.getMatterList(BigDecimal.valueOf(85.43), 3));
    }

}