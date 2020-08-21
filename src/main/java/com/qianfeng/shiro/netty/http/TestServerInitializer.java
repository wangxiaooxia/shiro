package com.qianfeng.shiro.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //向管道加入处理器
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("myHttpServerCodec",new HttpServerCodec());
        pipeline.addLast("myHandler",new TestHttpServerHandler());

    }
}
