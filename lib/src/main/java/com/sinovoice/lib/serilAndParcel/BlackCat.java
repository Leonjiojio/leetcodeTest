package com.sinovoice.lib.serilAndParcel;

import java.io.Serializable;

/**
 * Created by liqiang on 2020/10/29.
 **/
public class BlackCat extends  Animal implements Serializable {
    private static final long serialVersionUID = 6976525739591348160L;
    //serialver com.sinovoice.lib.serilAndParcel.BlackCat
    private String name;
    private int age;

    public BlackCat() {
        System.out.println("调用黑猫的无参构造");
    }

    public BlackCat(String color, String name) {
        super(color);
        this.name = name;
        System.out.println("调用黑猫有 color 参数的构造");
    }

    public BlackCat(String color, String name, int age) {
        super(color);
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "BlackCat{" +
                "name='" + name + '\'' +super.toString()+
                '}';
    }
}
