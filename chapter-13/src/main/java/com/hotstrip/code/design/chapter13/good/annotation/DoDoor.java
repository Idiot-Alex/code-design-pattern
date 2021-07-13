package com.hotstrip.code.design.chapter13.good.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，处理拦截的标志
 * key 表示拦截的字段、属性
 * returnJson 表示触发拦截之后返回的信息
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoDoor {
    String key() default "";
    String returnJson() default "";
}
