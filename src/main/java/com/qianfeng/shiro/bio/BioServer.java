package com.qianfeng.shiro.bio;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
     ServerSocket serverSocket =  new ServerSocket(6666);
        System.out.println("服务器已经启动。。。。");
        while (true){
            final  Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }
    public static  void handler(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
               int read =  inputStream.read(bytes);
               if (read != -1 ){
                   System.out.println(new String(bytes,0,read));
               } else {
                   break;
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭连接");
            socket.close();
        }
    }
}


