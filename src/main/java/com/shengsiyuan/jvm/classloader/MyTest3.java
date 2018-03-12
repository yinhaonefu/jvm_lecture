package com.shengsiyuan.jvm.classloader;

import java.util.UUID;

/**
 * Created by yinhao on 18/3/12.
 * 这里final类型的常量被调用时，MyParent3就被初始化了，所以关键不是final
 * 是常量的值，如果在编译器常量的值可以被确定，那就会放到调用方法所在类的常量池中
 * 如果不能确定，则会初始化定义常量的类
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3{

    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static block");
    }
}
