package com.sinovoice.lib.serilAndParcel;

import java.io.*;

/**
 * Created by liqiang on 2020/10/28.
 **/
public class SerializableAndParcelable {
    public static  void main(String args[]){
        serializableAnimal();
        deserializableAnimal();
//        tesetExternalizable();

    }

    private static final String FILE_PATH = "./super.bin";

    private static  void tesetExternalizable(){
        Person p=new Person(18,"Tom");
        System.out.println("before serializable"+p.toString());
        serializable(p);
        Person newP=(Person) deserializable();
        System.out.println("after serializable"+newP.toString());
    }
    private static void serializableAnimal(){
        BlackCat blackCat=new BlackCat("Black","BlackCatTom");
        System.out.println("before serializable"+blackCat.toString());
        serializable(blackCat);
    }
    private static void serializable(Serializable serializable){
        System.out.println("=================serializable================");
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(serializable);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Object deserializable(){
        System.out.println("=================serializable================");
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(FILE_PATH));
            Object obj= ois.readObject();
            ois.close();
            return  obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    private static  void deserializableAnimal(){
        BlackCat blackCat=(BlackCat) deserializable();
        System.out.println("after serializable"+blackCat.toString());

    }

}
