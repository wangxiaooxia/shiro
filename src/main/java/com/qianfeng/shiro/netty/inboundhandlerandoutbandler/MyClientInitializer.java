package com.qianfeng.shiro.netty.inboundhandlerandoutbandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyByteToLongDecoder());
        pipeline.addLast(new MyClientHandler());
    }
}
