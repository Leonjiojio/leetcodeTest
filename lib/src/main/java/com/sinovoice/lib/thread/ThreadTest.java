package com.sinovoice.lib.thread;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by liqiang on 2020/10/16.
 **/
public class ThreadTest {




    public static  void main(String args[]){
//        ThreadTest shop=new ThreadTest();
//        Custom tom=new Custom("Tom",shop);
//        Custom amy=new Custom("Amy",shop);
//        tom.start();
//        amy.start();

        FutureTask<String> callable=new FutureTask<>(new MCallAble());
        Thread thread=new Thread(callable);
        thread.start();
        try {
            String result = callable.get();
            System.out.println("resul="+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("this is futuretask test");
    }
    static class  MCallAble implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(500);
            return "Hello call";
        }
    }

      public void pay(){
            for (int i = 0; i <10 ; i++) {
                System.out.print(" "+Thread.currentThread().getName()+"pay$"+i);
            }
            System.out.println(" finish");

    }
    static class Custom extends Thread{
        ThreadTest target;
        public Custom(@NotNull String name,ThreadTest target) {
            super(name);
            this.target=target;
        }

        @Override
        public void run() {
            if (target!=null){
                target.pay();
            }
        }
    }
}
