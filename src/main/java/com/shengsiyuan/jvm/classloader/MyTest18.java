package com.shengsiyuan.jvm.classloader;

public class MyTest18 {
    public static void main(String[] args) {
        //启动类加载器加载的目录，如果将自己编写的类放置到其中的目录中，就会被启动类加载器加载
        System.out.println(System.getProperty("sun.boot.class.path"));

        //扩展类加载器加载的目录
        System.out.println(System.getProperty("java.ext.dirs"));

        //系统类加载器加载的目录
        System.out.println(System.getProperty("java.class.path"));
    }
}
