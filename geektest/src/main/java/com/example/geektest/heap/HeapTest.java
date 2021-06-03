package com.example.geektest.heap;

import java.util.Arrays;

/**
 * Created by  on 2021/6/3.
 **/
public class HeapTest {
    private int[] data;
    private int capacity;
    private int count;

    public HeapTest(int capacity) {
        this.capacity = capacity;
        data=new int[capacity+1];
        count=0;
    }

    public static void main(String[] args) {

        int [] list={0,6,5,4,3,2,1};
        sort(list,6);
        System.out.println("result="+Arrays.toString(list));
    }
    public void  insert(int a){
        if ( count>=capacity)return;
        ++count;
        data[count]=a;
        int i=count;
        while (i/2>0&&data[i/2]<data[i]){
            swap(data,i/2,i);
            i=i/2;
        }
    }

    public void removeMax(){
        if (count==0)return;
        data[1]=data[count];
        count--;
        heapify(data,count,1);
    }

    private static void heapify(int[] data, int n, int i) {
        while (true){
            int maxPosition=i;
            if (i*2<n&&data[i]<data[i*2]){
                maxPosition=i*2;
            }
            if (i*2<n&&data[maxPosition]<data[i*2+1]){
                maxPosition=i*2+1;
            }
            if (maxPosition==i)break;
            swap(data,i,maxPosition);
            i=maxPosition;
        }
    }
    // n
    public static void sort(int[] list,int count){
        buildheap(list,count);
        int k=count;
        while (k>1){
            swap(list,1,k);
            --k;
            heapify(list,k,1);
        }
    }

    private static void swap(int[] data, int i, int i1) {
        int temp=data[i];
        data[i]=data[i1];
        data[i1]=temp;
    }

    private static void buildheap(int[] a,int n){
        for (int i=n/2;i>=1;--i){
            heapify(a,n,1);
        }

    }
}
