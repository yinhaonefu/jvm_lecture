package com.shengsiyuan.jvm.classloader;

/**
 * Created by yinhao on 18/3/9.
 * final常量在编译阶段会存入到调用这个常量的方法所在类的常量池中
 * 本质上，调用常量的类并没有直接引用到定义该静态常量的类，因此不会触发定义常量的类的初始化
 * 本例中的常量str存放到了MyTest2的常量池中，MyTest2和MyParent2就没有关系了
 * 甚至我们可以将MyParent2.class删除
 *
 * 助记符：
 * ldc表示将int float或是String类型的常量值从常量池中推送至栈顶
 * bipush将单字节（-128 - 127）的常量值推送至栈顶
 * sipush将一个短整型常量值（-32768 - 32767）推送至栈顶
 * iconst_1表示将int类型的数字1推送至栈顶（那2怎么办呢），实际上0 -1 1到5都这么表示iconst_5
 * 可能JVM觉得这7个数比较常见，单独定义了
 */
public class MyTest2 {

    public static void main(String[] args) {
        System.out.println(MyParent2.str);
        System.out.println(MyParent2.s);
        System.out.println(MyParent2.i);
        System.out.println(MyParent2.m);
        System.out.println(MyParent2.l);
    }

}

class MyParent2{

    //添加final MyParent2不会被初始化 静态代码块不执行
    public static final String str = "hello world";

    public static final short s = 127;//bipush

    public static final int i = 128;//sipush

    public static final int m = 5;//iconst_5

    public static final int l = 129;//sipush

    static {
        System.out.println("MyParent2 static block");
    }
}