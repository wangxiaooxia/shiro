package com.qianfeng.shiro.netty.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol, ByteBuf out) {
        System.out.println("MyMessageEncoder encode 方法被调用 ");
        out.writeInt(messageProtocol.getLen());
        out.writeBytes(messageProtocol.getContent());
    }
}
