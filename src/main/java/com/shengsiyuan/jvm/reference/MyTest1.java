package com.shengsiyuan.jvm.reference;

/**
 * Reference实例的4中状态 Active Pending Enqueued Inactive
 * Active：新创建的引用实例都会处于Active状态
 * Pending：未被注册到引用队列中的引用对象不可能处于该状态
 * Enqueued：未被注册到引用队列中的引用对象不可能处于该状态
 * Inactive：无法对该状态的引用对象执行任何操作，处于该状态下的对象状态不会再发生任何变化
 */
public class MyTest1 {

}
