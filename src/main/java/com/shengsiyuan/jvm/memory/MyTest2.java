package com.shengsiyuan.jvm.memory;

/**
 * 虚拟机栈溢出  java.lang.StackOverflowError
 * 添加 -Xss160k JVM要求至少160k
 * 除了jvisualvm 还可以用 jconsole，jconsole是jvisualvm的子集，但是提供了一些额外的支持，检查线程阻塞及死锁
 *
 */
public class MyTest2 {

    private int length;

    public int getLength(){
        return length;
    }

    public void test(){
        this.length++;

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            myTest2.test();
        }catch (Throwable t){//抛出的是error 不是 exception
            System.out.println(myTest2.getLength());
            t.printStackTrace();
        }
    }
}
