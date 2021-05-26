package com.hotstrip.code.design.singleton;

/**
 * @author hotstrip
 * 双重锁校验，线程安全
 */
public class Singleton5 {

    // 使用 volatile 关键字修饰，保证内存可见性
    private static volatile Singleton5 instance;

    private Singleton5() {
    }

    /**
     * 对这个类加同步锁，由于静态成员变量使用了 volatile 修饰
     * 可以保证多个线程同时调用这个方法的时候只会有一个线程实例化
     * 且一旦实例化，其他线程就能拿到这个实例化之后的对象
     * @return
     */
    public static Singleton5 getInstance() {
        if (null == instance) {
            synchronized (Singleton5.class) {
                if (null == instance) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
