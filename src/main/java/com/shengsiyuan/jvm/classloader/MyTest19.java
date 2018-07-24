package com.shengsiyuan.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

public class MyTest19 {

    public static void main(String[] args) {

        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        //由扩展类加载器加载(如果程序执行时修改了扩展类加载器加载的目录，只能通过命令行执行时修改？就无法加载该类)
        System.out.println(aesKeyGenerator.getClass().getClassLoader());

        //由系统类加载器加载
        System.out.println(MyTest19.class.getClassLoader());
    }
}
