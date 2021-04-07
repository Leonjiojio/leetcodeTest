package com.sinovoice.lib.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * Created by liqiang on 2020/10/28.
 **/
public class ThreadExecutorTest {
    public static  void main(String args[]){
//        ExecutorService SingleThreadExecutor=  Executors.newSingleThreadExecutor();//单个线程的线程池，即线程池中每次只有一个线程工作，单线程串行执行任务
        ExecutorService FixedThreadPool=  Executors.newFixedThreadPool(5);//固定数量的线程池，没提交一个任务就是一个线程，直到达到线程池的最大数量，然后后面进入等待队列直到前面的任务完成才继续执行
//        ExecutorService CachedThreadPool=  Executors.newCachedThreadPool();//可缓存线程池，当线程池大小超过了处理任务所需的线程，那么就会回收部分空闲（一般是60秒无执行）的线程，当有任务来时，又智能的添加新线程来执行。
//        ExecutorService ScheduledThreadPool=  Executors.newScheduledThreadPool(6);//大小无限制的线程池，支持定时和周期性的执行线程


//        for (int i = 0; i <5 ; i++) {
//            FixedThreadPool.execute(new TestRunable());
//            System.out.println("************* execute " + i + " *************");
//        }

        List<Future<String>> resultList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("************* create task " + i + " *************");
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = FixedThreadPool.submit(new TaskWithResult(System.out::println));
            //将任务执行结果存储到List中
            resultList.add(future);
//            try {
//                System.out.println("future get :result="+future.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
        }

//        for (Future<String> future:resultList  ) {
//            try {
//                System.out.println("result="+future.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }

        FixedThreadPool.shutdown();
    }
    static class  TestRunable implements  Runnable{

        int i;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" was called");
            while (i<3){
                try {
                    Thread.sleep(2000);
                    System.out.println("current threadName "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }
    static  class TaskWithResult implements Callable<String>{
        MCallBack callBack;

        public TaskWithResult(MCallBack callBack) {
            this.callBack = callBack;
        }

        int i;
        @Override
        public String call() throws Exception {
            System.out.println("current threadName "+Thread.currentThread().getName()+" is working");
            while (i<3){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;

            }
            System.out.println("current threadName "+Thread.currentThread().getName()+" work finished");
            String result="Result:"+Thread.currentThread().getName();
            callBack.onResult(result);
            return result;
        }
    }
}
