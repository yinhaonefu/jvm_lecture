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
 * jcmd JDK1.7开始增加的命令
 * 1. 查看Java进程的JVM启动参数 jcmd pid VM.flags
 * 2. 查看可以对Java进程执行哪些操作 jcmd pid help
 * 3. 查看对Java进程某个操作有哪些选项，例如查看VM.flags操作的选项 jcmd pid help VM.flags
 * 4. 查看Java进程的性能相关的参数 jcmd pid PerfCounter.print
 * 5. 查看Java进程的启动时长 jcmd pid VM.uptime
 * 6. 查看Java进程中类的统计信息 jcmd pid GC.class_histogram
 * 7. 查看Java进程中的线程统计信息 jcmd pid Thread.print
 * 8. 导出堆存储文件由jvisualvm载入查看 jcmd pid GC.heap_dump filename.hprof
 * 9. 查看JVM属性信息 jcmd pid VM.system_properties
 * 10. 查看命令行参数 jcmd pid VM.command_line
 *
 * jstack 查看或者导出Java进程线程的堆栈信息，例如检查死锁 jstack pid
 * jmc 集大成的图形工具
 * jhat
 *
 */
public class MyTest5 {
    public static void main(String[] args) {
        for( ; ; ){
            System.out.println("hello world");
        }
    }
}
