package com.qianfeng.thread.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestNewScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(5);
        scheduledExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("表示延迟3秒执行。");
            }
        },3, TimeUnit.SECONDS);

        scheduledExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("表示延迟1秒后每3秒执行一次。");
            }
        },1,3,TimeUnit.SECONDS);
    }
}
