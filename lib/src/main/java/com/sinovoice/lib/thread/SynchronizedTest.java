package com.sinovoice.lib.thread;

import com.sinovoice.lib.Main;

/**
 * Created by  on 2021/5/28.
 **/
class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizedTest synchronizedTest=new SynchronizedTest();
        Thread t1=new Thread(() -> synchronizedTest.test1());
        Thread t2=new Thread(() -> {
            for (int i = 0; i <5 ; i++) {
                synchronizedTest.print(i);
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
    public  synchronized void test1(){
        for (int i = 0; i < 5; i++) {
            print(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private  final Object lock=new Object();
    public  void  print(int value){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+":value="+value);
        }
    }

}
