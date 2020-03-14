package com.test.jvm.classloader;

/**
 * static final random
 */
public class MyTest0 {
    public static void main(String[] args) {
        System.out.println(Parent.parentStr);
    }
}

class Parent{

    public static String parentStr = "hello world";

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent{

    public static String childStr = "welcome";

    static {
        System.out.println("Child static block");
    }
}