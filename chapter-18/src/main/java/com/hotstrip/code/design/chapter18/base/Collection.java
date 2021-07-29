package com.hotstrip.code.design.chapter18.base;

/**
 * 模拟实现集合功能接口
 * @author Hotstrip
 */
public interface Collection<E, L> extends Iterable<E> {

    boolean add(E e);

    boolean remove(E e);

    boolean addLink(String key, L l);

    boolean removeLink(String key);
}
