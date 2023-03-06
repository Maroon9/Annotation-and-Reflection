package com.xzw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author maroon
 * @date 2023/3/6 19:48
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c1 = Class.forName("com.xzw.reflection.User");
        User user = new User();
        c1 = user.getClass();
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        //只能找到public属性
        Field[] fields = c1.getFields();

        fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------------------------------");

        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("正常的" + method);
        }
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("getDeclaredMethods" + method);
        }
        System.out.println("---------------------------------");

        //获得指定方法
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);
        System.out.println("---------------------------------");

        //获得指定的构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
