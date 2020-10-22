package com.sinovoice.lib;

/**
 * Created by liqiang on 2020/9/24.
 **/
public class QuickSort {

    void QuickSort(int[] array,int left,int right)
    {
        if(left >= right)//表示已经完成一个组
        {
            return;
        }
        int index = PartSort(array,left,right);//枢轴的位置
        QuickSort(array,left,index - 1);
        QuickSort(array,index + 1,right);
    }
    int PartSort(int[] array,int left,int right)
    {
        int key = array[right];
        while(left < right)
        {
            while(left < right && array[left] <= key)
            {
                ++left;
            }
            while(left < right && array[right] >= key)
            {
                --right;
            }
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
        }
        array[right]=key;
//        swap(array[left],key);
        return left;
    }
}
