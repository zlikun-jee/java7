package com.zlikun.jee.j03_4;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/8/6 17:36
 */
public class PathTest {

    @Test
    public void test() {

        Path path = Paths.get("src/test/java/com/zlikun/jee/j03_4", "PathTest.java");
        // D:\Studio\gitrepos\java7\java7-features\src\test\java\com\zlikun\jee\j03_4\PathTest.java
        System.out.println(path.toAbsolutePath().toString());
        // src\test\java\com\zlikun\jee\j03_4\PathTest.java
        System.out.println(path.toString());
        // file:///D:/Studio/gitrepos/java7/java7-features/src/test/java/com/zlikun/jee/j03_4/PathTest.java
        System.out.println(path.toUri().toString());

        // 这里判断结束的是路径不是字符串，所以不能用.java来判断
        assertTrue(path.endsWith("PathTest.java"));
        assertTrue(path.endsWith(Paths.get("PathTest.java")));
        assertTrue(path.startsWith("src/test/java"));
        assertTrue(path.startsWith(Paths.get("src/test/java")));

        // PathTest.java
        System.out.println(path.getFileName());
        // null
        System.out.println(path.getRoot());
        // D:\
        System.out.println(path.toAbsolutePath().getRoot());
        // src\test\java\com\zlikun\jee\j03_4
        System.out.println(path.getParent());
        // sun.nio.fs.WindowsFileSystem@1c740be3
        System.out.println(path.getFileSystem());

        assertFalse(path.isAbsolute());
        assertTrue(path.toAbsolutePath().isAbsolute());

        assertEquals(8, path.getNameCount());

        // src\test\java\com\zlikun\jee\j03_4\PathTest.java
        System.out.println(path.toFile());
        // src\test\java\com\zlikun\jee\j03_4\PathTest.java\PathTest2.java
        System.out.println(path.resolve("PathTest2.java"));
        // ..\..\..\..\..\..\..\..\pom.xml
        System.out.println(path.relativize(Paths.get("pom.xml")));

    }

}
