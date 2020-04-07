package com.shengsiyuan.jvm.bytecode;

/**
 * 方法的静态分派
 * Grandpa g1 = new Father();
 * g1的静态类型是Grandpa，不会发生变化，而g1的实际类型（真正指向的类型）是Father
 * 结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多态），实际类型是运行期才能确定
 *
 * 方法重载是一种静态行为
 */
public class MyTest5 {

    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();

        myTest5.test(g1);
        myTest5.test(g2);
    }
}


class Grandpa{

}

class Father extends Grandpa{

}

class Son extends Father{

}