package com.test.jvm.load_connect_init;

/**
 * -XX:+TraceClassLoading追踪类的加载信息
 * 使用MyParent1中静态变量，属于主动使用导致初始化
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyParent1.str);
    }
}

class MyParent1{
    static {
        System.out.println("MyParent1 static block");
    }
    public static String str = "MyParent1 hello world";
}
