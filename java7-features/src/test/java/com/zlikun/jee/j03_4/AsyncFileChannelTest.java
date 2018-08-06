package com.zlikun.jee.j03_4;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/8/6 18:05
 */
public class AsyncFileChannelTest {

    @Test
    public void test() throws IOException, ExecutionException, InterruptedException {

        Path path = Paths.get("D:\\Temporary", "java7.data");

        // 打开一个异步文件通道
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE);
        // 向文件中写入大块字节信息(32MB)
        ByteBuffer buffer = ByteBuffer.allocate(32 * 1024 * 1024);
        // 执行写入（异步的，所以不会阻塞）
        Future<Integer> result = channel.write(buffer, 0);

        // 接下来执行一些其它操作，比如喝杯茶^_^
        System.out.println("喝了一杯茶 ...");

        // 差不多了，检查一下写入是否完成了（这里会阻塞）
        Integer len = result.get();
        System.out.printf("写入了 %d 个字节的数据%n", len);

        // 清理掉这个文件
        Files.deleteIfExists(path);
    }

}
