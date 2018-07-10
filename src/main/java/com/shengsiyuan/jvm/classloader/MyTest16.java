package com.shengsiyuan.jvm.classloader;

import java.io.*;

/**
 * 自定义类加载器
 */
public class MyTest16 extends ClassLoader{

    private String classLoaderName;

    private String fileExtension = ".class";

    public MyTest16(String classLoaderName){
        super();//将系统加载器作为该类的加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName){
        super(parent);//可以指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = loadClassData(className);
        return defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        this.classLoaderName = this.classLoaderName.replace(".","/");
        try {
            is = new FileInputStream(new File(name + this.fileExtension));
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

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }


    public static void main(String[] args) throws Exception {
        MyTest16 myTest16 = new MyTest16("loader1");
        test(myTest16);
    }

}
