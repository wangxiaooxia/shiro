package com.qianfeng.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTest1 {
    public static void main(String[] args) {
        Sell1 sell = new Sell1();
        Thread thread = new Thread(sell,"thread1");
        Thread thread1 = new Thread(sell,"thread2");
        thread.start();
        thread1.start();
    }



}

class  Sell implements Runnable {
    int count = 20;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+":"+(count--));
            lock.unlock();
        }
    }
}

class Sell1 implements Runnable {

    int count = 20;
    Lock lock = new ReentrantLock();
    @Override
    public void run() { // TODO Auto-generated method stub
        for (int i = 10; i > 0; i--) {
            synchronized (Thread.currentThread()) {
                System.out.println(Thread.currentThread().getName() + ":"
                        + (count--));

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }
        }

    }
}