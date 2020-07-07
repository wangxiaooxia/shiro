package com.qianfeng.shiro.netty.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {
    public static void main(String[] args) throws Exception {

        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors)
            .channel(NioSocketChannel.class)
            .handler(new MyClientInitializer());
            ChannelFuture channelFutrue = bootstrap.connect("127.0.0.1", 7000);
            channelFutrue.channel().closeFuture().sync();


        }finally {
            eventExecutors.shutdownGracefully();
        }

    }
}
