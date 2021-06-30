package com.hotstrip.code.design.chapter13;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Lambda 表达式测试类
 */
@Slf4j
public class LambdaTest {

    @Test
    public void test1() throws InterruptedException {
        Runnable runnable = () -> log.info("start a new thread...");
        Thread thread = new Thread(() -> log.info("start a new thread..."));
        thread.start();
        thread.join();
    }

    @Test
    public void test2() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("start a new thread...");
            }
        });
        thread.start();
        thread.join();
    }
}
