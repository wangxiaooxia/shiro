package com.qianfeng.shiro.netty.tcp;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup boosGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap severBootstrap = new ServerBootstrap();
            severBootstrap.group(boosGroup,workerGroup)
            .channel(NioServerSocketChannel.class)
            .childHandler(new MyServerInitializer());
            ChannelFuture channelFuture = severBootstrap.bind(7000).sync();
            channelFuture.channel().closeFuture().sync();


        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
