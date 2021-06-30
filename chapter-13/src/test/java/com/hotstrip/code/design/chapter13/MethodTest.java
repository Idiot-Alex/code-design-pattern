package com.hotstrip.code.design.chapter13;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用测试类
 */
@Slf4j
public class MethodTest {

    /**
     * 方法引用 new 一个实例
     * 需要借助 Supplier 函数式接口来实现
     */
    @Test
    public void test1() {
        UserService userService = UserService.create(UserService::new);
    }


    /**
     * 方法引用调用实例方法
     * 需要借助 Consumer 函数式接口来实现
     */
    @Test
    public void test2() {
        UserService userService = UserService.create(UserService::new);;
        List<UserService> list = Arrays.asList(userService);
        list.forEach(UserService::checked);
    }

}

@Slf4j
class UserService {

    /**
     * 创建一个 UserService
     * @param supplier
     * @return
     */
    public static UserService create(Supplier<UserService> supplier) {
        log.info("created a new UserService...");
        return supplier.get();
    }

    /**
     * user checked
     * @return
     */
    public void checked() {
        log.info("UserService checked....");
    }
}
