package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.Method;

/**
 * 将classpath下编译好的MyPerson.class放到/Users/yinhao/Desktop/
 * 然后将原MyPerson.class删除，执行报错，
 * 因为系统类加载器此时无法在classpath下加载MyPerson.class，而loader1和loader2没有任何双亲关系
 * 他们加载的类相互不可见，所以method.invoke(object1,object2);会报错
 *
 * 子加载器可以看见所有其父加载器加载的类，而父加载器看不见其子加载器加载的类
 * 没有双亲关系的加载器之间加载的类也相互不可见
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("/Users/yinhao/Desktop/");
        loader2.setPath("/Users/yinhao/Desktop/");

        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson",Object.class);

        method.invoke(object1,object2);

    }
}
