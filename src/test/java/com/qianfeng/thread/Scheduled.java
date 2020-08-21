package com.qianfeng.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduled {
    private static int pool = 2;
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(pool);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },3,1, TimeUnit.MILLISECONDS);

    }
}
