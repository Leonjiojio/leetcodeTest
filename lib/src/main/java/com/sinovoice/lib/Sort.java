package com.sinovoice.lib;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by liqiang on 2020/9/7.
 **/
public class Sort {
//    public static int data[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
    private static int data[]={10,9,8,7,6,5,4,3,2,1};

    public static void  insertSort(){
        //时间复杂度O(n^2) O(1)
        int temp=0;
        for (int i = 1; i <data.length ; i++) {
            int j=i-1;//
            temp=data[i];
            for (;j>=0&&temp<data[j];j--){
                data[j+1]=data[j];  //将大于temp的值整体后移一个单位
            }
            data[j+1]=temp;
        }
        printData(data);

    }

    public static void main(String[] args) {
        bubbleSort();
        printf();
    }

    public static  void shellSort(){
        //时间复杂度 = 0(n^1.3-2) O(n·log2n)
        double d1=data.length;
        int temp=0;
        while(true) {
            d1=Math.ceil(d1/2);
            int d=(int)d1;
            for (int i = d; i <data.length ; i++) {
                temp=data[i];
                int j=i-d;
                for (; j >=0&&temp<data[j] ; j-=d) {
                    data[j+d]=data[j];
                }
                data[j+d]=temp;
            }
            if (d==1)break;

        }
        printData(data);
    }

    public static  void selectSort(){
        //时间复杂度O(n^2)
        int position=0;
        for (int i = 0; i < data.length; i++) {
            int temp=data[i];
            position=i;
            int j=i+1;
            for (; j <data.length ; j++) {
                if (data[j]<temp){
                    temp=data[j];
                    position=j;
                }
            }
            data[position]=data[i];
            data[i]=temp;
        }
        printData(data);
    }
    private static int count=0;
    public static  void bubbleSort(){
        int temp=0;

        for (int i = 0; i <data.length-1 ; i++) {
            boolean needQuit=false;
            for (int j = 0; j <data.length-1-i ; j++) {
                count++;
                if (data[j]>data[j+1]){
                    temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                    needQuit=true;
                }
            }
            if (!needQuit)return;

        }
        System.out.println("比较次数"+count);
    }

    public static void  quickSort(){
        //时间复杂度O(nlogn) 空间复杂度 O(nlogn) -o(n)
        if (data.length>0){
            _quickSort(data,0,data.length-1);
        }

    }
    private static  int getMiddle(int[] list,int low,int high){
        int temp=list[low];//数组中的第一个作为中轴
        while (low<high){
            while(low<high&&list[high]>=temp){
                high--;
            }
            list[low]=list[high];//比中轴小的记录移动到低端
            while (low<high&&list[low]<=temp){
                low++;
            }
            list[high]=list[low];
        }
        list[low]=temp;
        return low;
    }
    private   static void _quickSort(int []list,int low,int high){
        if (low<high){
            int middle=getMiddle(list,low,high);//将list数组进行一分二
            _quickSort(list,low,middle-1);
            _quickSort(list,middle+1,high);
        }
    }



    private   static  void printData(int[] data){
        System.out.println(Arrays.toString(data));
    }
    public   static  void printf(){
        System.out.println(Arrays.toString(data));
    }
}
