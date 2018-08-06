package com.zlikun.jee.j06_3;

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/8/6 18:25
 */
public class ObjectsTest {

    static class Data {
        private String text;

        public Data(String text) {
            this.text = text;
        }
    }

    @Test
    public void test() {

        // 比较两个对象
        assertTrue(Objects.compare(new Data("M"), new Data("N"),
                new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return o1.text.compareTo(o2.text);
                    }
                }) < 0);

        // 多个对象计算HashCode
        assertEquals(149886, Objects.hash("x", "y", 1024));

        // 比较两个对象是否相等
        assertFalse(Objects.equals(new Data("x"), new Data("x")));

        // 计算对象HashCode
        assertEquals(1545290164, Objects.hashCode(new Data("z")));

    }

}
