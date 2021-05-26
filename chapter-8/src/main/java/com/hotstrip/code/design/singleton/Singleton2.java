package com.hotstrip.code.design.singleton;

/**
 * @author hotstrip
 * 单例模式 2 懒汉模式，线程不安全
 * 构造方法私有，静态方法里面判断成员变量是否为 null，是就直接返回，否就实例化返回
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    /**
     * 判断静态成员变量是否为 null
     * 为 null 就先实例化
     * @return
     */
    public static Singleton2 getInstance() {
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
