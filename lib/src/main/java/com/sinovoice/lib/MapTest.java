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
}
