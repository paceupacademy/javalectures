package com.paceup.day15;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        // Access the class
        Class<AnnotatedClass> obj = AnnotatedClass.class;

        // Check for class-level annotation
        if (obj.isAnnotationPresent(MyAnnotationExample.class)) { //check if annotation is present
            MyAnnotationExample annotation = obj.getAnnotation(MyAnnotationExample.class);
            System.out.println("Class Annotation: " + annotation.value() + ", Priority: " + annotation.priority());
        }

        // Check for method-level annotations
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotationExample.class)) {
            	MyAnnotationExample annotation = method.getAnnotation(MyAnnotationExample.class);
                System.out.println("Method: " + method.getName() + ", Value: " + annotation.value() + ", Priority: " + annotation.priority());
                
               AnnotatedClass obj1 = new AnnotatedClass();
               obj1.annotatedMethod();
            }
        }
    }
}
