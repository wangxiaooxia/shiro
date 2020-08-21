package com.qianfeng.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    threadRunMethod(index);
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    threadRunMethod(index);
                }
            });
        }
        executorService.shutdown();
    }

    private static void threadRunMethod(int index){
        System.out.println(index);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
