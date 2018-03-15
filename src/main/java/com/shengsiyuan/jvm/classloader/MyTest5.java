package com.shengsiyuan.jvm.classloader;

/**
 * Created by yinhao on 18/3/15.
 * 当一个接口在初始化时，并不要求其父接口都完成初始化
 * 只有在真正使用到父接口的时候（如引用接口中定义的常量），才会初始化
 * 接口本身的常量都是static final的，所以会将常量放到执行类的常量池中，也不会初始化定义了该常量的接口
 * 如果定义的常量在运行时才会确定（比如随机数），就不会放到执行类的常量池中
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.a);
    }
}

interface MyParent5{
    public static final int a = 5;
}

interface MyChild5 extends MyParent5{
    public static final int b = 6;
}