package com.hotstrip.code.design.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hotstrip
 * 单例模式 1
 * 静态类方式：直接返回一个静态的成员变量，并且直接实例化
 */
public class Singleton1 {

    public static Map<String, String> cache = new ConcurrentHashMap<>();
}
