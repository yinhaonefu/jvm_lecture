package com.shengsiyuan.jvm.bytecode;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * javap -verbose out.production.classes.com.shengsiyuan.jvm.bytecode.MyTest3
 *
 * 对于Java类中的每一个实例方法，其在编译后所生成的字节码当中，方法参数的数量总是会比源代码中方法参数的数量多一个（this）
 * 它位于方法的第一个参数位置处；这样，我们就可以在Java的实例方法中使用this来访问当前对象的属性以及其他的方法
 *
 * 这个操作是在编译期间完成的，即由javac编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的访问；接下来在运行期
 * 间，由JVM在调用实例方法时，自动向实例方法传入该this参数，所以在实例方法的局部变量表中，至少会有一个指向当前对象的局部变量
 *
 * 反编译后的字节码中，test方法的局部变量为4个（locals=4），分别是this、inputStream、serverSocket，那还剩一个就是
 * catch块中的参数，因为无论发生什么异常都只会进入一个catch块，所以加上catch块的局部变量数量一共是4个
 *
 * Java异常处理
 * 1. 统一采用异常表的方式对异常进行处理
 * 2. 在JDK1.2.4之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令处理
 * 3. 当异常处理存在finally语句块时，现代化的JVM采用的处理方式是将finally语句块的字节码拼接到每一个catch块后面，
 *    换句话说，程序中存在多个catch块就会在每个catch块后面重复多少个finally块的字节码
 *
 * LineNumberTable表示的是源代码中的代码行数与字节码中的行数的对应关系
 * 打开jclasslib插件(view->Show Bytecode With jclasslib) Start PC表示字节码中的行数，Line Number表示源代码中的行数
 *
 * LocalVariableTable 局部变量表 表示所有的局部变量和方法参数，（每个局部变量表都有this变量）
 *
 *
 *
 */
public class MyTest3 {

    public void test(){
        try {
            InputStream inputStream = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();

        }catch (FileNotFoundException e){

        }catch (IOException e){

        }catch (Exception e){

        }finally {
            System.out.println("finally");
        }
    }
}
