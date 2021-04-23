package com.example.geektest.queuetest;

/**
 * Created by  on 2021/4/22.
 **/
public class RecycleQueue<T> {
    private Object[] data;
    private int capacity;

    private int head=0;
    private int tail=0;
    public RecycleQueue(int capacity) {
        this.capacity = capacity;
        data=new Object[capacity];
    }

    public boolean enQueue(T t){
        if ((tail+1)%capacity==head)return false;//满了
        data[tail]=t;
        tail++;
        tail=tail%capacity;
        return  true;
    }

    public T deQueue(){
        if (head==tail){
            //空的
            return null;
        }
        Object ret=data[head];
        head++;
        head%=capacity;
        return (T)ret;
    }
}
