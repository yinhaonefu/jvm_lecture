package com.test.jvm.classloader;

/**
 *  如果特殊未指定，系统类加载器
 */
public class MyTest7 {

    public static void main(String[] args) {

        System.out.println(ClassLoader.getSystemClassLoader());//AppClassLoader

    }
}
