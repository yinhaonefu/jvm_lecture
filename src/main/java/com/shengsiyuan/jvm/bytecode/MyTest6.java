package com.shengsiyuan.jvm.bytecode;

/**
 * 方法的动态分派
 *
 * 方法的动态分派涉及到一个重要的概念：方法接收者（方法调用者）
 *
 * invokevirtual字节码指令的多态查找流程
 * 1. 首先到操作数栈顶，寻找栈顶的元素指向的实际类型
 * 2. 如果在实际类型中找到了字节码描述符对应的方法，并且具备访问权限，返回目标方法的直接引用，如果未找到按继承关系向上查找，一直未找到抛异常
 *
 * 比较方法重载与方法重写我们可以得到结论：方法重载是静态的，编译期行为。方法重写是动态的，运行期行为。
 *
 * 方法接收者不同！！！方法重载的接收者都是声明的静态类型，方法重写的接收者是运行期才确定
 *
 */
public class MyTest6 {

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit{
    public void test(){
        System.out.println("Fruit");
    }
}

class Apple extends Fruit{
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit{
    @Override
    public void test() {
        System.out.println("Orange");
    }
}