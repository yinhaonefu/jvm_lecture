package com.test.jvm.classloader;

/**
 * 运行期修改扩展类加载器扫描的目录
 * 切换到classes目录然后执行 java -Djava.ext.dirs=./ com.test.jvm.classloader.MyTest6
 * 发现仍然是由AppClassLoader加载
 * 因为扩展类加载器需要从jar包中加载类，不是直接加载.class文件
 *
 * 将MyTest1.class打成jar包
 * jar cvf test.jar com/test/jvm/classloader/MyTest1.class
 * 会在classes下生成test.jar 再执行java -Djava.ext.dirs=./ com.test.jvm.classloader.MyTest6
 * MyTest1就会由ExtClassLoader加载
 *
 */
public class MyTest6 {

    static {
        System.out.println("MyTest6 static");
    }

    public static void main(String[] args) {

        System.out.println(MyTest6.class.getClassLoader());

        System.out.println(MyTest1.class.getClassLoader());

    }
}
