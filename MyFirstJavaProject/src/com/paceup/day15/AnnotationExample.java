package com.paceup.day15;

//Custom Annotation
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
 String value();
}

public class AnnotationExample {
 @MyAnnotation(value = "Hello, Annotation!")
 public void myMethod() {
     System.out.println("Method executed.");
 }

 public static void main(String[] args) throws Exception {
     AnnotationExample obj = new AnnotationExample();
     Method method = obj.getClass().getMethod("myMethod");

     if (method.isAnnotationPresent(MyAnnotation.class)) {
         MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
         //System.out.println("Annotation Value: " + annotation.value());
         
     }
 }
}
