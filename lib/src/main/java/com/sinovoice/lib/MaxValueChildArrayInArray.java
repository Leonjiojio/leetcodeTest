package com.sinovoice.lib;

/**
 * Created by  on 2021/4/7.
 **/
class MaxValueChildArrayInArray {
    public static void main(String[] args) {
        new MaxValueChildArrayInArray().test();
    }

    public void test(){
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result=calMaxSumOfArray(nums);
        System.out.println("result="+result);
    }

    public int calMaxSumOfArray(int[] a) {
        int left=0,right=0;
        if (null == a) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }
        int sum = a[0];
        int temp = a[0];
        for (int i = 1; i < a.length; i++) {
            temp = max(temp + a[i], a[i]);
            if (temp==a[i]){
                left=i;
            }
            if (sum < temp) {
                sum = temp;
                right=i;
            }
        }
        System.out.println("left="+left+",right="+right);
        return sum;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
