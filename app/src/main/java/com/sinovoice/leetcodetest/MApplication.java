package com.sinovoice.leetcodetest;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;

import java.util.List;

/**
 * Created by  on 2021/5/11.
 **/
public class MApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MApplication", "onCreate: pid="+ Process.myPid()+",name="+getProcessName(getApplicationContext(),Process.myPid()));
    }
    private String getProcessName(Context context,int pid){
        ActivityManager manager= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> list = manager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            try {
                ActivityManager.RunningAppProcessInfo info = runningAppProcessInfo;
                if (info.pid == pid) {
                    return info.processName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return "";
    }
}
