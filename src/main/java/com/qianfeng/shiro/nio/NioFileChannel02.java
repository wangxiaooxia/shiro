package com.qianfeng.shiro.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NioFileChannel02 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("d://a.jpg");

        FileOutputStream fileOutputStream = new FileOutputStream("D://b.jpg");
        FileChannel sourceChannel = fileInputStream.getChannel();
        FileChannel destChannel = fileOutputStream.getChannel();
        destChannel.transferFrom(sourceChannel,0,sourceChannel.size());
        sourceChannel.close();
        destChannel.close();
        fileInputStream.close();
        fileOutputStream.close();




    }
}
