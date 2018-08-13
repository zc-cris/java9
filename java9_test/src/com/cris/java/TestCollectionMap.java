package com.cris.java;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName TestString
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TestCollectionMap {

    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("cris");
        list.add("james");
        list.add("curry");

        // 给原list 加锁,重新生成一个不可变的list集合
        List<String> newList = Collections.unmodifiableList(list);
//        newList.add("simida");    报错
        newList.forEach(System.out::println);

        System.out.println("---------");

        list.add("simida");
        list.forEach(System.out::println);
        System.out.println(newList == list);    // false

        // 快速创建只读的list
//        List<Integer> list = Collections.unmodifiableList(Arrays.asList(1, 2, 3));

    }

    @Test
    public void test2() {
        // 快速创建只读的set
        Set<Integer> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(4, 5, 6)));
//        set.add(8);   报错
        set.forEach(System.out::println);
    }

    @Test
    public void test3() {
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            // jdk 9 中新语法，可以在钻石操作符后面加上{}生成匿名子类对象，然后通过代码块初始化
            {
                put("money", 23);
                put("height", 173);
                put("weight", 143);
            }
        });
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }


    @Test
    public void test4() {
        //jdk 9 之后，我们有了更为方便的方法来创建只读的集合
        List<Integer> list = List.of(1, 2, 3);

        Set<String> set = Set.of("james", "cris");

        // 创建只读map 方法一：
        Map<String, Integer> map = Map.of("james", 23, "cris", 19);

        // 创建只读map 方法二：
        Map<String, Integer> map1 = Map.ofEntries(Map.entry("curry", 24), Map.entry("simida", 18));

        System.out.println("map1 = " + map1);   // map1 = {simida=18, curry=24}

    }

}
