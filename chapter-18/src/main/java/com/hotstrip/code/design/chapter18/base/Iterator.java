package com.hotstrip.code.design.chapter18.base;

/**
 * 模拟实现迭代器接口
 * @author Hotstrip
 * @param <E>
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();
}
