package com.sinovoice.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqiang on 2020/9/21.
 **/
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix){

        List<Integer> result=new ArrayList<>();
        int height=matrix.length;
        int width=matrix[0].length;

        if (matrix==null||matrix.length==0||matrix[0].length==0)return result;

        for (int i = 0; i <(Math.min(height,width)+1)/2 ; i++) {

            for (int j = i; j < width-i; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i+1; j <height-i ; j++) {
                result.add(matrix[j][width-i-1]);
            }
            for (int j = width-i-2; j > i; j--) {
                result.add(matrix[height-1-i][j]);
            }
            for (int j = height-1-i; j > i; j--) {
                result.add(matrix[j][i]);
            }

//            for (int j=i; j<width-i; j++) {
//                result.add(matrix[i][j]);
//            }
//            //从上到下遍历“右边”
//            for (int j=i+1; j<height-i; j++) {
//                result.add(matrix[j][(width-1)-i]);
//            }
//            //从右到左遍历“下边”
//            for (int j=i+1; j<width-i; j++) {
//                result.add(matrix[(height-1)-i][(width-1)-j]);
//            }
//            //从下到上遍历“左边”
//            for (int j=i+1; j<height-1-i; j++) {
//                result.add(matrix[(height-1)-j][i]);
//            }
        }


        return result;

    }
    public static void main(String arg[]){
        int[][] matrix = {
                { 1,  2,  3,  4,  5  },
                { 14,  15,  16,  17,  6 },
                { 13, 20, 19, 18, 7 },
                { 12, 11, 10, 9, 8 }
        };
        int[][] matrix2 = {
                { 1,  2,  3,  4,  5  },
                { 16,  17,  18,  19,  6 },
                { 15, 24, 25, 20, 7 },
                { 14, 23, 22, 21, 8 },
                { 13, 12, 11, 10, 9 }
        };
        List<Integer> resultList1 = spiralOrder(matrix2);
        System.out.println(Arrays.toString(resultList1.toArray()));
    }
}
