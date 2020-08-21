package com.qianfeng.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = 1;
            try {
                Thread.sleep(index*1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
        executorService.shutdown();
    }

}
