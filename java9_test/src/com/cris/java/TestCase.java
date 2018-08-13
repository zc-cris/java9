package com.cris.java;

import com.cris.bean.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * @ClassName TestCase
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TestCase {
    private static final Logger LOGGER = Logger.getLogger("cris");

    public static void main(String[] args) {
        Person p = new Person(12, "cris");
        System.out.println("p = " + p);
//        User user = new User(12);

        LOGGER.info("hello,module!");
    }

    @Test
    public void test2(){
        Assert.assertEquals(4, 2+2);
    }
}
