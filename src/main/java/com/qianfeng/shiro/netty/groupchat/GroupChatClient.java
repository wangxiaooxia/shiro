package com.qianfeng.shiro.netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class GroupChatClient {
    private final String host;
    private final  int port;

    public GroupChatClient (String host,int port){
        this.host = host;
        this.port =port;
    }
    public void run () throws Exception {
        EventLoopGroup eventExecutor = new NioEventLoopGroup();
        try {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutor)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast("decoder",new StringDecoder());
                        pipeline.addLast("encoder",new StringEncoder());
                        //加入
                        pipeline.addLast(new GroupChatClientHandler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            Channel channel = channelFuture.channel();
            System.out.println("client is ready"+channel.remoteAddress());
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg =   scanner.nextLine();
                channel.writeAndFlush(msg+"/n");
            }
            channel.closeFuture().sync();
        } finally {
            eventExecutor.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws  Exception {
        new GroupChatClient("127.0.0.1",7000).run();
    }
}
