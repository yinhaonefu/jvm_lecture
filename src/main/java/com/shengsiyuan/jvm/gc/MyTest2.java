package com.shengsiyuan.jvm.gc;

/**
 * 打印JDK版本及JVM启动参数
 * java -XX:+PrintCommandLineFlags -version
 *
 * VM options 增加参数 -XX:PretenureSizeThreshold=4194304 如果新创建的对象超过该阈值时直接在老年代进行分配
 * 但是需要结合单线程收集器使用 需要添加参数 -XX:+UseSerialGC，不使用单线程收集器的话还是会在新生代分配
 *
 * 如果没指定-XX:+UseSerialGC参数使用单线程收集器，但是新创建的对象已经大于堆中的eden区内存，也会直接在老年代分配
 */
public class MyTest2 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc = new byte[5 * size];
    }
}
