package com.sinovoice.leetcodetest;

import android.app.Activity;
import android.os.Message;
import android.util.SparseArray;

/**
 * Created by  on 2021/5/12.
 **/
public class ActivityManager {
    private volatile static  ActivityManager instance;
    private int count=0;
    private SparseArray<Activity> activitys=new SparseArray<>();
    private ActivityManager(){

    }

    public void addActivity(Activity activity){
        activitys.put(count++,activity);
    }

    public static ActivityManager getInstance() {
        if (instance==null){
            synchronized (ActivityManager.class){
                if (instance==null){
                    instance=new ActivityManager();
                }
            }
        }
        return instance;
    }
    private void test(){
        Message msg=new Message();
    }
}
