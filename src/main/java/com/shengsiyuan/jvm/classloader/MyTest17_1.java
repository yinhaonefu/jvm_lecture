package com.shengsiyuan.jvm.classloader;

/**
 * 关于命名空间的重要说明
 * 1.子加载器所加载的类能够访问到父加载器所加载的类
 * 2.父加载器所加载的类无法访问到子加载器所加载的类
 * 也就是下层加载器能访问到上层加载器加载的类，反之则不可以
 */
public class MyTest17_1 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/yinhao/Desktop/");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("clazz: " + clazz.hashCode());

        //如果注释掉该该行，就不会实例化MySample对象，其构造方法也不会被调用，
        // 因此不会实例化MyCat对象，没有对其主动使用，这里就不会加载MyCat Class
//        Object object = clazz.newInstance();
    }
}
