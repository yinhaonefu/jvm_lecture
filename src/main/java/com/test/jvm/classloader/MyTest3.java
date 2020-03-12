package com.test.jvm.classloader;

/**
 * <p> <tt>Class</tt> objects for array classes are not created by class
 * loaders, but are created automatically as required by the Java runtime.
 * The class loader for an array class, as returned by {@link
 * Class#getClassLoader()} is the same as the class loader for its element
 * type; if the element type is a primitive type, then the array class has no
 * class loader.
 */
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
