package com.qianfeng;

public class TestVolatileSingle {
    private static volatile TestVolatileSingle testVolatile;
    private TestVolatileSingle(){}
    public static TestVolatileSingle getInstance(){
        if (testVolatile == null) {
            synchronized (TestVolatileSingle.class) {
                if (testVolatile == null) {
                    testVolatile = new TestVolatileSingle();
                    System.out.println(Thread.currentThread().getName()+": uniqueInstance is initalized...");
                } else {
                    System.out.println(Thread.currentThread().getName() + ": uniqueInstance is not null now..."); //#5.2
                }
            }
        }
        return testVolatile;
    }
}
