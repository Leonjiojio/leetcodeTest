package com.example.geektest.producerandconsumer;


import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by  on 2021/4/28.
 **/
class ProduceConsumer {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static  Queue<Integer> queue =new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        ProduceConsumer test1 = new ProduceConsumer();
        new Thread(test1.new Producer(),"Producer").start();
        new Thread(test1.new Consumer(),"Consumer1").start();
        new Thread(test1.new Consumer(),"Consumer2").start();
        new Thread(test1.new Consumer(),"Consumer3").start();
    }
    class Producer implements  Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                synchronized (queue){
                    while (queue.size()==FULL){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    queue.add(count);
                    queue.notifyAll();
                    System.out.println("Producer work count="+count);
                }

                try {
                    Thread.sleep(50);
//                    Thread.sleep(new Random().nextInt(500)+10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements  Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (queue){
                    while (queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int result=queue.poll();
                    System.out.println(Thread.currentThread().getName()+" work result="+result);
                    queue.notifyAll();

                }
                try {
                    Thread.sleep(new Random().nextInt(500)+10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
