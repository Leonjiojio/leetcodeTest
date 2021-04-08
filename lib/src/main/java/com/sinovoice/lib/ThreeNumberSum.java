package com.sinovoice.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by  on 2021/4/8.
 **/
class ThreeNumberSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if (nums==null||nums.length<3)return result;

        Arrays.sort(nums);


        int L,R;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i]>0){
                return  result;
            }
            if (i>0&&nums[i]==nums[i-1]) continue;

            L=i+1;
            R=nums.length-1;
            while (L<R){
                int temp=nums[i]+nums[L]+nums[R];
                if (temp==0){
                    List<Integer> r=new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[L]);
                    r.add(nums[R]);
                    result.add(r);

                    //去除重复
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                }else if (temp<0){
                    L++;
                }else{
                    R--;
                }
            }
        }
     return  result;
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums==null||nums.length==0)return  nums;
        int [] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(nums[i])){
                result[0]=map.get(nums[i]);
                result[1]=i;
                return  result;
            }
            map.put(target-nums[i],i);
        }

        return  result;
    }
}
