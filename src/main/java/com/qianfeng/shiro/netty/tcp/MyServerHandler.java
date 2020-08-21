package com.qianfeng.shiro.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private int count;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);
        String message = new String(buffer, Charset.forName("utf-8"));
        System.out.println("服务器接收到的数据  "+message);
        System.out.println("服务器接收到的消息量 =" +(++this.count));
        ByteBuf responseByte = Unpooled.copiedBuffer(UUID.randomUUID().toString()+"   ", Charset.forName("utf-8"));
        ctx.writeAndFlush(responseByte);

    }
}
