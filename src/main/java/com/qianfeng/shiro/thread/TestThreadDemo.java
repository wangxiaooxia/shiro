package com.qianfeng.shiro.thread;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadDemo {
    //测试 synchronized 的用法
    int count = 0;
    public  synchronized  void  threadDemo(int j){
        count ++;
        int i = 1;
        j = j+i;
        System.out.println(j+count);
    }

    private Lock lock = new ReentrantLock(); //ReentrantLock 是lock的子类
    private void method (Thread thread) {
        lock.lock();
        try {
            thread.run();
            System.out.println("线程名："+Thread.currentThread().getName()+"添加了线程");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("线程名："+Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }


    @Test
    public  void test(){

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ceshi");
            }
        },"t1");
        t.start();
        System.out.println(t.getName());

      //  method(new ThreadTest("ceshi"));
//        for (int i = 0; i < 100 ; i++) {
//            threadDemo(i);
//        }
    }

    class ThreadTest extends  Thread {
        ThreadTest(String name) {
            super(name);
        }

        public void  run(){
            for (int i=1;i<=20 ;i++ ){

                System.out.println(Thread.currentThread().getName()+",i="+i);

            }
        }

    }
}
