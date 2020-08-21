package com.qianfeng.shiro.netty.protocoltcp;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.UUID;


public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws UnsupportedEncodingException {
        int len = msg.getLen();
        byte[] content = msg.getContent();
        System.out.println("服务器接收到的消息如下 ");
        System.out.println("长度= "+len);
        System.out.println("内容= "+new String(content,Charset.forName("utf-8")));
        System.out.println("服务器接收到的消息包数量="+(++this.count));


        String responseContent = UUID.randomUUID().toString();
        int length = responseContent.getBytes("utf-8").length;
        byte[] responseContent2 = responseContent.getBytes("utf-8");

        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(length);
        messageProtocol.setContent(responseContent2);
        ctx.writeAndFlush(messageProtocol);

    }
}
