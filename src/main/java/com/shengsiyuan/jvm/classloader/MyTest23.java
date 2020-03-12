package com.shengsiyuan.jvm.classloader;

import sun.misc.Launcher;

/**
 * 如果启动时修改了根类加载器加载的路径，JVM在初始化时就会出错
 * java -Dsun.boot.class.path=./ com.shengsiyuan.jvm.classloader.MyTest23
 * Error occurred during initialization of VM
 * java/lang/NoClassDefFoundError: java/lang/Object
 *
 * ExtClassLoader和AppClassLoader都是Java类，那他们是如何加载到JVM中的
 * Hotspot提供的包含ExtClassLoader和AppClassLoader都是由启动类加载器加载的，启动类加载器是内嵌于JVM中由C++实现的
 * 启动类加载器会加载java.lang.ClassLoader以及其他的Java平台类，当JVM启动时，一块特殊的机器码会运行，它会加载
 * ExtClassLoader和AppClassLoader，这块特殊的机器码就是启动类加载器Bootstrap
 *
 * 启动类加载器并不是Java类，而其他的加载器都是Java类。启动类加载器是特定于平台的机器指令，它负责开启整个加载过程
 * 所有类加载器（除了启动类加载器）都被实现为Java类。不过，总归要有一个组件来加载第一个Java类加载器，从而让整个家在过程能够
 * 顺利进行下去，加载第一个纯Java类加载器就是启动类的职责。
 * 启动类加载器还有另一个职责是加载供JRE运行的基本组件，包括java.util与java.lang包中的类等等
 *
 * 阅读sun.misc.Launcher源码，oracle jdk中Launcher类本身并不开源，可以在http://grepcode.com查看open jdk的源码
 * oracle jdk和open jdk绝大部分的源码是一致的
 *
 */
public class MyTest23 {
    public static void main(String[] args) {
        //启动类加载器加载的目录，如果将自己编写的类放置到其中的目录中，就会被启动类加载器加载
        System.out.println(System.getProperty("sun.boot.class.path"));

        //扩展类加载器加载的目录
        System.out.println(System.getProperty("java.ext.dirs"));

        //系统类加载器加载的目录
        System.out.println(System.getProperty("java.class.path"));

        //null 启动类加载器加载
        System.out.println(ClassLoader.class.getClassLoader());

        //null 启动类加载器加载 Launcher里包含了ExtClassLoader和AppClassLoader
        //如果类加载器加载了一个类，那这个加载器也会继续加载这个类的内部类
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("--------");

        //当修改这个属性对应的类加载器时，这个类加载器就会成为系统类加载器，而原来的系统类加载器AppClassLoader会加载它
        //需要为这个类加载器添加一个public构造方法接受一个参数，类型是ClassLoader，参考getSystemClassLoader文档说明
        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
