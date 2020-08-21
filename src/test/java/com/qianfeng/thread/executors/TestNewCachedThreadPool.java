package com.qianfeng.thread.executors;

import java.util.concurrent.*;

public class TestNewCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i <= 10; i++) {
            final  int index = i;
            try {
                Thread.sleep(index*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行：" + index + "，线程名称：" + Thread.currentThread().getName());
                }
            });
        }
    }

    private void ceshi(){
        //      第一种方式
//  ExecutorService executor = Executors.newCachedThreadPool();
//        Task task = new Task();
//        Future<Integer> result = executor.submit(task);
//        executor.shutdown();
        //第二种方式
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程在执行任务");
        try {
            System.out.println("task执行结果："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}
class Task implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("子线程在进行计算");
        try {
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum+=i;
            }
            return sum;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}