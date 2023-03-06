package com.xzw.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.*;

/**
 * @author maroon
 * @date 2023/3/6 21:00
 */
public class Test11 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.xzw.reflection.Student2");
        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value的值
        Table annotation = (Table)c1.getAnnotation(Table.class);
        String value = annotation.value();
        System.out.println(value);

        //获得类指定的注解
        java.lang.reflect.Field field = c1.getDeclaredField("name");
        Field annotation1 = field.getAnnotation(Field.class);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("db_student")
class Student2 {
    @Field(columnName = "db_id", type = "int", length = 10)
    private int id;
    @Field(columnName = "db_age", type = "int", length = 10)
    private int age;
    @Field(columnName = "db_name", type = "varchar", length = 3)
    private String name;
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field {
    String columnName();
    String type();
    int length();
}