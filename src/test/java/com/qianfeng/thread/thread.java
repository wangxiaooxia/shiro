package com.qianfeng.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class thread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5 ; i++) {
            executorService.execute(new TestNewRunable());
        }
    }
}
class TestNewRunable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}