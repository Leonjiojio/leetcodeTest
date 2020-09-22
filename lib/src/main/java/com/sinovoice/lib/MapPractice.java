package com.sinovoice.lib;

import java.util.*;

/**
 * Created by liqiang on 2020/9/22.
 **/
public class MapPractice {
    public void test(){

        List<String> vector=new Vector<>();
        vector.add("hello");
        vector.add("my");
        vector.add("name");
        vector.add("is");
        vector.add("lilei");
        HashMap<String,String> hashMap=new HashMap<>();
        Map<String, String> synchMap = Collections.synchronizedMap(hashMap);
        Hashtable<String,String> hashtable=new Hashtable<>();
        HashSet<Integer> hashSet=new HashSet<>();
        TreeSet<Integer> treeSet=new TreeSet<>();

    }
}
