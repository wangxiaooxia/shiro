package com.qianfeng.suanfa;
public class TestPaixu {
    public static void main(String[] args) {
        testMaopao2();
    }
    //first method
    private void testMaopao(){
        Integer arrs[] = {2,3,12,45,22,45};
        for (int i = 0; i <arrs.length ; i++) {
            for (int j = 0; j < arrs.length -i-1; j++) {
                if (arrs[j]>arrs[j+1]){
                    int temp = arrs[j];
                    arrs[j] = arrs[j+1];
                    arrs[j+1] = temp;
                }
            }
        }
        for (int num:arrs){
            System.out.println(num+" ");
        }
    }

    //first method 2
    private static void testMaopao2(){
        boolean flag = false;
        int temp;
        Integer nums[] = {2,3,12,45,22,45};
        while(! flag){
            flag = true;
            for (int i=1; i<nums.length; i++){
                if(nums[i] < nums[i-1]){
                    temp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                    flag = false;
                }
            }
        }
        for (int num:nums){
            System.out.println(num+" ");
        }
    }
}
