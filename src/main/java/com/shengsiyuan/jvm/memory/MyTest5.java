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
 */
public class MyTest5 {
    public static void main(String[] args) {
        for( ; ; ){
            System.out.println("hello world");
        }
    }
}
