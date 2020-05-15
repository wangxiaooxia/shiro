package com.qianfeng.shiro.reentrantLock;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo(lock1,lock2));
        Thread thread1 = new Thread(new ThreadDemo(lock2,lock1));
        thread.start();
        thread1.start();
        thread.interrupt();
    }

    static class ThreadDemo implements  Runnable {
        Lock firstLock;
        Lock secondLock;

        public ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run() {
            try {
                firstLock.lockInterruptibly();
                TimeUnit.MILLISECONDS.sleep(10);
                secondLock.lockInterruptibly();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName()+"正常结束！");
            }
        }
    }
}
