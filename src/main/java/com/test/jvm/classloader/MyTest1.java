package com.test.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

public class MyTest1 {
    public static void main(String[] args)throws Exception {

        Class<?> sClass = Class.forName("java.lang.String");
        System.out.println(sClass.getClassLoader());

        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());

        Class<?> mClass = Class.forName("com.test.jvm.classloader.MyTest1");
        System.out.println(mClass.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());

    }
}
