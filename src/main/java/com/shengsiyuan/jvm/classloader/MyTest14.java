package com.shengsiyuan.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by yinhao on 18/7/8.
 * 输出所在目录
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "com/shengsiyuan/jvm/classloader/MyTest14.class";
        //获取资源的全路径
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
            //file:/Users/yinhao/IdeaProjects/jvm_lecture/out/production/classes/com/shengsiyuan/jvm/classloader/MyTest14.class
        }

        System.out.println("---------");

        Class<MyTest14> clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader());//AppClassLoader

        System.out.println("---------");

        Class<String> sClazz = String.class;
        System.out.println(sClazz.getClassLoader());//null bootstrapClassLoader
    }
}
