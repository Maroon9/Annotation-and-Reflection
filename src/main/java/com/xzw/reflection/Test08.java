package com.xzw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author maroon
 * @date 2023/3/6 20:08
 * 通过反射动态的创建对象
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.xzw.reflection.User");
        //本质是调用了类的无参构造器
        Object o = c1.newInstance();
        System.out.println(o);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        Object o1 = constructor.newInstance("xc", 1,1);
        System.out.println(o1);

        //通过反射获取一个方法
        User o2 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke：激活
        //（对象，方法的值）
        setName.invoke(o2, "xz");
        System.out.println(o2.getName());

        //通过反射操作属性
        User o3 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者你的方法的setAccessible(true)
        name.setAccessible(true);
        name.set(o3, "xz2");
        System.out.println(o3.getName());
    }
}
