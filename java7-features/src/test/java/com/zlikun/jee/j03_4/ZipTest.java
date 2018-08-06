package com.zlikun.jee.j03_4;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/8/6 17:50
 */
public class ZipTest {

    @Test
    public void test() throws IOException {
        // 事先准备了一个空的ZIP包（里面没有文件）
        Path path = Paths.get("D:\\Temporary", "java7.zip");

        Map<String, String> env = new HashMap<>();
        // 这个属性有啥用？注掉也不影响！
        env.put("create", "true");

        // 现在将本工程的pom.xml文件加入该ZIP包中
        try (FileSystem fs = FileSystems.newFileSystem(URI.create("jar:" + path.toUri()), env)) {
            // 复制目标文件路径
            Path target = Paths.get("pom.xml");
            // 文件在ZIP中的路径
            Path zipFile = fs.getPath("/" + target.getFileName());
            // 执行文件复制
            Files.copy(target, zipFile, StandardCopyOption.REPLACE_EXISTING);
        }

    }

}
