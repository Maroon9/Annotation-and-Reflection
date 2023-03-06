package com.xzw.reflection;

/**
 * @author maroon
 * @date 2023/3/6 10:35
 * 测试类什么时候会初始化
 */
public class Test05 {
    static {
        System.out.println("main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son = new Son();

        //2.反射也会产生主动引用
        //Class.forName("com.xzw.reflection.Son");

        //3.访问静态变量
        //System.out.println(Son.m);

        //4.不会产生类的引用的方法，引用父类静态变量
        //System.out.println(Son.b);

        //5.通过数组定义类引用
        Son[] array = new Son[5];

        //6.引用常量
        //System.out.println(Son.M);
    }
}

class Father {

    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {

    static {
        System.out.println("子类被加载");
    }
    static int m =100;
    static final int M = 1;
}