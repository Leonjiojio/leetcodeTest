package com.example.geektest.producerandconsumer;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by  on 2021/4/28.
 **/
class BlockingQueueSolution {
    final int MAXSIZE=10;
    LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<>(MAXSIZE);
    static  int count;

    public static void main(String[] args) {
        BlockingQueueSolution solution=new BlockingQueueSolution();
        new Thread(solution.new Producer(),"Producer").start();
        new Thread(solution.new Consumer(),"Consumer1").start();
        new Thread(solution.new Consumer(),"Consumer2").start();
        new Thread(solution.new Consumer(),"Consumer3").start();

    }

    class Producer implements  Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 30 ; i++) {
                try {
                    count++;
                    queue.put(count);
                    sleepRandom(500,true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" work result="+count);
            }
        }
    }
    class Consumer implements  Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10 ; i++) {
                try {
                    int result=queue.take();
                    sleepRandom(500,true);
                    System.out.println(Thread.currentThread().getName()+" work result="+result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static Random random=new Random();
    private static  void sleepRandom(int bound, boolean isRandom){
        try {
            if (isRandom){
                Thread.sleep(random.nextInt(bound)+10);
            }else {
                Thread.sleep(bound);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
