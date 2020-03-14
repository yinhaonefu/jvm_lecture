package com.test.jvm.classloader;

public class MyTest3 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("-----------");

        MyTest3[] myTest15s = new MyTest3[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        System.out.println("-----------");

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
    }
}
