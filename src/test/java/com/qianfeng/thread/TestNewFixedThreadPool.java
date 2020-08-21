package com.qianfeng.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNewFixedThreadPool {
    private static int pool = 2;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(pool);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new TestRunable());
        }
        executorService.shutdown();
    }
}

class TestRunable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}