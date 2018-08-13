package com.cris.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName TestStream
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TestStream {

    // takeWhile 方法用于取出满足predicate 接口的数据，一旦遇到不满足即停止
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(12, 44, 32, 666, 70, 55);
        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);

    }

    // dropWhile 同 takeWhile 正好相反，从不满足predicate 断言的第一个元素开始保留后面所有元素
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(12, 44, 32, 666, 70, 55);
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println);
    }

    // ofNullable(T t)： 允许t为null
    @Test
    public void test3() {
        // jdk 8 不允许stream 中有一个元素时，这个元素是null
     /*   Stream<Object> stream = Stream.of(null);
        System.out.println(stream.count());     // 报错*/

        Stream<Object> objectStream = Stream.ofNullable(null);
        System.out.println(objectStream.count());   // 此时stream里面即便有一个null，元素个数也是0

    }

    // 加强的iterate 方法，可以对不断生成的x进行predicate判断，比limit更加强大
    @Test
    public void test4() {
        Stream.iterate(0, x -> x + 1).limit(5).forEach(System.out::println);
        System.out.println("-------");
        Stream.iterate(0, x -> x < 5, x -> x + 1).forEach(System.out::println);

    }

    // optional 类现在可以直接转换为Stream
    @Test
    public void test5(){
        List<String> list = new ArrayList<>(){
            {
                add("cris");
                add("james");
            }
        };
        Optional<List<String>> optionalStrings = Optional.of(list);
        Stream<String> stringStream = optionalStrings.stream().flatMap(x -> x.stream());


//        Stream<List<String>> stream = optionalStrings.stream();
//        System.out.println(stream.count()); //1
//        stream.forEach(System.out::println);  //[cris, james]
    }
}
