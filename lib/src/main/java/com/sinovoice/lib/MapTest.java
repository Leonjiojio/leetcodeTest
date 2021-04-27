package com.sinovoice.lib;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by liqiang on 2020/10/23.
 **/
public class MapTest {
    public void test(){
        SynchronousQueue queue=new SynchronousQueue();
        TreeMap<String,String> tree=new TreeMap();
        Map<String, String> map = Collections.synchronizedMap(tree);
//        int a=5;

        int a;
        int b=a=5;
    }

    public static void main(String[] args) {
        String s1="BBCC";
        String s2="AaBb";
        System.out.println("hashCode s1="+s1.hashCode()+",hashcode  s2="+s2.hashCode());

        int n=32;
        System.out.println("result="+(32&n));
    }
}
