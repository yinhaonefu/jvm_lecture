package com.shengsiyuan.jvm.reference;

import java.lang.ref.SoftReference;
import java.util.Date;

/**
 * Reference实例的4中状态 Active Pending Enqueued Inactive
 * Active：新创建的引用实例都会处于Active状态
 * Pending：未被注册到引用队列中的引用对象不可能处于该状态
 * Enqueued：未被注册到引用队列中的引用对象不可能处于该状态
 * Inactive：无法对该状态的引用对象执行任何操作，处于该状态下的对象状态不会再发生任何变化
 */
public class MyTest1 {

    public static void main(String[] args) {
        Date date = new Date();
        SoftReference<Date> reference = new SoftReference<>(date);
        Date date1 = reference.get();

        //软引用指向的对象有可能被回收，需要非空判断
        if(null != date1){
            System.out.println("hello");
        }else{
            System.out.println("world");
        }

        System.out.println("======");

        reference.clear();//清理后再获取对象就为空

        Date date2 = reference.get();

        System.out.println(date2);
    }
}
