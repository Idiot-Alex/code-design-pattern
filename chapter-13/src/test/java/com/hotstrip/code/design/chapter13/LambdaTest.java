package com.hotstrip.code.design.chapter13;

import com.hotstrip.code.design.chapter13.base.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

    @Test
    public void test6() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream()
                .map( i -> i*i)
                .collect(Collectors.toList());

        squaresList.forEach(System.out::println);
    }

    @Test
    public void test7() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream()
                .filter(String::isEmpty)
                .count();
        log.info("count: {}", count);
    }

    @Test
    public void test8() {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        log.info("筛选列表: {}", filtered.toString());

        String mergedString = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining(", "));
        log.info("合并字符串: {}", mergedString);
    }

    @Test
    public void test9() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        log.info("列表中最大的数: {}", stats.getMax());
        log.info("列表中最小的数: {}", stats.getMin());
        log.info("所有数之和: {}", stats.getSum());
        log.info("平均数: {}", stats.getAverage());
    }

    @Test
    public void test10 () {
        Optional<UserInfo> optional = Optional.empty();
        optional.ifPresent(userInfo -> {
            // do action
        });
    }
}
