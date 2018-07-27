package com.shengsiyuan.jvm.classloader;

import java.sql.Connection;

/**
 * 当前类加载器(Current ClassLoader)
 * 每一个类都会使用自己的类加载器去加载依赖的其他的类
 * 如果ClassX引用了ClassY，那么ClassX的类加载器就会去加载ClassY（前提是ClassY尚未被加载）
 *
 * 线程上下文类加载器(Context ClassLoader)
 * 线程上下文类加载器是从JDK1.2开始引入的，Thread类中的getContextClassLoader()和setContextClassLoader(ClassLoader cl)
 * 分别用于获取和设置上下文类加载器
 * 如果没有通过setContextClassLoader(ClassLoader cl)进行设置的话，线程将继承其父线程的上下文类加载器
 * Java应用运行时的初始线程的上下文类加载器是系统类加载器。在线程中运行的代码可以通过该类加载器来加载类与资源
 *
 * 线程上下文类加载器的重要性：
 *
 * SPI(Service Provider Interface) 例如 jdbc jndi 只声明服务接口，而具体实现由厂商提供
 * 父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的ClassLoader加载的类
 * 这就改变了父ClassLoader不能使用子ClassLoader或是直接父子关系的ClassLoader加载的类的情况，即改变了双亲委托模型
 *
 * 线程上下文类加载器就是当前线程的Current ClassLoader
 *
 * 在双亲委托模型下，类加载器是由下至上的，即下层的类加载器会委托上层进行加载。但是对于SPI来说，有些接口是Java核心库所提供的，
 * 而Java核心库是由启动类加载器来加载的，而这些接口的实现却来自不同的jar包（厂商提供），Java的启动类加载器是不会加载其他来源
 * 的jar包，这样传统的双亲委托模型就无法满足SPI的要求，而通过给当前线程设置上下文类加载器，就可以由设置的上下文类加载器来实现
 * 对于接口实现类的加载。
 */
public class MyTest24 {
    public static void main(String[] args) {
        //Launcher$AppClassLoader
        System.out.println(Thread.currentThread().getContextClassLoader());
        //null bootstrap
        System.out.println(Thread.class.getClassLoader());
    }
}
