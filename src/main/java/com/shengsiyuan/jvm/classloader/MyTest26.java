package com.shengsiyuan.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模式（获取 - 使用 - 还原）
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * try{
 *     Thread.currentThread().setContextClassLoader(targetTccl);//获取
 *     myMethod();//使用
 * }finally{
 *     Thread.currentThread().setContextClassLoader(classLoader);//还原
 * }
 *
 * myMethod里面则调用了Thread.currentThread().getContextClassLoader()获取当前线程的上下文类加载器做某些事情
 * 如果一个类由类的加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该依赖类之前没有被加载过的话）
 * ContextClassLoader的作用就是为了破坏类加载的双亲委托机制
 *
 * 当高层提供的统一的接口让低层去实现，同时又要在高层加载（或实例化）低层的类时，就必须要通过线程上下文类加载器来帮助高层
 * 的ClassLoader找到并加载该类
 */
public class MyTest26 {
    public static void main(String[] args) throws Exception{
        //如果修改了当前线程上下文类加载器为扩展类加载器，则无法找到classpath下的驱动实现，iterator不会输出
//        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

        // ServiceLoader.load(Driver.class)中加载了服务提供者的类，而ServiceLoader是由启动类加载器加载的，但是启动类加载器
        // 是没办法加载classpath中的服务提供者的类
        // 所以需要在内部将加载服务提供者的类的类加载器改成当前线程上下文类加载器，默认也就是系统类加载器
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文类加载器: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器: " + ServiceLoader.class.getClassLoader());
    }
}
