package com.qianfeng;

public class TestSingleton1 {
    public static void main(String[] args) {
            for (int i = 0; i < 100000; i++) {
                final Thread ti = new Thread(new ThreadSingleton());
                ti.setName("thread"+i);
                ti.start();
            }
    }
    public static  class ThreadSingleton implements Runnable{

        @Override
        public void run() {
            TestVolatileSingle testVolatileSingle =  TestVolatileSingle.getInstance();
        }
    }
}
