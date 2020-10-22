package com.sinovoice.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by liqiang on 2020/10/15.
 **/
public class RemoveEventNumbers {

    public static void main(String args[]){

        ArrayList<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(1);
        list.add(8);
        removeTest2(list);

    }
    private static void removeTest(ArrayList<Integer> list){
        if (list==null)return;
        Iterator<Integer> iterator=list.iterator();
        while (iterator.hasNext()){
            if (iterator.next()%2==0){
                iterator.remove();
            }
        }
        System.out.print(Arrays.asList(list));
    }
    private static void removeTest2(ArrayList<Integer> list){
        if (list==null)return;
        for (int i = list.size()-1; i >0 ; i--) {
            if (list.get(i)%2==0){
                list.remove(i);
            }
        }
        System.out.print(Arrays.asList(list));
    }
}
