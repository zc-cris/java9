package com.cris.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @ClassName TestTry
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TestTry {

    // java 8 中可以使用try-with-resource 语法，但是要求流对象的创建必须放在try后面的小括号中
    @Test
    public void test1() {
        try (InputStreamReader reader = new InputStreamReader(System.in)) {
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // java 9 之后的twr 语法比较宽松了，允许流对象的创建在try语句块的外面，但是此时的流对象的引用是final 类型（可以不写）
    // 是不能修改的（java 8 中也不能修改流对象的引用）
    @Test
    public void test2() {
        final OutputStreamWriter writer = new OutputStreamWriter(System.out);
        final InputStreamReader reader = new InputStreamReader(System.in);

        try (writer; reader) {
            reader.read();
            writer.write(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
