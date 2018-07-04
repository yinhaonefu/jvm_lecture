package com.shengsiyuan.jvm.classloader;

class CL{
    static {
        System.out.println("Class CL");
    }
}

public class MyTest12 {

    static {
        System.out.println("MyTest12 static block");
    }

    public static void main(String[] args)throws Exception {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        //并不是对类的主动使用，不会导致类的初始化，只会加载（跟踪加载信息）
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.CL");

        System.out.println(clazz);

        System.out.println("-------");

        //反射会导致类的初始化，所以此行代码才会初始化CL类
        clazz = Class.forName("com.shengsiyuan.jvm.classloader.CL");

        System.out.println(clazz);

    }
}