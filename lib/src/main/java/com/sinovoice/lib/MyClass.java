package com.sinovoice.lib;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyClass {
    public static void main(String args[]) {
//        int length = lengthOfLongestSubstring("abccdefgabcddebc");
//        String sts[]={"flower","flow","flight"};
//        String commonPrefix=longestCommonPrefix(sts);
//        double result = MyMath.sqrt(17*17);
        double result = Roma.romanToInt("MCMXCIV");
        System.out.println("result=" + result);
//        Sort.insertSort();
//        Sort.quickSort();
//        Sort.printf();
//        int result=MyMath.Gcd_2(156225896,8821586);
//        System.out.println("result="+result);
    }
    public static  String longestCommonPrefix(String[] strs) {

        if(strs==null||strs.length==0)return "";
        String result=strs[0];
        for (int i = 1; i <strs.length ; i++) {

            for (int j = 0; j < result.length(); j++) {
                if (j>=strs[i].length())break;

                if (result.charAt(j)!=strs[i].charAt(j)){
                    if (j==0)return "";
                    result=result.substring(0,j);
                    break;
                }
            }
        }
        return  result;
    }

//    public int[] topKFrequent(int[] nums, int k) {
//
//    }

    public static int sqrt(int x){
        if (x<0)return 0;
        double err=1e-15;
        double t=x;
        while (Math.abs(t-x/t)>err*t){
            t=(x/t+t)/2.0;
        }
        return (int)t;


    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
//        for (int start = 0; start <s.length() ; start++) {
//
//            for (int end = start + 1; end < s.length(); end++) {
//
//                if (allUnique(s,start,end)) length=Math.max(length,end-start);
//            }
//        }

//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, start = 0, end = 0;
//        while (start < n && end < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(end))) {
//                set.add(s.charAt(end++));
//                ans = Math.max(ans, end - start);
//            } else {
//                set.remove(s.charAt(start++));
//            }
//        }
        int n = s.length();
        int   ans = 0;
         Map<Character, Integer> map = new HashMap<>(); // current index of character
         // try to extend the range [i, j]
         for (int j = 0, i = 0; j < n; j++) {
                 if (map.containsKey(s.charAt(j))) {
                         i = Math.max(map.get(s.charAt(j)), i);
                     }
                  ans = Math.max(ans, j - i + 1);
                  map.put(s.charAt(j), j + 1);
              }
          return ans;

    }

    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
