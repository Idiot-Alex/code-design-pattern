package com.hotstrip.code.design.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hotstrip
 * CAS 单例
 */
public class Singleton8 {
    private Singleton8() {
    }

    private static final AtomicReference<Singleton8> INSTANCE = new AtomicReference<>();

    /**
     * 使用 CAS 机制实现单例
     * @return
     */
    public static final Singleton8 getInstance() {
        for (; ;) {
            Singleton8 instance = INSTANCE.get();
            if (null == instance) {
                INSTANCE.compareAndSet(null, new Singleton8());
            }
            return INSTANCE.get();
        }
    }
}
