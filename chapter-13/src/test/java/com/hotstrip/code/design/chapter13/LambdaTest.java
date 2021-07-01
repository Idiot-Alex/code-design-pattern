package com.hotstrip.code.design.chapter13;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lambda 表达式测试类
 */
@Slf4j
public class LambdaTest {

    @Test
    public void test1() throws InterruptedException {
        Runnable runnable = () -> log.info("start a new thread...");
        Thread thread = new Thread(() -> log.info("start a new thread..."));
        thread.start();
        thread.join();
    }

    @Test
    public void test2() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("start a new thread...");
            }
        });
        thread.start();
        thread.join();
    }

    @Test
    public void test3() {
        // Consumer 输出字符串
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hotstrip");

        // Supplier 生成一个字符串
        Supplier<String> supplier = () -> "new String";
        log.info(supplier.get());

        // Function 计算数字 * 2
        Function<Integer, Integer> function = x -> x * 2;
        log.info("function result is: {}", function.apply(5));

        // Predicate 断言字符串长度
        Predicate<String> predicate = s -> s.length() > 5;
        log.info("predicate result is: {}", predicate.test("Hello World"));
    }

    @Test
    public void test4() {
        String[] names = new String[] {"Hotstrip", "Stormzhang", "Allen Zhang", "TomKeeper"};

        // 实现排序算法
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };
        // 对数据进行排序
        Arrays.sort(names, comparator);

        // 输出结果
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("Hotstrip", "Stormzhang", "Allen Zhang", "TomKeeper");

        // 自定义排序算法，并且对数据排序
        list.sort((s1, s2) -> s1.compareTo(s2));

        // 甚至还可以简化成方法引用方式
        // list.sort(String::compareTo);

        // 输出结果
        list.forEach(System.out::println);
    }
}
