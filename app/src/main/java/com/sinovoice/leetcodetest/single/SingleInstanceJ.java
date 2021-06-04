package com.sinovoice.leetcodetest.single;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by  on 2021/6/4.
 **/
public class SingleInstanceJ implements Serializable {
    private static volatile SingleInstanceJ instanceJ;
    private static  volatile boolean initFlag=false;
    private SingleInstanceJ(){
        synchronized (SingleInstanceJ.class){
            if (initFlag){
                throw  new RuntimeException("!!!");
            }
            initFlag=true;
        }
    }
    private static  SingleInstanceJ getInstance(){
        if (instanceJ==null){
            synchronized (SingleInstanceJ.class){
                if (instanceJ==null){
                    instanceJ=new SingleInstanceJ();
                }
            }
        }
        return instanceJ;
    }

    public  SingleInstanceJ readResolve(){
        return  instanceJ;
    }
    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instanceJ;
    }
}
