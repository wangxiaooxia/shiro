package com.qianfeng.shiro.netty.inboundhandlerandoutbandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyByteToLongEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Long msg, ByteBuf byteBuf) {
        System.out.println("MyByteToLongEncoder 被调用");
        System.out.println("msg="+msg);
        byteBuf.writeLong(msg);
    }
}
