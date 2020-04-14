package com.shengsiyuan.jvm.gc;

/*
    -verbose:gc
    -Xmx200M 堆内存最大200M
    -Xmn50M 新生代最大内存50M 一个Eden和两个Survivor占比默认8:1:1
    -XX:TargetSurvivorRatio=60 当单个Survivor空间被占据60%，就会重新计算晋升阈值（MaxTenuringThreshold指定的值）
    -XX:+PrintTenuringDistribution 打印对象在Survivor中的年龄(每次GC都会增加年龄)
    -XX:+PrintGCDetails
    -XX:+PrintGCDateStamps 打印执行GC的时间戳
    -XX:+UseConcMarkSweepGC 老年代使用CMS垃圾收集器
    -XX:+UseParNewGC 新生代使用ParNew垃圾收集器
    -XX:MaxTenuringThreshold=3 对象在新生代中存活的最大年龄，超过该年龄晋升到老年代
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        byte[] byte1 = new byte[512 * 1024];
        byte[] byte2 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("111");

        myGc();
        Thread.sleep(1000);
        System.out.println("222");

        myGc();
        Thread.sleep(1000);
        System.out.println("333");

        myGc();
        Thread.sleep(1000);
        System.out.println("444");

        byte[] byte3 = new byte[1024 * 1024];
        byte[] byte4 = new byte[1024 * 1024];
        byte[] byte5 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("555");

        myGc();
        Thread.sleep(1000);
        System.out.println("666");

        System.out.println("hello world");

    }

    private static void myGc(){
        for (int i = 0; i < 40; i++){
            byte[] byteArray = new byte[1024 * 1024];
        }
    }
}
