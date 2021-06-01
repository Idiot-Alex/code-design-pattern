package com.hotstrip.code.design.bad;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class EngineControllerTest extends TestCase {

    @Test
    public void test() {
        EngineController engineController = new EngineController();
        String result = engineController.process("sadfsfs001", "man", 28);
        log.info("测试结果: {}", result);
    }

}