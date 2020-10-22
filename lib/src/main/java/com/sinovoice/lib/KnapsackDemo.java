package com.sinovoice.lib;

/**
 * Created by liqiang on 2020/9/24.
 **/
public class KnapsackDemo {

    public static void main(String []args) {
        System.out.println("KnapsackDemo!!!");
        int[] w = {2,2,6,5,4};
        int[] v = {6,3,5,4,6};
        int c = 10;
        int[][] m;
        int[] x;
        m = KnapsackDemo.knapsack(w,v,c);
        x = KnapsackDemo.buileSolution(m,w,c);

        for(int i=0;i<4;i++){
            System.out.print(x[i]+"  ");
        }
    }

    //0-1背包问题的算法
    public static int[][] knapsack(int[] w,int[] v,int c){
        int i,j,n = w.length;
        int[][] m = new int[n+1][c+1];

        for(i=1;i<n+1;i++){
            m[i][0]=0;
        }

        for(j=0;j<c+1;j++){
            m[0][j]=0;
        }

        int count=0;

        for(i=1;i<=n;i++){
            for(j=1;j<=c;j++){
                m[i][j] = m[i-1][j];
                if(w[i-1]<=j){
                    if(v[i-1]+m[i-1][j-w[i-1]]>m[i-1][j]){
                        m[i][j]=v[i-1]+m[i-1][j-w[i-1]];
                    }
                }
                count++;
            }
        }
        System.out.println(count);
        return m;
    }

    //依据m[][]实现对符合结果要求的物品进行选择的构建一个数组存储选择的情况0否1选择
    public static int[] buileSolution(int[][] m,int[] w,int c){
        int i,j = c,n = w.length;
        int[] x = new int[n];
        for(i=n;i>=1;i--){
            if(m[i][j]==m[i-1][j]){
                x[i-1] = 0;
            }else{
                x[i-1]=1;
                j -= w[i-1];
            }
        }
        return x;
    }

}
