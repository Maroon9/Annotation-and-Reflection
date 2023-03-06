package com.xzw.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maroon
 * @date 2023/3/5 18:41
 * 创建Class类的方式有哪些
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是" + person.name);

        //方式一：通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二：forName获得
        Class c2 = Class.forName("com.xzw.reflection.Student");
        System.out.println(c2.hashCode());

        //通过类名.class获得
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person {
    String name;
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}