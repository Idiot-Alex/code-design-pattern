package com.hotstrip.code.design.singleton;

/**
 * @author hotstrip
 * 静态内部类单例模式
 */
public class Singleton6 {
    private Singleton6() {
    }

    private static class Singleton6Holder {
        private static Singleton6 instance = new Singleton6();
    }

    /**
     * 返回静态内部类实例
     * 静态内部类的实例不会在程序运行时加载，而是调用的时候才会
     * @return
     */
    public static Singleton6 getInstance() {
        return Singleton6Holder.instance;
    }
}
