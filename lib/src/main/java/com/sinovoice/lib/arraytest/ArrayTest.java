package com.sinovoice.lib.arraytest;

/**
 * Created by  on 2021/3/4.
 **/
class ArrayTest {
    public static void main(String[] args) {
        int[][] array = {
                {1, 3, 9, 15},
                {2, 4, 11, 21},
                {3, 8, 14, 26},
                {7, 20, 25, 30}
        };

        long start=System.nanoTime();
        int target=30;
        System.out.println(target+" inside "+isInside(target,array));
        long spend=System.nanoTime()-start;
        System.out.println("spend "+spend+" ns");
    }

    public static  boolean  isInside2(int target,int [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                if (target==array[i][j])return true;
            }
        }
        return  false;
    }

    public static  boolean  isInside(int target,int [][] array){
        int row = array.length -1;
        int cols = array[0].length - 1;
        int i=cols;
        int j=0;
        while (i >=0 && j <= row ) {  //从左下角开始遍历
            if (target > array[i][j]) {   //大于num，下标往右移动一位
                j++;
            } else if(target < array[i][j]) {  //小于num，下标往上移动一位
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
