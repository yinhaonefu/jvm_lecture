package com.test.jvm.load_connect_init;

import java.util.UUID;

/**
 * -XX:+TraceClassLoading追踪类的加载信息
 * final关键字
 */
public class MyTest4 {
    public static void main(String[] args) {
        System.out.println(MyChild4.str);
    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
    public final static String str = UUID.randomUUID().toString();
}

class MyChild4 extends MyParent4 {
    public static String str2 = "MyChild4 hello world";
    static {
        System.out.println("MyChild4 static block");
    }
}