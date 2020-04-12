package com.shengsiyuan.jvm.gc;

/**
 * vm option
 * 产生消息的垃圾回收日志信息
 * -verbose:gc
 * 堆内存初始值
 * -Xms20m
 * 堆内存最大值
 * -Xmx20m
 * 新生代大小
 * -Xmn10m
 * 打印垃圾回收详细信息
 * -XX:+PrintGCDetails
 * 设置新生代中的eden空间和survivor空间比是8:1
 * -XX:SurvivorRatio=8
 *
 *
 */
public class MyTest1 {

    /*
    控制台输出：
    [GC (Allocation Failure) [PSYoungGen: 5980K->624K(9216K)] 5980K->4728K(19456K), 0.0043342 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
    hello world
    Heap
     PSYoungGen      total 9216K, used 4019K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
      eden space 8192K, 41% used [0x00000007bf600000,0x00000007bf950e58,0x00000007bfe00000)
      from space 1024K, 60% used [0x00000007bfe00000,0x00000007bfe9c010,0x00000007bff00000)
      to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
     ParOldGen       total 10240K, used 4104K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
      object space 10240K, 40% used [0x00000007bec00000,0x00000007bf002020,0x00000007bf600000)
     Metaspace       used 3199K, capacity 4496K, committed 4864K, reserved 1056768K
      class space    used 354K, capacity 388K, committed 512K, reserved 1048576K

      分析GC信息
      PSYoungGen: 5980K->624K(9216K) 新生代已占据大小5980K GC后占据大小624K 总大小9216K(9m 因为8:1:1)
      5980K->4728K(19456K) 堆中占据大小5980K GC后占据大小4728K 总大小19456K

      ParOldGen       total 10240K, used 4104K 老年代总大小10240K 使用4104K(4728K-624K 堆占用总大小-新生代占用总大小)
     */
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];

        System.out.println("hello world");
    }
}
