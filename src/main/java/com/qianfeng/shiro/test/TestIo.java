package com.qianfeng.shiro.test;

public class TestIo {

  /*  static  volatile  ReadyToRun r = new ReadyToRun.T1;
    public static void main(String[] args) {
        final char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        new Thread(() -> {
            for ( char c : aI){
                while (r != ReadyToRun.T1)
            }
        },"t1").start();
    }*/


    public static void main(String[] args) {
        for (int i = 0; i < 8 ; i++) {

            switch (i){
                case 3:
                    System.out.println(i);
                    break;
                case 4:
                    System.out.println(i);
                    break;
                case 2:
                    System.out.println(i);
                    break;
            }
        }
    }
}
