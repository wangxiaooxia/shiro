package com.qianfeng.shiro.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient  {
    public static void main(String[] args) throws Exception {
      EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
      try {
          Bootstrap bootstrap = new Bootstrap();
          bootstrap.group(eventLoopGroup)
                  .channel(NioSocketChannel.class)
                  .handler(new ChannelInitializer<SocketChannel>() {
                      @Override
                      protected void initChannel(SocketChannel channel) {
                          channel.pipeline().addLast(new NettyClientHandler());
                      }
                  });
          System.out.println("客户端 ok");
          ChannelFuture sync = bootstrap.connect("127.0.0.1", 6668).sync();
          sync.channel().closeFuture().sync();
      }finally {
          eventLoopGroup.shutdownGracefully();
      }
    }
}
