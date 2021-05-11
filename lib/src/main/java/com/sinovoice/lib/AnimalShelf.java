package com.sinovoice.lib;

import java.util.LinkedList;

/**
 * Created by  on 2021/5/11.
 **/
class AnimalShelf {
    int count=0;
    private LinkedList<int[]> animalQueue=new LinkedList<>();
    public AnimalShelf() {

    }

    public void enqueue(int[] animal) {
        if (count>=20000)return;

        animalQueue.offer(animal);
        count++;
    }

    public int[] dequeueAny() {
        int[] result= animalQueue.poll();
        if (result!=null){
            count--;
        }else{
            result= new int[]{-1, -1};
        }
     return result;
    }

    public int[] dequeueDog() {
        for (int i = 0; i <animalQueue.size() ; i++) {
            int[] a=animalQueue.get(i);
            if (a[1]==1){
                animalQueue.remove(i);
                count--;
                return a;
            }
        }
        return new int[]{-1,-1};
    }

    public int[] dequeueCat() {
        for (int i = 0; i <animalQueue.size() ; i++) {
            int[] a=animalQueue.get(i);
            if (a[1]==0){
                animalQueue.remove(i);
                count--;
               return  a;
            }
        }
        return new int[]{-1,-1};
    }
}
