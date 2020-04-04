package com.shengsiyuan.jvm.memory;

/**
 * InfoQ文章 Java永久代去哪了
 * https://www.infoq.cn/article/Java-permgen-Removed
 *
 * jps -l 获取所有Java进程id和类名称
 *
 * 使用控制台工具查看当前进程的类加载器信息
 * jmap -clstats 进程id
 *
 * 使用控制台工具查看当前进程的堆内存摘要信息
 * jmap -heap 进程id
 *
 * 使用控制台工具查看元空间信息，关注MC和MU MC指系统默认分配给元空间的内存大小 MU指已使用的元空间大小
 * jstat -gc 进程id
 *
 * 查看Java进程的JVM启动参数 jcmd JDK1.7开始增加的命令
 * jcmd pid VM.flags
 *
 * 查看可以对Java进程执行哪些操作
 * jcmd pid help
 *
 * 查看对Java进程某个操作有哪些选项，例如查看VM.flags操作的选项
 * jcmd pid help VM.flags
 *
 * 查看Java进程的性能相关的参数
 * jcmd pid PerfCounter.print
 *
 * 查看Java进程的启动时长
 * jcmd pid VM.uptime
 *
 * 查看Java进程中类的统计信息
 * jcmd pid GC.class_histogram
 *
 * 查看Java进程中的线程统计信息
 * jcmd pid Thread.print
 *
 * 导出堆存储文件由jvisualvm载入查看
 * jcmd pid GC.heap_dump filename.hprof
 *
 * 查看JVM属性信息
 * jcmd pid VM.system_properties
 *
 */
public class MyTest5 {
    public static void main(String[] args) {
        for( ; ; ){
            System.out.println("hello world");
        }
    }
}
