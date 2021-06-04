package com.sinovoice.lib.design.factoty;

/**
 * Created by  on 2021/6/4.
 **/
public abstract class CompterFactory {
    public abstract <T extends SimpleFactory.Computer> T createCompter(Class<T> clz);
}
