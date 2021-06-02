package com.sinovoice.lib.outtest;

/**
 * Created by  on 2021/6/1.
 **/
public class OuterClass {
    public static void main(String[] args) {
        //synthetic
        OuterClass outerClass=new OuterClass();
        InnerClass innerClass= outerClass.new InnerClass();
        innerClass.doSth();

    }

    public  void doSth(){
        System.out.println("OuterClass do sth");
    }

     private class InnerClass{
        void doSth(){
            System.out.println("InnerClass do sth");
        }
    }
}
