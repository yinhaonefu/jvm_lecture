package com.shengsiyuan.jvm.classloader;

/**
 * Created by yinhao on 18/3/12.
 *
 * 对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为
    [Lcom.shengsiyuan.jvm.classloader.MyParent4
    二维数组就是[[Lcom.shengsiyuan.jvm.classloader.MyParent4 父类型都是Object

 所以创建了一个数组类型，并不会导致数组中的元素类型的初次使用，而是会创建一个数组类型，
 这个类型是JVM在运行期自己创建的

 对于数组来说，JavaDoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型
 二维数组的Component就是二维数组里面包含的一维数组，一维数组的Component就是一维数组里面包含的元素类型


 助记符：
 anewarray 创建一个引用类型（如对象，接口类型，数组）数组并将其压入栈顶
 newarray 创建一个原生数据类型的数组，并将其压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
        MyParent4 myParent4 = new MyParent4();
        System.out.println(myParent4.getClass());

        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());//jvm创建的类型 父类是Object

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());//jvm创建的类型 父类是Object

        int[] ints = new int[1];
        System.out.println(ints.getClass());//[I

        char[] chars = new char[1];
        System.out.println(chars.getClass());//[C

        boolean[]  booleen = new boolean[1];
        System.out.println(booleen.getClass());//[Z

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());//[B

    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}