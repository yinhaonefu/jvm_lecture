package com.test.jvm.classloader;

public class MySample {
    MySample(){
        System.out.println("MySample is loaded by " + this.getClass().getClassLoader());

        new MyCat();
    }
}
