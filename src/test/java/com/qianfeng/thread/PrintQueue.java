package com.qianfeng.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private final Lock  queueLock = new ReentrantLock();
    private void printJob(Object document){
        queueLock.lock();
        Long duration = (long)(Math.random()*10000);
        System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",Thread.currentThread().getName(),(duration/1000));
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }
    }
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        printQueue.printJob("helleo");
    }
}
