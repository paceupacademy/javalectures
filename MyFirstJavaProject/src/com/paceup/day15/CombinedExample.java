package com.paceup.day15;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    String info() default "Default Info";
}

public class CombinedExample {
    @Test(info = "Test Method Annotation")
    public void testMethod() {
        System.out.println("Testing...");
    }

    public static void main(String[] args) throws Exception {
        CombinedExample obj = new CombinedExample();
        Method method = obj.getClass().getMethod("testMethod");

        if (method.isAnnotationPresent(Test.class)) {
            Test annotation = method.getAnnotation(Test.class);
            System.out.println("Annotation Info: " + annotation.info());
        }
    }
}
