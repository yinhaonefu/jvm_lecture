package com.shengsiyuan.jvm.classloader;

public class MyTest7 {
    public static void main(String[] args)throws Exception {
        Class<?> sClass = Class.forName("java.lang.String");
        System.out.println(sClass.getClassLoader());

        Class<?> mClass = Class.forName("com.shengsiyuan.jvm.classloader.MyTest7");
        System.out.println(mClass.getClassLoader());
    }
}
