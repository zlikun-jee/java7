package com.zlikun.jee.j01;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

/**
 * 测试JDK7的try-with-resources语法
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/8/6 17:02
 */
public class TryWithResourcesTest {

    @Test
    public void one_row() throws IOException {

        // 直接在try()中编写资源操作代码，这样不需要显示通过finally子句来关闭流，它会自动管理
        // 该特性可以参考Python的with语句，在如下代码中异常被抛出，但即使发生异常流也会被正确关闭
        // 能使用该语法的要求是对应Java类要实现java.lang.AutoCloseable接口（这与Python中的__enter__、__exit__魔法方法几乎一个原理）
        try (BufferedReader reader = new BufferedReader(new FileReader("pom.xml"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

    }

    @Test
    public void multi_rows() throws IOException {
        // try-with-resources不仅能应用于单行语句，也可以用于多行语句
        try (
                BufferedReader reader = new BufferedReader(new FileReader("pom.xml"));
                StringWriter writer = new StringWriter();
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write("\n");
            }
            System.out.println(writer.toString());
        }

    }

}
