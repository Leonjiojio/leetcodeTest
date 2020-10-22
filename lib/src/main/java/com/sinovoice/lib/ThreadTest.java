package com.sinovoice.lib;

import org.jetbrains.annotations.NotNull;

/**
 * Created by liqiang on 2020/10/16.
 **/
public class ThreadTest {




    public static  void main(String args[]){
        ThreadTest shop=new ThreadTest();
        Custom tom=new Custom("Tom",shop);
        Custom amy=new Custom("Amy",shop);
        tom.start();
        amy.start();

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
