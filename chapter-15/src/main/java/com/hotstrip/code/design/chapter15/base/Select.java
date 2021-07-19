package com.hotstrip.code.design.chapter15.base;

import java.lang.annotation.*;

/**
 * 模拟 Select 注解，用于执行 SQL 语句
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {
    // SQL 语句
    String value() default "";
}
