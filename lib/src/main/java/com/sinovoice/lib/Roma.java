package com.sinovoice.lib;

import java.util.HashMap;

/**
 * Created by liqiang on 2020/9/11.
 **/
public class Roma {
    public  static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res= new StringBuilder();
        for(int i=0; i<values.length; i++){
            while(num>=values[i]){
                num -= values[i];
                res.append(reps[i]);
            }
        }
        return res.toString();
    }
    public  static int romanToInt(String roman) {

        int result=0;
        for(int i=0; i<roman.length(); i++){
             int value=getValue(roman.charAt(i));
             int next=i==roman.length()-1?0:getValue(roman.charAt(i+1));
             if (value>=next){
                 result+=value;
             }else{
                 result+=next-value;
                 i++;
             }
        }
        return result;
    }
    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
