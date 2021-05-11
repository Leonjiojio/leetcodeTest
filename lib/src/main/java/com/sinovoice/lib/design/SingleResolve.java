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
public class SingleResolve implements Serializable ,Cloneable{

//    防止反射
//    定义一个全局变量，当第二次创建的时候抛出异常
private static volatile boolean isCreate = false;//默认是第一次创建

    static SingleResolve instance;
    private SingleResolve(){
        if(isCreate) {
            throw new RuntimeException("already instance deny!");
        }
        isCreate = true;
    }
//    重写clone(),直接返回单例对象
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }

    /**
     * 防止序列化破环
     * @return
     */
    private Object readResolve() {
        return instance;
    }

    //双重检查加锁
    public static SingleResolve getInstance() {
        if (instance==null){
            synchronized (SingleResolve.class){
                if (instance==null){
                    instance=new SingleResolve();
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
        SingleResolve instance= SingleResolve.getInstance();
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(instance);

        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);
        SingleResolve result = (SingleResolve) ois.readObject();
        System.out.println("ObjectStream result="+(result.equals(instance)));

//        Constructor<SingleResolve> cons= SingleResolve.class.getDeclaredConstructor();
//        cons.setAccessible(true);
//        SingleResolve refection=cons.newInstance();
//        System.out.println("refection result="+(instance.equals(refection)));

        SingleResolve singleClone= (SingleResolve) instance.clone();
        System.out.println("clone result="+(instance.equals(singleClone)));
    }

}
