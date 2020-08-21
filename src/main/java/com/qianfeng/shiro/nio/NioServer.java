package com.qianfeng.shiro.nio;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
public class NioServer {
    public static void main(String[] args) throws  Exception{
        //创建serversocketchannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        serverSocketChannel.configureBlocking(false);
        //把我们的serversocketchannel注册到selector关心事件为op-accpet
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            if(selector.select(1000) == 0) {
                System.out.println("服务器等待了一秒钟");
                continue;
            }
            //如果返回的大于零
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeySet.iterator();
            while (iterator.hasNext()){
                //获取到selectkey
                SelectionKey selectionKey = iterator.next();
                if(selectionKey.isAcceptable()){
                    //给该客户端生成一个socketchannel
                    SocketChannel socket = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成了一个socketchannel"+socket.hashCode());
                    socket.configureBlocking(false);
                    //蒋当前的socketchannel注册到selector
                    socket.register(selector, SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                }
                if(selectionKey.isReadable()){
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer attachment = (ByteBuffer) selectionKey.attachment();
                    channel.read(attachment);
                    System.out.println("from 客户端 "+new String(attachment.array()));
                }
                iterator.remove();
            }
        }
    }
}
