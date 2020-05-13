package com.shengsiyuan.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Date;

/**
 * Reference Queue（引用队列）的设计目的在于让我们能够知道或是识别出垃圾收集器所执行的动作
 * 在收集过程中会修改引用的状态，如果不在引用队列中则无法进行引用状态跟踪
 *
 */
public class MyTest2 {

    public static void main(String[] args) {
        Date date = new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();
        SoftReference<Date> softReference = new SoftReference<>(date, referenceQueue);
        System.out.println(softReference.get());
    }
}
