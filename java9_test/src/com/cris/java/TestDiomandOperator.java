package com.cris.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName TestDiomandOperator
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TestDiomandOperator {
    public static void main(String[] args) {
        // java 9 中可以在<> 符号后面使用{}完成HashSet的匿名实现子类
        Set<String> set = new HashSet<>(){};
        set.add("cris");
        set.add("james");
        for (String s : set) {
            System.out.println("s = " + s);
        }
    }
}
