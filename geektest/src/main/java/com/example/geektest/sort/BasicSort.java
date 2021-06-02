package com.example.geektest.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by  on 2021/4/23.
 **/
class BasicSort {
    public static int data[]={10,9,8,7,6,5,4,3,2,1};
//    public static int data[]={1,2,3,4,5,6,7,8,9,10};


     static class MInteger {
        int value;
        String name;

        public MInteger(int value, String name) {
            this.value = value;
            this.name = name;
        }

         @Override
         public String toString() {
             return "name:"+name+"-value:"+value;
         }
     }

    /**
     *
     // 归并排序算法, A是数组，n表示数组大小
     merge_sort(A, n) {
     merge_sort_c(A, 0, n-1)
     }

     // 递归调用函数
     merge_sort_c(A, p, r) {
     // 递归终止条件
     if p >= r  then return

     // 取p到r之间的中间位置q
     q = (p+r) / 2
     // 分治递归
     merge_sort_c(A, p, q)
     merge_sort_c(A, q+1, r)
     // 将A[p...q]和A[q+1...r]合并为A[p...r]
     merge(A[p...r], A[p...q], A[q+1...r])
     }
     */
    private  static  void mergSort(int[] data){
        _mergSort(data,0,data.length-1);
    }
    private  static  void _mergSort(int[] data,int start,int end){
        if (start>=end)return;
        int middle=start+(end-start)/2;
        _mergSort(data,start,middle);
        _mergSort(data,middle+1,end);
        mergdata(data,start,middle,end);
    }
    private  static  void mergdata(int[] data,int left,int center,int right){
        int []temp=new  int[data.length];

        int middle=center+1;
        int index=left;
        int tmp=left;

        while (left<=center&&middle<=right){
            if (data[left]<data[middle]){
                temp[index++]=data[left++];
            }else {
                temp[index++]=data[middle++];
            }
        }

        //将剩余部分放入数组


        while (middle<=right){
            temp[index++]=data[middle++];
        }
        while (left<=center){
            temp[index++]=data[left++];
        }

        //讲数组拷贝回去
        while (tmp<=right){
            data[tmp]=temp[tmp++];
        }

    }

    private  static  void quickSort(int[] data){
        _quickSort(data,0,data.length-1);
    }
    private static  void _quickSort(int[] data,int left,int right){
        if (left<right){
            int pivot=getPivot(data,left,right);
            _quickSort(data,left,pivot-1);
            _quickSort(data,pivot+1,right);
        }
    }
    private static int getMidIntIN3(int a,int b,int c){
        if (a==b&&b==c)return  a;
        if (a==b||b==c||a==c){
            return a;
        }
        if (a<b){
            if (a>c){
                return a;
            }else{
                return  b<c?b:c;
            }
        }else{
            if (b>c){
                return b;
            }else{
                return c<a?c:a;
            }
        }

    }

    private static void dealPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;

        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }
        // 将中值放到左边
        swap(arr, left, mid);
    }
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static  int getPivot(int[] data,int left,int right){
        //三数取中
        dealPivot(data,left,right);
        int temp=data[left];

        //随机法
//        int index=left+new Random().nextInt(right-left);
//        swap(data,index,left);
//        int temp= data[left];

        while (left<right){
            while (left<right&&data[right]>=temp){
                right--;
            }
            data[left]=data[right];

            while (left<right&&data[left]<=temp){
                left++;
            }
            data[right]=data[left];

        }
        data[left]=temp;

        return  left;
    }
    private static  int getPivotRevet(int[] data,int left,int right){
        int temp=data[left];
        while (left<right){
            while (left<right&&data[right]<=temp){
                right--;
            }
            data[left]=data[right];

            while (left<right&&data[left]>=temp){
                left++;
            }
            data[right]=data[left];

        }
        data[left]=temp;

        return  left;
    }

    private static  int getTopNum(int[] data,int level){
        if (data==null)return level;
        if (level>data.length||level<0)return level;
        return getTopNum(data,0,data.length-1,level);
    }
    private static  int getTopNum(int[] data,int left,int right,int level){
        if (left<right){
            int pivot=getPivotRevet(data,left,right);
            if (pivot+1==level)return data[pivot];
            if (pivot+1>level){
                return getTopNum(data,left,pivot-1,level);
            }else{
                return getTopNum(data,pivot+1,right,level);
            }
        }
        return 0;
    }


    private  static  void bubbleSort(int[] data){
        if (data==null)return;
        int n=data.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-1-i ; j++) {
                if (data[j]>data[j+1]){
                    temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }
        }
    }
    private static  void selectSort(int[] data){
        if (data==null)return;
        int min;
        int position=0;
        for (int i = 0; i <data.length ; i++) {
            min=data[i];
            position=i;
            for (int j = i+1; j <data.length ; j++) {
                if (data[j]<min){
                    min=data[j];
                    position=j;
                }
            }
            data[position]=data[i];
            data[i]=min;

        }
    }
    /*
    验证稳定性
     */
    private static  void selectSort2(MInteger[] data){
        if (data==null)return;
        MInteger min;
        int position=0;
        for (int i = 0; i <data.length ; i++) {
            min=data[i];
            position=i;
            for (int j = i+1; j <data.length ; j++) {
                if (data[j].value<min.value){
                    min=data[j];
                    position=j;
                }
            }
            data[position]=data[i];
            data[i]=min;

        }
    }

    private static  void shellSort(int[] data){
        if (data==null)return;

        double d1= data.length;
        while (true){
            d1=Math.ceil(d1/2);
            int d=(int)d1;

            int temp;
            for (int i = d; i <data.length ; i++) {
                int j=i-d;
                temp=data[i];
                for (; j >=0&&temp<data[j]; j-=d) {
                    data[j+d]=data[j];//往后移动
                }
                data[j+d]=temp;

            }

            if (d==1)break;

        }


    }

    private static  void insertSort(int[] data){
        if (data==null)return;
        int n=data.length;
        int temp;
        for (int i = 1; i <data.length ; i++) {
            int j=i-1;
            temp=data[i];
            for (; j >=0&&temp<data[j]; j--) {
                data[j+1]=data[j];//往后移动
            }
            data[j+1]=temp;
        }
    }

    private  static  MInteger[] getMinteger(){
        MInteger[] result=new MInteger[10];
        for (int i = 0; i < result.length; i++) {
            result[i]=new MInteger(i,i+"");
        }
        result[9].value=1;
        result[8].value=1;
        result[7].value=2;
        result[6].value=2;
        return  result;
    }
    public static void main(String[] args) {
        quickSort(data);
        System.out.println(Arrays.toString(data));
//        MInteger[] mdata = getMinteger();
//        selectSort2(mdata);
//        System.out.println(Arrays.toString(mdata));

//        int leve=4;
//        int result=getTopNum(data,leve);
//        System.out.println("top "+leve+" in data is "+result);
    }
}
