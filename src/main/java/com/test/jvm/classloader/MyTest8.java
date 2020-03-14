package com.test.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class MyTest8 {

    public static void main(String[] args) {
//        Thread.currentThread().setContextClassLoader(MyTest8.class.getClassLoader().getParent());

        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> driverIterator = serviceLoader.iterator();
        while (driverIterator.hasNext()){
            Driver driver = driverIterator.next();
            System.out.println("mysql driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文类加载器: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器: " + ServiceLoader.class.getClassLoader());

    }
}
