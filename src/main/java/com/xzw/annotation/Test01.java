package com.xzw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author maroon
 * @date 2023/3/4 15:19
 */

public class Test01 {

    @MyAnnotation(name = "xz")
    public void test() {

    }

    @MyAnnotation1("name")
    public void test1() {

    }
}

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name();
}

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
    String value();
}
