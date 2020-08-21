package com.qianfeng.shiro.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class NettyByteBuf02 {
    public static void main(String[] args) {
        ByteBuf buf = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
        //使用相关的api
        if (buf.hasArray()) {
            byte[] content = buf.array();
            System.out.println(new String(content,Charset.forName("utf-8")).trim());
            System.out.println("buf="+buf);
            System.out.println(buf.arrayOffset());
            System.out.println(buf.readerIndex());
            System.out.println(buf.writerIndex());

            System.out.println(buf.capacity());
            int len = buf.readableBytes();
            System.out.println(len);
        }
    }
}
