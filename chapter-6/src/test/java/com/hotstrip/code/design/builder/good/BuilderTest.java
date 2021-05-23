package com.hotstrip.code.design.builder.good;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BuilderTest extends TestCase {

    @Test
    public void testBuilder() {
        Builder builder = new Builder();
        log.info("豪华欧式");
        log.info(builder.levelOne(132.52).getDetail());
        log.info("轻奢田园");
        log.info(builder.levelTwo(98.25).getDetail());
        log.info("现代简约");
        log.info(builder.levelThree(85.43).getDetail());
    }
}