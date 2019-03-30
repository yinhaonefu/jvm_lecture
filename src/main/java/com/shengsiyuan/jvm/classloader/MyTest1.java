package com.shengsiyuan.jvm.classloader;

/**
 * Created by yinhao on 18/3/8.
 * 主动使用时类会被初始化
 * 对于静态变量来说，只有直接定义了该静态变量的类才会被初始化（对静态变量的使用，属于主动使用中的一种）
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕
 * -XX:+TraceClassLoading 运行时添加该参数追踪类的加载
 * -XX:+<option>开启option选项 <option>相当于TraceClassLoading
 * -XX:-<option>关闭option选项
 * -XX:<option>=<value> 表示将option选项的值设为value
 *
 * 如果对父类的静态变量直接使用，会导致父类的初始化，子类不会初始化，但是子类也会被加载。
 * 可以通过参数-XX:+TraceClassLoading查看类加载日志。
 */
public class MyTest1 {

    static {
        System.out.println();
    }

    static {

    }

    static {

    }

    public static void main(String[] args) {

        System.out.println(MyChild1.str);

//        输出
//        MyParent1 static block
//        hello world

        System.out.println("-----------");

//        System.out.println(MyChild1.str2);

//        输出
//        MyParent1 static block
//        MyChild1 static block
//        welcome
    }
}

class MyParent1{

    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1{

    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}