package com.paceup.day15;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    String info() default "Default Info"; //if value is not passed then use this default value
}

public class CombinedExample {
    @Test(info = "Test Method Annotation")
    public void testMethod() {
        System.out.println("Testing...");
    }

    public static void main(String[] args) throws Exception {
        CombinedExample obj = new CombinedExample();
        Method method = obj.getClass().getMethod("testMethod"); //to retrieve specific method

        if (method.isAnnotationPresent(Test.class)) { //to check if method is annotated
            Test annotation = method.getAnnotation(Test.class);
            System.out.println("Annotation Info: " + annotation.info());
            obj.testMethod();
        }
    }
}
