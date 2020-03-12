package com.test.jvm.load_connect_init;

/**
 * -XX:+TraceClassLoading追踪类的加载信息
 * MyChild2.str使用的是MyChild2中静态变量str2，属于主动使用，导致MyChild2和MyParent2初始化
 * MyChild2.str2使用的是MyParent2中静态变量str，属于主动使用，导致MyParent2初始化
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyChild2.str2);
    }
}

class MyParent2{
    static {
        System.out.println("MyParent2 static block");
    }
    public static String str = "MyParent2 hello world";
}

class MyChild2 extends MyParent2 {
    public static String str2 = "MyChild2 hello world";
    static {
        System.out.println("MyChild2 static block");
    }
}