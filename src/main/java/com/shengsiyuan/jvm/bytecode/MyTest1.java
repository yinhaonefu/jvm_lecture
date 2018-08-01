package com.shengsiyuan.jvm.bytecode;

/**
 * javap -verbose MyTest1 字节码文件
 */
public class MyTest1 {

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
