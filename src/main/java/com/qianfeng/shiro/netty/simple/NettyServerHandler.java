package com.qianfeng.shiro.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;



public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    //读取客户端发送的数据 ChannelHandlerContext ctx  上下文对象
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程 "+Thread.currentThread().getName());
        System.out.println("server ctx =" +ctx);
        System.out.println("看看channel和pipeline的关系");
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline();

        ByteBuf buf = (ByteBuf)msg;
        System.out.println("客户端发送的消息是："+buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址："+ctx.channel().remoteAddress());

    }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            //将数据写入到缓存，并刷新
        //一般来讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端~",CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
