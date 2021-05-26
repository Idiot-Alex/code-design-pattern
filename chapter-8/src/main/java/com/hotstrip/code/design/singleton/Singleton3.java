package com.hotstrip.code.design.singleton;

/**
 * @author hotstrip
 * 单例，懒汉模式，线程安全
 * 本质上就是在方法上加同步锁
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }

    /**
     * 方法上加上 synchronized 关键字
     * @return
     */
    public static synchronized Singleton3 getInstance() {
        if (null == instance) {
            instance = new Singleton3();
        }
        return instance;
    }
}
