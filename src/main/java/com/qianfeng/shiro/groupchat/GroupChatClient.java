package com.qianfeng.shiro.groupchat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {

    private final String HOST = "127.0.0.1";
    private final int PORT = 6667;
    private static Selector selector;
    private static SocketChannel socketChannel;
    private String username;

    public GroupChatClient () throws Exception{
        selector = Selector.open();
        socketChannel = socketChannel.open(new InetSocketAddress(HOST,PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username+"is ok");

    }

    public void sendInfo(String info){
        info = username+"说"+info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void readInfo(){
        try {
            int readChannels = selector.select();
            if (readChannels > 0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                   SelectionKey key =  iterator.next();
                   if (key.isReadable()){
                       SocketChannel sc = (SocketChannel)key.channel();
                       ByteBuffer buffer = ByteBuffer.allocate(1024);
                       sc.read(buffer);
                       String msg = new String(buffer.array());
                       System.out.println(msg.trim());
                   }
                }
                iterator.remove();
            } else {

            }
        }catch (Exception c){
            c.printStackTrace();
        }

    }
    public static void main(String[] args)throws Exception{
        //qidngkehuduan
        GroupChatClient client = new GroupChatClient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    client.readInfo();
                    try {
                        Thread.sleep(3000);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            client.sendInfo(s);
        }
    }
}
