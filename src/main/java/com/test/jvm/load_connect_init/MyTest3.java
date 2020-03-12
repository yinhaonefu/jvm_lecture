package com.test.jvm.load_connect_init;

/**
 * -XX:+TraceClassLoading追踪类的加载信息
 * final关键字
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyChild3.str);
    }
}

class MyParent3{
    static {
        System.out.println("MyParent3 static block");
    }
    public final static String str = "MyParent3 hello world";
}

class MyChild3 extends MyParent3 {
    public static String str2 = "MyChild3 hello world";
    static {
        System.out.println("MyChild3 static block");
    }
}