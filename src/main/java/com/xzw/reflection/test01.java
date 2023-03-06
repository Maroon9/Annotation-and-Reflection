package com.xzw.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maroon
 * @date 2023/3/4 16:49
 * 什么叫反射
 */
public class test01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //通过反射获取类的Class对象
        Class<?> c1 = Class.forName("com.xzw.reflection.User");
        System.out.println(c1);
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class User{

    private String name;

    private int id;

    private int age;
}