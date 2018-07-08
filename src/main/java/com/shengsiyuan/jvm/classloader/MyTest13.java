package com.shengsiyuan.jvm.classloader;

/**
 * Created by yinhao on 18/7/8.
 */
public class MyTest13 {

    private static ClassLoader classLoader;

    public static void main(String[] args) {

        classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);//AppClassLoader

        while (null != classLoader){

            classLoader = classLoader.getParent();

            System.out.println(classLoader);//loop 1 ExtClassLoader loop 2 null

        }

    }
}
