package com.hotstrip.code.design.chapter13;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Slf4j
public class DateTimeTest {

    @Test
    public void test1() {
        // 初始化一个日期：2021-04-04
        LocalDate localDate = LocalDate.of(2021, 4, 4);
        // 年份：2021
        int year = localDate.getYear();
        // 月份：JANUARY
        Month month = localDate.getMonth();
        // 月份中的第几天：4
        int dayOfMonth = localDate.getDayOfMonth();
        // 一周的第几天：WEDNESDAY
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        // 月份的天数：31
        int length = localDate.lengthOfMonth();
        // 是否为闰年：false
        boolean leapYear = localDate.isLeapYear();
        // 调用静态方法now()来获取当前日期
        LocalDate now = LocalDate.now();
        log.info("year: {}", year);
        log.info("month: {}", month);
        log.info("dayOfMonth: {}", dayOfMonth);
        log.info("dayOfWeek: {}", dayOfWeek);
        log.info("length: {}", length);
        log.info("leapYear: {}", leapYear);
        log.info("now: {}", now);
    }

    @Test
    public void test2() {
        // 初始化一个时间：17:23:52
        LocalTime localTime = LocalTime.of(17, 23, 52);
        // 时：17
        int hour = localTime.getHour();
        // 分：23
        int minute = localTime.getMinute();
        // 秒：52
        int second = localTime.getSecond();
        log.info("hour:minute:second....{}:{}:{}", hour, minute, second);
    }

    @Test
    public void test3() {
        LocalDateTime ldt1 = LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52);
        log.info("ldt1: {}", ldt1);

        LocalDate localDate = LocalDate.of(2017, Month.JANUARY, 4);
        LocalTime localTime = LocalTime.of(17, 23, 52);
        LocalDateTime ldt2 = localDate.atTime(localTime);

        log.info("ldt2: {}", ldt2);
    }

    @Test
    public void test4() {
        // ofEpochSecond()方法的第一个参数为秒，第二个参数为纳秒，下面的代码表示从1970-01-01 00:00:00开始后两分钟的10万纳秒的时刻
        Instant instant = Instant.ofEpochSecond(120, 100000);
        log.info("instat: {}", instant);
    }

    @Test
    public void test5() {
        LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 5, 10, 7, 0);    // 2017-01-05 10:07:00
        LocalDateTime to = LocalDateTime.of(2017, Month.FEBRUARY, 5, 10, 7, 0);     // 2017-02-05 10:07:00
        Duration duration = Duration.between(from, to);     // 表示从 2017-01-05 10:07:00 到 2017-02-05 10:07:00 这段时间

        long days = duration.toDays();              // 这段时间的总天数
        long hours = duration.toHours();            // 这段时间的小时数
        long minutes = duration.toMinutes();        // 这段时间的分钟数
        long seconds = duration.getSeconds();       // 这段时间的秒数
        long milliSeconds = duration.toMillis();    // 这段时间的毫秒数
        long nanoSeconds = duration.toNanos();      // 这段时间的纳秒数
        log.info("days: {}...hours: {}...minutes: {}...seconds: {}...milliSeconds: {}...nanoSeconds: {}",
                days, hours, minutes, seconds, milliSeconds, nanoSeconds);

        // Duration对象还可以通过of()方法创建，该方法接受一个时间段长度，和一个时间单位作为参数：
        Duration duration1 = Duration.of(5, ChronoUnit.DAYS);       // 5天
        Duration duration2 = Duration.of(1000, ChronoUnit.MILLIS);  // 1000毫秒
        log.info("duration1: {}...duration2: {}", duration1, duration2);
    }

    @Test
    public void test6() {
        Period period1 = Period.of(2, 3, 6);
        log.info("period1: {}", period1);

        // 2017-01-05 到 2017-02-05 这段时间
        Period period2 = Period.between(
                LocalDate.of(2017, 1, 5),
                LocalDate.of(2017, 2, 5));
        log.info("period2: {}", period2);
    }

    @Test
    public void test7() {
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, shanghaiZoneId);
        log.info("zonedDateTime: {}", zonedDateTime);
    }

    @Test
    public void test8() {
        LocalDate date = LocalDate.of(2017, 1, 5);          // 2017-01-05

        LocalDate date1 = date.withYear(2016);              // 修改为 2016-01-05
        LocalDate date2 = date.withMonth(2);                // 修改为 2017-02-05
        LocalDate date3 = date.withDayOfMonth(1);           // 修改为 2017-01-01

        LocalDate date4 = date.plusYears(1);                // 增加一年 2018-01-05
        LocalDate date5 = date.minusMonths(2);              // 减少两个月 2016-11-05
        LocalDate date6 = date.plus(5, ChronoUnit.DAYS);    // 增加5天 2017-01-10

        log.info("data1: {}...date2: {}...date3: {}...date4: {}, data5: {}, date6: {}",
                date1, date2, date3, date4, date5,date6);
    }

    @Test
    public void test9() {
        // 日期时间转换成字符串
        LocalDateTime dateTime = LocalDateTime.now();
        String strDate1 = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));   // 2017-01-05

        // 字符串转换成日期时间
        String strDate2 = "2017-01-05";
        LocalDate date = LocalDate.parse(strDate2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        log.info("strDate1: {}", strDate1);
        log.info("date: {}", date);
    }

}
