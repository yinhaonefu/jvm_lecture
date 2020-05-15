package com.shengsiyuan.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Date;

/**
 * 1. 为什么PhantomReference的get方法直接返回null
 * 2. 为什么PhantomReference的构造方法只要接收两个参数的
 */
public class MyTest4 {

    public static void main(String[] args) {
        Date date = new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Date> phantomReference = new PhantomReference<>(date, referenceQueue);
        System.out.println(phantomReference.get());
    }
}
