package com.shengsiyuan.jvm.classloader;

import java.io.*;

/**
 * 自定义类加载器
 * 当使用自定义类加载器家在一个类时，自定义类加载器会委托父类加载器，也就是AppClassLoader
 * 当父类加载器无法加载这个类时，再由自定义类加载器本身去加载这个类
 *
 * 验证方案：
 * 将一个class文件复制到磁盘另一个位置，并按包名建立好目录
 * 并设置自定义类加载器的path到这个位置，再将classpath下该class文件删除（为了不让AppClassLoader加载到这个class文件）
 *
 * 因为父类加载器无法再classpath下加载到这个类，所以会由自定义类加载器加载
 * 根据输出会发现加载的clazz对象的hashcode不同，代表加载了两个clazz对象。又引出了类加载器命名空间问题
 *
 * 每个类加载器都有自己的命名空间，命名空间由该类加载器及所有父加载器所加载的类组成
 * 在同一个命名空间中，不会出现类的完整名字（包括类的包名）相同的两个类
 * 在不同的命名空间中，有可能会出现类的完整名字（包括类的包名）相同的两个类
 */
public class MyTest16 extends ClassLoader{

    private String classLoaderName;

    private String path;

    private String fileExtension = ".class";

    public MyTest16(String classLoaderName){
        super();//将系统加载器作为该类的加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName){
        super(parent);//可以指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked className " + className);
        System.out.println("class loader" + this.classLoaderName);
        byte[] data = loadClassData(className);
        return defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        name = name.replace(".","/");
        this.classLoaderName = this.classLoaderName.replace(".","/");
        try {
            is = new FileInputStream(new File(path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void testClassUnLoading()throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
//        loader1.setPath("/Users/yinhao/IdeaProjects/jvm_lecture/out/production/classes/");
        loader1.setPath("/Users/yinhao/Desktop/");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());


        loader1 = null;
        clazz = null;
        obj = null;

        System.gc();

        loader1 = new MyTest16("loader2");
        clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        obj = clazz.newInstance();

        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());


    }

    public static void testClassLoading()throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
//        loader1.setPath("/Users/yinhao/IdeaProjects/jvm_lecture/out/production/classes/");
        loader1.setPath("/Users/yinhao/Desktop/");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

        System.out.println("------");

        MyTest16 loader2 = new MyTest16("loader2");
//        loader2.setPath("/Users/yinhao/IdeaProjects/jvm_lecture/out/production/classes/");
        loader2.setPath("/Users/yinhao/Desktop/");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class2 " + clazz2.hashCode());
        Object obj2 = clazz2.newInstance();
        System.out.println(obj2);
        System.out.println(obj2.getClass().getClassLoader());

        System.out.println("------");

        MyTest16 loader3 = new MyTest16(loader2,"loader3");//loader2作为loader3的父加载器
//        loader2.setPath("/Users/yinhao/IdeaProjects/jvm_lecture/out/production/classes/");
        loader3.setPath("/Users/yinhao/Desktop/");
        Class<?> clazz3 = loader3.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("class3 " + clazz3.hashCode());
        Object obj3 = clazz3.newInstance();
        System.out.println(obj3);
        System.out.println(obj3.getClass().getClassLoader());
    }

    public static void main(String[] args) throws Exception {
//        testClassLoading();
        testClassUnLoading();
    }

}
