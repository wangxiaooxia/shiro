package com.qianfeng.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable {
    @Override
    public Object call() {
        return "hello world! ";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new TestCallable());
        new Thread(futureTask).start();

        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
