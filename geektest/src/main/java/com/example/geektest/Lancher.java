package com.example.geektest;

import com.example.geektest.queuetest.RecycleQueue;

/**
 * Created by  on 2021/4/22.
 **/
class Lancher {
    public static void main(String[] args) {
        RecycleQueue<Integer> queue=new RecycleQueue<>(5);

        for (int i = 0; i < 6; i++) {
            queue.enQueue(i);
        }
        Integer result;
        while ((result=queue.deQueue())!=null){
            System.out.println("result="+result);
        }

    }
}
