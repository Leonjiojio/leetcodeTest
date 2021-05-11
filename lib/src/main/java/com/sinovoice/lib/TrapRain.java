package com.sinovoice.lib;

/**
 * Created by  on 2021/5/11.
 **/
class TrapRain {
    public static void main(String[] args) {
//       int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
       int[] height = {1,0,1};
        int result=trap(height);
        System.out.println("result="+result);
    }
    static  public int trap(int[] height) {
        if (height==null||height.length<=2)return  0;
        int result=0;


        int[] left =new int[height.length];
        int[] right =new int[height.length];
        for (int i = 1; i < height.length; i++) {
            left[i]=Math.max(left[i-1],height[i-1]);
        }
        for (int i = height.length-2; i >=0 ; i--) {
            right[i]=Math.max(right[i+1],height[i+1]);
       }

        for (int i = 0; i <height.length ; i++) {
            int level=Math.min(left[i],right[i]);
            result+=Math.max(0,level-height[i]);
        }

        return result;
    }
}
