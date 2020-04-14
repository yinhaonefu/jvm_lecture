package com.shengsiyuan.jvm.gc;

/*
    -verbose:gc
    -Xms20M
    -Xmx20M
    -Xmn10M
    -XX:+PrintGCDetails
    -XX:+PrintCommandLineFlags 打印JVM启动参数
    -XX:SurvivorRatio=8
    -XX:MaxTenuringThreshold=5
    -XX:+PrintTenuringDistribution


    -XX:MaxTenuringThreshold=5 是指对象在GC后晋升到老年代的阈值，有可能GC次数不到这个阈值就会晋升到老年代
    该参数的默认值是15，CMS中默认是6，G1中默认是15（在JVM中，该数值是由4个bit来表示的，所以最大值1111，即15）

    经历了多次GC后，存活的对象会在From Survivor与To Survivor之间来回存放，而这里面的一个前提则是两个空间有足够的大小来存放这些数据
    在GC算法中，会计算每个对象年龄大小，如果达到某个年龄后发现单个Survivor空间已经使用超过50%，那么这时需要调整阈值，不能再继续等到默认
    15次GC后才晋升到老年代，因为这样会导致Survivor空间不足，所以需要调整阈值，让这些存活对象尽快完成晋升

 */
public class MyTest3 {
    public static void main(String[] args) {
        int size = 2014 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];


        System.out.println("hello world");

    }
}
