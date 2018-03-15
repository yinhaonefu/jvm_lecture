package com.shengsiyuan.jvm.classloader;

/**
 * Created by yinhao on 18/3/15.
 *
 * 分析
 * Singleton.getInstance()执行时，调用一个类的静态方法，触发类的初始化
 * 初始化前，会首先进行准备，对类中的所有变量进行赋值操作，这时赋的是默认值
 * counter1 = 0
 * singleton = null
 * counter2 = 0
 * 准备阶段后，对类中的变量进行初始化
 * counter1 = 1
 * singleton = new Singleton() 初始化singleton时会调用私有的构造方法，修改了counter1和counter2
 * counter1 = 2
 * counter2 = 1
 * 初始化最后一步是对counter2初始化
 * counter2 = 0
 * 所以最终输出
 * counter1:2
 * counter2:0
 *
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1:" + Singleton.counter1);
        System.out.println("counter2:" + Singleton.counter2);

    }
}

class Singleton{

    public static int counter1 = 1;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1++;
        counter2++;
    }

    public static int counter2 = 0;

    public static Singleton getInstance(){
        return singleton;
    }
}
