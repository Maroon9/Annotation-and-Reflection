package com.xzw.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author maroon
 * @date 2023/3/6 20:35
 * 分析性能问题
 */
public class Test09 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }

    public static void test01() {
        User user = new User();

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("普通方法执行10亿次：" + (endTime - startTime) + "ms");
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName", null);

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("反射方法执行10亿次：" + (endTime - startTime) + "ms");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("关闭检测执行10亿次：" + (endTime - startTime) + "ms");
    }
}
