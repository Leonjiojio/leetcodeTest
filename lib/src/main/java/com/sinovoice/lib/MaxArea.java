package com.sinovoice.lib;

/**
 * Created by liqiang on 2020/9/10.
 **/
public class MaxArea {
    public static  int maxArea(int[] height) {
        int size =height.length;
        int left=0;
        int right=size-1;
        int ans=0;
        while (left<right){
            ans=Math.max(ans,(right-left)*Math.min(height[left],height[right]));
            if (height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return  ans;

    }
}
