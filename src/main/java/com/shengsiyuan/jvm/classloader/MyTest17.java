package com.shengsiyuan.jvm.classloader;

public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("clazz: " + clazz.hashCode());

        //如果注释掉该该行，就不会实例化MySample对象，其构造方法也不会被调用，
        // 因此不会实例化MyCat对象，没有对其主动使用，这里就不会加载MyCat Class
//        Object object = clazz.newInstance();
    }
}
