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
 *
 * 类加载器的双亲委托机制的好处：
 * 1.可以确保Java核心库的类型安全，所有Java应用都至少会引用java.lang.Object，也就是说在运行期，java.lang.Object这个类
 *   会被加载到Java虚拟机中，如果这个加载过程是由Java应用自己的类加载器完成，那么很可能就会在JVM中存在多个版本的java.lang.Object类
 *   ，而且这些类之间还是互不兼容，相互不可见的（正是命名空间在发挥着作用）。
 * 2.可以确保Java核心类库所提供的类不会被自定义的类所替代
 * 3.不同的类加载器可以为相同名称（binary name）的类创建额外的命名空间。相同名称的类可以并存在Java虚拟机中，只需要用不同的
 *   类加载器来加载他们即可。不同类加载器所加载的类时不兼容的，这就相当于在Java虚拟机中内部创建了一个又一个相互隔离的Java类空间，
 *   这类技术在很多框架中都得到了实际应用。
 *
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
