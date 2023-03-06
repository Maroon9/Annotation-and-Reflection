package com.xzw.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author maroon
 * @date 2023/3/6 20:47
 * 通过反射获取泛型
 */
public class Test10 {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test10.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
        }

        method = Test10.class.getMethod("test02", null);
        Type type = method.getGenericReturnType();
        System.out.println(type);
    }

    public void test01(Map<String,User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String,User> test02() {
        System.out.println("test02");
        return null;
    }
}
