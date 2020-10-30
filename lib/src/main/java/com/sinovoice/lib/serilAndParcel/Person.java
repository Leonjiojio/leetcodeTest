package com.sinovoice.lib.serilAndParcel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by liqiang on 2020/10/29.
 **/
public class Person implements Externalizable {
    private static final long serialVersionUID = -7672424580163024095L;
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println(Person.class.getSimpleName()+" writeExternal");
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println(Person.class.getSimpleName()+" readExternal");
        name=(String) in.readObject();
        age=in.readInt();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
