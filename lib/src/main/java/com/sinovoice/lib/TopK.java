package com.sinovoice.lib;

import java.util.*;

/**
 * Created by liqiang on 2020/9/15.
 **/
public class TopK {
    public List<Integer> solutionByHeap(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>();
//        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num){
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }
    public int[] smallestK(int[] input, int k) {
        if (input.length==0||k==input.length)return  input;
        if (k==0)return new int[]{};


        return  input;
    }

}
