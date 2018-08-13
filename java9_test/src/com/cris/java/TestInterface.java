package com.cris.java;

import java.nio.charset.MalformedInputException;

/**
 * @ClassName TestInterface
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
interface MyInterface {
    // jdk8 之前接口只能定义抽象方法(public abstract)和全局常量（public static final）
    void method1();

    // jdk 8 的接口可以定义默认方法和静态方法了
    static void method2() {
        System.out.println("method2");
    }

    default void method3() {
        System.out.println("method3");
        method4();
    }

    // jdk 9 的接口可以声明私有方法了
    private void method4() {
        System.out.println("私有方法");
    }
}

class MyInterfaceImple implements MyInterface {

    @Override
    public void method1() {
        System.out.println("实现类的method1");
    }

    // 接口的默认方法是可以由继承类覆写的
//    @Override
//    public void method3() {
//
//    }
}

public class TestInterface {
    public static void main(String[] args) {
        // 直接调用接口的静态方法
        MyInterface.method2();

        MyInterfaceImple imple = new MyInterfaceImple();
        // 通过实例化接口，调用接口的默认方法，进而调用接口的私有方法
        imple.method3();
    }
}
