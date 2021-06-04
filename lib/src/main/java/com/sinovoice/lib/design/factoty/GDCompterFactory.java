package com.sinovoice.lib.design.factoty;

/**
 * Created by  on 2021/6/4.
 **/
public class GDCompterFactory extends CompterFactory {
    @Override
    public <T extends SimpleFactory.Computer> T createCompter(Class<T> clz) {
        SimpleFactory.Computer computer=null;
        String className=clz.getName();
        try {
            computer= (SimpleFactory.Computer) Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T)computer;
    }
}
