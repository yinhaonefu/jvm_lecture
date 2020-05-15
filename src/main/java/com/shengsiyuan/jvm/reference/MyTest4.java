package com.shengsiyuan.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Date;

/**
 * 查看文档说明
 * 1. 为什么PhantomReference的get方法直接返回null
 * 2. 为什么PhantomReference的构造方法只要接收两个参数的
 *
 * 当我们将一个对象封装到PhantomReference中时，意味着将永远无法再访问到这个对象了，因为PhantomReference的get方法返回null
 * PhantomReference的作用不在于获取其中封装的referent，而是在于当垃圾收集器回收其referent时，这个PhantomReference会被
 * 防止到与其关联的队列中，并且得到相应的通知，并做一些事情，这就是PhantomReference存在的唯一目的
 */
public class MyTest4 {

    public static void main(String[] args) {
        Date date = new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Date> phantomReference = new PhantomReference<>(date, referenceQueue);
        System.out.println(phantomReference.get());
    }
}
