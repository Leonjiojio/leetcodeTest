package com.sinovoice.lib.classloader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by  on 2021/5/31.
 **/
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        getExtDir();
        // 一个简单的类加载器，逆向双亲委派机制
        // 可以加载与自己在同一路径下的Class文件
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name)
                    throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1)
                            + ".class";
                    InputStream is = getClass().getResourceAsStream(filename);
                    if (is == null) {
                        return super.loadClass(name);   // 递归调用父类加载器
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (Exception e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        /** result=
         * com.sinovoice.lib.classloader.ClassLoaderTest$1@7852e922testClassLoader hello
         * sun.misc.Launcher$AppClassLoader@73d16e93testClassLoader world
         * class com.sinovoice.lib.classloader.ClassLoaderTest
         * false
         */

        Object obj = myClassLoader.loadClass("com.sinovoice.lib.classloader.ClassLoaderTest").newInstance();
        Method method = obj.getClass().getDeclaredMethod("print", String.class);
        method.invoke(obj,"hello");

        Object lancherObj=Class.forName("com.sinovoice.lib.classloader.ClassLoaderTest").newInstance();
        ClassLoaderTest test=new ClassLoaderTest();
        test.print("world");
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.sinovoice.lib.classloader.ClassLoaderTest);
        System.out.println(lancherObj instanceof com.sinovoice.lib.classloader.ClassLoaderTest);
    }
    public void  print(String msg){
        System.out.println(this.getClass().getClassLoader().toString()+"testClassLoader "+msg);
    }

    private static void getExtDir(){
        try {
            URL[] extURLs = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent()).getURLs();
            for (int i = 0; i < extURLs.length; i++) {
                System.out.println(extURLs[i]);
            }
        }catch ( Exception e){
            e.printStackTrace();
        }

    }
}
