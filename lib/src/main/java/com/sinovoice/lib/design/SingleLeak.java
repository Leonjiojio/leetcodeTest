package com.sinovoice.lib.design;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * Created by  on 2021/5/11.
 **/
public class SingleLeak implements Serializable ,Cloneable{


    static SingleLeak instance;
    private SingleLeak(){}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //双重检查加锁
    public static SingleLeak getInstance() {
        if (instance==null){
            synchronized (SingleLeak.class){
                if (instance==null){
                    instance=new SingleLeak();
                }
            }
        }
        return instance;
    }
    /**
     * 破坏单例模式的三种方式
     *
     * 反射
     * 序列化
     * 克隆
     */
    public static void main(String[] args) throws Exception {
        SingleLeak instance= SingleLeak.getInstance();
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(instance);

        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);
        SingleLeak result = (SingleLeak) ois.readObject();
        System.out.println("ObjectStream result="+(result.equals(instance)));

        Constructor<SingleLeak> cons= SingleLeak.class.getDeclaredConstructor();
        cons.setAccessible(true);
        SingleLeak refection=cons.newInstance();
        System.out.println("refection result="+(instance.equals(refection)));

        SingleLeak singleClone= (SingleLeak) instance.clone();
        System.out.println("clone result="+(instance.equals(singleClone)));
    }

}
