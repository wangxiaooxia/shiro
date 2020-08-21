package com.qianfeng.shiro.netty.inboundhandlerandoutbandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MyByteToLongDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) {
        System.out.println("MyByteToLongDecoder 被调用");
        if (byteBuf.readableBytes() >= 8){
            list.add(byteBuf.readLong());
        }
    }

}
