package com.test.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义类加载器
 * 当使用自定义类加载器加载一个类时，自定义类加载器会委托父类加载器，也就是AppClassLoader
 * 当父类加载器无法加载这个类时，再由自定义类加载器本身去加载这个类
 *
 * 验证方案：
 * 将一个class文件复制到磁盘另一个位置，并按包名建立好目录
 * 并设置自定义类加载器的path到这个位置，再将classpath下该class文件删除（为了不让AppClassLoader加载到这个class文件）
 *
 * 因为父类加载器无法在classpath下加载到这个类，所以会由自定义类加载器加载
 * 根据输出会发现加载的clazz对象的hashcode不同，代表加载了两个clazz对象。又引出了类加载器命名空间问题
 *
 * 每个类加载器都有自己的命名空间，命名空间由该类加载器及所有父加载器所加载的类组成
 * 在同一个命名空间中，不会出现类的完整名字（包括类的包名）相同的两个类
 * 在不同的命名空间中，有可能会出现类的完整名字（包括类的包名）相同的两个类
 *
 * 每个类加载器都有自己的命名空间，命名空间由该加载器及所有父加载器所加载的类组成
 * 在同一个命名空间中，不会出现类的完整名字相同的两个类
 * 在不同的命名空间中，有可能会出现类的完整名字相同的两个类
 *
 * 类能够被加载同样也能够被卸载，当一个类被加载，连接和初始化后它的声明周期就开始了。当这个类的Class对象不再被引用
 * 即不可触及时，CLass对象就会结束声明周期，这个类在方法区内的数据也会被卸载，从而结束类的声明周期。
 * 由Java虚拟机自带的类加载器所加载的类，在虚拟机的生命周期中，始终不会被卸载。前面已经介绍过，Java虚拟机自带的类
 * 加载器包括根类加载器、扩展类加载器和系统类加载器。Java虚拟机本身会始终引用这些类加载器，而这些类加载器则会始终
 * 引用它们所加载的类的CLass对象，因此这些Class对象始终是可触及的
 * 由用户自定义的类加载器所加载的类是可以被卸载的
 *
 *
 */
public class MyTest4 extends ClassLoader{

    private String classLoaderName;

    private String path;

    private String fileExtension = ".class";

    public MyTest4(String classLoaderName){
        super();//将系统加载器作为该类的加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest4(ClassLoader parent, String classLoaderName){
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
    protected Class<?> findClass(String className){
        System.out.println("findClass invoked className " + className);
        System.out.println("class loader" + this.classLoaderName);
        byte[] data = loadClassData(className);
        return defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name){
        byte[] data = null;
        name = name.replace(".","/");
        this.classLoaderName = this.classLoaderName.replace(".","/");
        try(
            InputStream is = new FileInputStream(new File(path + name + this.fileExtension));
            ByteArrayOutputStream baos = new ByteArrayOutputStream()
            ) {
            int ch = 0;
            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void testClassLoading()throws Exception{
        MyTest4 loader1 = new MyTest4("loader1");
        Class<?> clazz1 = loader1.loadClass("com.test.jvm.classloader.MyTest1");
        System.out.println("class " + clazz1.hashCode());
        Object obj1 = clazz1.newInstance();
        System.out.println(obj1);
    }

    public static void testClassUnLoading()throws Exception{
        MyTest4 loader1 = new MyTest4("loader1");
        loader1.setPath("/Users/yinhao/Desktop/");
        Class<?> clazz = loader1.loadClass("com.test.jvm.classloader.MyTest1");
        System.out.println("class " + clazz.hashCode());
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

        loader1 = null;
        clazz = null;
        obj = null;

        System.gc();

        Thread.sleep(100000);//打开jvisualvm观察类卸载情况，已卸载总数1

    }

    public static void main(String[] args) throws Exception {
        testClassUnLoading();
    }

}
