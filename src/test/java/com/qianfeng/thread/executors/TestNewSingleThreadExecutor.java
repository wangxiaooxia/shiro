package com.qianfeng.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNewSingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i <= 10 ; i++) {
            final  int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行：" + index + "，线程名称：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        
    }
}
