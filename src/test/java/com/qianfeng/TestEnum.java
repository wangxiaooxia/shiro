package com.qianfeng;

public class TestEnum {
    public static void main(String[] args) {
        System.out.println("state.success = " + state.success+state.failure+state.padding);
    }
}
enum state {
    success,failure,padding;
}