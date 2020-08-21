package com.qianfeng.shiro.groupchat;


import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {
    private static Selector selector ;
    private static ServerSocketChannel listenerChannel;
    private static  int PORT = 6667;

    public GroupChatServer(){
        try {
            selector = Selector.open();
            listenerChannel = ServerSocketChannel.open();
            listenerChannel.socket().bind(new InetSocketAddress(PORT));
            listenerChannel.configureBlocking(false);
            listenerChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen(){
        try {
            while (true) {
                int count = selector.select(2000);
                if (count > 0){
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if(key.isAcceptable()) {
                            SocketChannel sc = listenerChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector,SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress()+"上线");
                        }
                        if (key.isReadable()) {
                            readData(key);
                        }
                        iterator.remove();
                    }

                } else {
                    System.out.println("等待连接。。。。。。");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readData(SelectionKey  key){
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer  = ByteBuffer.allocate(1024);
            int count = socketChannel.read(buffer);
            if (count > 0){
                String msg = new String(buffer.array());
                //输出该消息

                System.out.println("from 客户端："+msg.trim());

                //向其他的客户端转发消息
                sendInfoToOtherClients(msg,socketChannel);
            }
        }catch (Exception e){
            try {
                System.out.println(socketChannel.getRemoteAddress()+"离线了");
                key.cancel();
                socketChannel.close();
            }catch (IOException el){
                el.printStackTrace();
            }

        }
    }

    private void sendInfoToOtherClients(String msg,SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中。。。。。");
        //遍历所有注册到selector 上的socketchannel，并排除self
        for (SelectionKey key : selector.keys()){
            Channel tagetChannel = key.channel();
            if (tagetChannel instanceof  SocketChannel&& tagetChannel!=self){
               SocketChannel dest = (SocketChannel)tagetChannel;
               ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
               dest.write(buffer);
            }
        }
    }
    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();

    }
}
