package com.qianfeng.shiro.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condiction = lock.newCondition();
    public static void main(String[] args) {
        lock.lock();
        new Thread(new SignalThread()).start();
        try {
            condiction.await();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        System.out.println("主线程恢复运行！");

    }
    static  class SignalThread implements  Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                condiction.signal();
                System.out.println("子线程通知");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
