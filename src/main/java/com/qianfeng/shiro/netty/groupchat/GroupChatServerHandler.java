package com.qianfeng.shiro.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static List<Channel> channels = new ArrayList<Channel>();
    //全局事件执行器
    private static ChannelGroup channelsGroup  = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //定义一个channel组，管理所有的channel

    //一单连接第一个被执行
    //将当前channel加入到channelGroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channle = ctx.channel();
        channle.writeAndFlush("【客户端】"+channle.remoteAddress()+"加入聊天");
        channelsGroup.add(channle);
        System.out.println("dsfsd"+channelsGroup.size());

    }
    //断开连接
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelsGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+ "  离开了\n");
        System.out.println("dsfsd"+channelsGroup.size());
    }

    //表示channel处于一个活动的状态
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"上线了~");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"离线了~");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String string) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("hshhd"+channelsGroup.size());
        channelsGroup.forEach(ch ->{
            if (channel != ch) {
                ch.writeAndFlush("【客户】"+channel.remoteAddress()+"发送了消息"+string+"\n");
            } else {
                ch.writeAndFlush("[自己]发送的消息" + string +"\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
