package com.sinovoice.lib.thread;

import java.lang.ref.SoftReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by  on 2021/5/14.
 **/
class ThreadLocalTest {
    private static  ThreadLocal<Integer> threadLocals=new ThreadLocal<>();



    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+" get value="+threadLocals.get());


        ExecutorService threadPoolExecutor= Executors.newFixedThreadPool(5);
        AtomicInteger integer=new AtomicInteger(0);
        for (int i=0; i <5 ; i ++) {
            threadPoolExecutor.execute(() -> {
                final  int value=integer.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+" set value="+value);
                threadLocals.set(value);
            });
        }
        Thread.sleep(50);
        System.out.println("==================");

        for (int i=0; i <5 ; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName()+" get value="+threadLocals.get());
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        threadPoolExecutor.shutdown();
        SoftReference<Integer> softReference=new SoftReference<>(1);

        softReference.get();

    }
}
