package com.sinovoice.lib;

/**
 * Created by  on 2021/6/1.
 **/
public class Fibonacci {
    //0 1 1 2 3 5 8 13
    public static void main(String[] args) {
        int result=fib(6);
         result=fib(0,1,6);
      System.out.println("result:"+result);
    }

    private static   int fib(int n){
        if (n==0)return 0;
        if (n<=2)return 1;
        return fib(n-1)+fib(n-2);
    }
    //尾递归实现
    private static int fib(int first,int  second,int n)
    {
        if(n<2)
        {
            return n;
        }
        if(2 == n)
        {
            return first+second;
        }
        return fib(second,first+second,n-1);
    }
}
