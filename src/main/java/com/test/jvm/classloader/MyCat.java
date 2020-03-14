package com.test.jvm.classloader;

public class MyCat {
    MyCat(){
        System.out.println("MyCat is loaded by " + this.getClass().getClassLoader());
    }
}
