package com.test.jvm.classloader;


public class MyTest2 {

    private static ClassLoader classLoader;

    public static void main(String[] args) {

        classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        while (null != classLoader){

            classLoader = classLoader.getParent();

            System.out.println(classLoader);

        }

    }
}
