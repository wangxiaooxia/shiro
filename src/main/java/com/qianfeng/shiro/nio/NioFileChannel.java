package com.qianfeng.shiro.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class NioFileChannel {

    public static void main(String[] args) throws IOException {
        String str = "hello wangxiaoxia";
        FileOutputStream fileOutputStream = new FileOutputStream("D://aa.txt");
        FileChannel channel =  fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();

        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
