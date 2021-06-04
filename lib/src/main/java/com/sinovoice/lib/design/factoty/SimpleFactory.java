package com.sinovoice.lib.design.factoty;

/**
 * Created by  on 2021/6/4.
 **/
public class SimpleFactory {
    public static void main(String[] args) {
        //简单工厂
        Computer HpCompter=createComputer("HP");
        //工厂方法
        CompterFactory compterFactory=new GDCompterFactory();
        Computer lenovoCompter=compterFactory.createCompter(LenovoComputer.class);
    }
    public interface Computer{
        void start();
    }
    static class LenovoComputer implements Computer{
        @Override
        public void start() {
            System.out.print("Lenovo start");
        }
    }
    static class HpComputer implements Computer{
        @Override
        public void start() {
            System.out.print("HP start");
        }
    }
    public  static  Computer createComputer(String  name){
        Computer computer=null;
        switch (name){
            case "HP":
                computer=new HpComputer();
                break;
            case "Lenovo":
                computer=new LenovoComputer();
                break;
        }
        return computer;
    }
}
