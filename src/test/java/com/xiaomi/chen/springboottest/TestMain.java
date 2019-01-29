package com.xiaomi.chen.springboottest;

import java.lang.annotation.*;
import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/28
 * @description
 */
public class TestMain {

    public static void main(String[] args) {

    }


    // 1、lambda表达式
    public void test0() {
        List<String> list = Arrays.asList("a", "bg", "cc");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });

        // lambda 表达式
        list.sort((o1, o2) -> o1.compareTo(o2));
    }


    // 2、函数式接口
    // 定义接口
    @FunctionalInterface
    interface Converter<T, F> {
        T convert(F f);
    }

    // 使用
    public void test1() {
        Converter<String, Integer> converter = String::valueOf;
        System.out.println(converter.convert(28834));
    }

    // 3、内置函数式接口
    public void test2() {

        // Predicate是一个接口，在这里直接对其做了实现
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");              // true

        // Function 函数式接口的作用是，为其提供一个原料，生产一个最终的产品
        Function<String, Integer> toInteger = Integer::valueOf;
        toInteger.apply("123");

        // Supplier 与 Function 不同，不接受入参，直接为生产一个指定的结果
        Supplier<String> supplier = String::new;
        supplier.get();

        // 对于Consumer，需要提供入参，用来被消费
        Consumer<BigDecimal> consumer = (s) -> s.toString();
        consumer.accept(new BigDecimal("100"));
    }

    // 4、Optional 它不是一个函数式接口，设计它的目的是为了防止空指针异常
    public void test3() {
        Optional<String> optional = Optional.of("hdfjf");
        optional.orElse("fail");
        optional.get();
        optional.ifPresent(System.out::println);
        optional.orElseThrow(RuntimeException::new);
    }

    // 5、Stream 流
    public void test4() {

        // Filter 过滤
        // Sorted 排序
        // Map 转换
        // Match 匹配
        // Count 计数

        List<String> list = Arrays.asList("a", "bg", "cc");
        list.stream().filter(s -> s.startsWith("s"))
                .sorted()
                .map(s -> s + "1")
                .anyMatch((s) -> s.length() > 0);

        // reduce通过入参的 Function将 list 归约成一个值
        list.stream().reduce((s1, s2) -> s1 + "#" + s2);


        // Parallel-Streams 并行流,通过多线程来处理的，能够充分利用物理机 多核 CPU 的优势
        list.parallelStream().sorted();
    }

    // 6、 map 集合，JDK 8 中对map提供了一些其他新特性
    public void test5() {

        Map<Integer, String> map = new HashMap<>();
        map.putIfAbsent(1, "i");

        // computeIfPresent(), 当 key 存在时，才会做相关处理key和value
        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);

        // 先判断 key 为 9 的元素是否存在，存在，则做删除操作
        map.computeIfPresent(1, (num, val) -> null);
        map.containsKey(1);     // false

        // computeIfAbsent(), 当 key 不存在时，才会做相关处理
        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true

    }

    // 7、新版日期处理 Clock
    public void test6() {

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        // 老版本 java.util.Date
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);


        // Timezone时区
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        // Localtime
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        // LocalDate
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2019, Month.FEBRUARY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
    }

    // 8、注解可重复
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        String value();// 定义一个属性值
    }

    // 老板需要定义一个注解容器，才允许在同一个方法上重复使用注解
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotationContainer {
        MyAnnotation[] value();
    }

    @MyAnnotationContainer({@MyAnnotation("he"), @MyAnnotation("hh")})
    public void test8() {

    }


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotationContainer1 {
        MyAnnotation1[] value();
    }

    @Target(ElementType.METHOD) // 使用范围在类、接口和枚举
    @Retention(RetentionPolicy.RUNTIME) // 生命周期在运行时期，可以进行反射操作
    @Repeatable(MyAnnotationContainer1.class) // 重复注解，需要指定注解容器
    public @interface MyAnnotation1 {
        String value();// 定义一个属性值
    }

}
