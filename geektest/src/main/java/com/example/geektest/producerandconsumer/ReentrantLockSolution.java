package com.example.geektest.producerandconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by  on 2021/4/28.
 **/
class ReentrantLockSolution {

    static ReentrantLock lock=new ReentrantLock();
    Condition notEmpty=lock.newCondition();
    Condition notFull=lock.newCondition();
    Queue<Integer> queue=new LinkedList<>();
    final int MaxSize=10;

    int count =0;
    public static void main(String[] args) {
        ReentrantLockSolution solution=new ReentrantLockSolution();
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
                    lock.lock();
                    if (queue.size()==MaxSize){
                        notFull.wait();
                    }
                    count++;
                    queue.add(count);
                    notEmpty.signal();
                    sleepRandom(500,true);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
                count++;
                System.out.println(Thread.currentThread().getName()+" work result="+count);
            }
        }
    }
    class Consumer implements  Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                int result=0;
                try {
                    lock.lock();
                    if (queue.isEmpty()){
                        notEmpty.wait();
                    }
                    result=queue.remove();
                    notFull.signal();
                    sleepRandom(500,true);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getName()+" work result="+result);
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
