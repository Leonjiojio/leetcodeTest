package com.sinovoice.lib;

/**
 * Created by liqiang on 2020/9/7.
 **/
public class MyMath {
    public static int  sqrt(int c){
        //牛顿迭代法
//        long s=System.currentTimeMillis();
//        if (x<0) return 0;
//        int r = x;
//        while (r > x / r){
//            r = (r + x / r) / 2;
//        }
//
//        System.out.println("spend time"+(System.currentTimeMillis()-s));
//        return r;
        double e = 1e-15;
        double x = c;
        double y = (x + c / x) / 2;
        while (Math.abs(x - y) > e) {
            x = y;
            y = (x + c / x) / 2;
        }
        return (int)x;

    }

    public  static int Gcd_2(int a,int b)/*欧几里德算法求a,b的最大公约数*/
    {
        if (a<=0 || b<=0)/*预防错误*/
            return 0;
        int temp;
        while (b > 0)/*b总是表示较小的那个数，若不是则交换a，b的值*/
        {
            temp = a % b;/*迭代关系式*/
            a = b;
            b = temp;
        }
        return a;
    }
}
