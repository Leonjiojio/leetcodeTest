package com.sinovoice.lib.serilAndParcel;

/**
 * Created by liqiang on 2020/10/29.
 **/
public class Animal {
    private String color;

    public Animal(String color) {
        this.color = color;
        System.out.println("调用 Animal 有 color 参数的构造");
    }

    public Animal() {
        System.out.println("调用 Animal 无参构造");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "color='" + color + '\'' +
                '}';
    }
}
