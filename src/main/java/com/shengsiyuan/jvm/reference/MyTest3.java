package com.shengsiyuan.jvm.reference;

import java.lang.ref.WeakReference;
import java.util.Date;

/**
 * 如果一个对象只是弱引用可达的（即指向该对象的丽都最强的引用类型就是弱引用），那么该对象会在下一个垃圾收集周期中被清理掉
 * 如果一个对象是软引用可达的，那么该对象一般来说会持续（或存活）时间更久一些
 */
public class MyTest3 {

    public static void main(String[] args) {
        Date date = new Date();
        WeakReference<Date> weakReference = new WeakReference<>(date);
        System.out.println(weakReference.get());
    }
}
