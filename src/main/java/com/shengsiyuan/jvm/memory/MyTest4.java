package com.shengsiyuan.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区产生内存溢出错误
 * 从JDK1.8开始使用元空间（meta space）代替永久代，元空间就位于方法区中，使用的是操作系统的本地内存初试大小21m，由元空间虚拟机管理其内存大小
 * 并且随着占用的内存大小达到上限后，元空间虚拟机会进行垃圾回收，如果空间仍然不够会不断的扩展元空间内存直到操作系统内存大小
 * 如果不进行限制，很难出现方法区的内存溢出
 * 1. 显式的设置元空间大小，且不自动扩展
 * 2. 明确元空间中存储的什么信息，元空间存储的Class信息，比如使用Java动态代理、cglib，在运行期生成大量的类
 *
 */
public class MyTest4 {
    public static void main(String[] args) {
        /**
         * 使用cglib不断创建MyTest4的子类并限制元空间大小 -XX:MaxMetaspaceSize=5m
         * 运行时通过jconsole观察加载的类的数量在不断增加 勾选详细输出控制台会打印详细的类加载日志，或者继续添加 -XX:+TraceClassLoading参数
         * 
         *
         */
        for ( ; ; ){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            System.out.println("hello world");
            enhancer.create();
        }
    }
}
