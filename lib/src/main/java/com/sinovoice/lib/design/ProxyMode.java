package com.sinovoice.lib.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by  on 2021/3/3.
 **/
public class ProxyMode {

    public static void main(String[] args) {
        //静态方式代理
//        HelloInterface helloProxy=new HelloProxy();
//        helloProxy.sayHello();
        //动态方式代理
        HelloInterface hello=new Hello();
        InvocationHandler handler = new ProxyHandler(hello);
        HelloInterface helloProxy= (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),handler);
        helloProxy.sayHello();

        //新建by类
        ByeInterface bye=new Bye();

        InvocationHandler handler1=new ProxyHandler(bye);
        ByeInterface byeProxy= (ByeInterface) Proxy.newProxyInstance(bye.getClass().getClassLoader(),bye.getClass().getInterfaces(),handler1);
        byeProxy.sayBye("hahaha");
    }
}
 interface ByeInterface {
    void sayBye(String word);
}
 class Bye implements ByeInterface {
    @Override
    public void sayBye(String word) {
        System.out.println("leon say "+word);
    }
}

interface HelloInterface{
    void sayHello();
}
class Hello implements  HelloInterface{

    @Override
    public void sayHello() {
        System.out.println("my name is leno");
    }
}
class HelloProxy implements HelloInterface{
private HelloInterface helloInterface=new Hello();
    @Override
    public void sayHello() {
        helloInterface.sayHello();
    }
}

class  ProxyHandler implements InvocationHandler{

    private Object object;
    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mName = method.getName();
        System.out.println("Before invoke "+mName);
        if (mName.equals("sayHello")){
            System.out.println("sayHello invoke");
        }else if (mName.equals("sayBye")){
            System.out.println("sayBye invoke");
        }
        method.invoke(object,args);
        System.out.println("After invoke "+mName);
        return null;
    }
}
