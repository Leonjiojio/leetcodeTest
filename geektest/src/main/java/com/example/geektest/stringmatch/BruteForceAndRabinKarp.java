package com.example.geektest.stringmatch;

/**
 * Created by  on 2021/6/8.
 **/
class BruteForceAndRabinKarp {
    public static void main(String[] args) {
        int index=bf("eeabc".toCharArray(),"abc".toCharArray());
        System.out.print("index ="+index);//result=2

    }
    //返回起始下标
    static int bf(char [] a,char []pattern){
        int n=a.length;
        int m=pattern.length;
        int j=0;
        for (int i = 0; i < n-m+1; ++i) {
            while (j<m){
                if (a[i+j]!=pattern[j]){
                    break;
                }
                j++;
            }
            if (j==m){
                return i;
            }
        }
        return  -1;
    }
}
