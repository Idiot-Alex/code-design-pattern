package com.hotstrip.code.design.singleton;

/**
 * @author hotstrip
 * 单例，饿汉模式，线程安全
 */
public class Singleton4 {
    private static Singleton4 instance = new Singleton4();

    private Singleton4() {
    }

    /**
     * 在静态成员变量上直接实例化
     * 不是需要的时候才加载，而是程序运行就会加载
     * @return
     */
    public static Singleton4 getInstance() {
        return instance;
    }
}
