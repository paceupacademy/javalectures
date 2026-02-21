package com.paceup.ReflectionAnnotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * AnnotationProcessor:
 * --------------------
 * Demonstrates how to process annotations using Reflection.
 *
 * Key Concepts:
 * -------------
 * 1. Reflection:
 *    - Allows inspection of classes, methods, fields at runtime.
 *    - Useful for frameworks, tools, and annotation processing.
 *
 * 2. Annotation Processing Steps:
 *    a) Get the Class object using `.class`.
 *    b) Check if annotations are present using `isAnnotationPresent()`.
 *    c) Read annotation metadata using `getAnnotation()`.
 *    d) Retrieve methods and check for method-level annotations.
 *    e) Create object instances dynamically.
 *    f) Invoke methods via reflection.
 *
 * Backend Working:
 * ----------------
 * - Compiler attaches @MyAnnotationExample metadata to class and method.
 * - JVM retains metadata at runtime.
 * - Reflection APIs read metadata and print values.
 * - Method is invoked dynamically.
 *
 * Expected Output:
 * ----------------
 * Class Annotation Value: Class Annotation
 * Class Annotation Priority: 5
 *
 * Method: annotatedMethod
 * Annotation Value: Method Annotation
 * Annotation Priority: 2
 * Executing annotated method...
 */
public class AnnotationProcessor {
    public static void main(String[] args) {
        // Step 1: Get Class object of AnnotatedClass
        Class<AnnotatedClass> obj = AnnotatedClass.class;

        // Step 2: Check for class-level annotation
        if (obj.isAnnotationPresent(MyAnnotationExample.class)) {
            MyAnnotationExample annotation = obj.getAnnotation(MyAnnotationExample.class);
            System.out.println("Class Annotation Value: " + annotation.value());
            System.out.println("Class Annotation Priority: " + annotation.priority());
        }

        // Step 3: Process method-level annotations
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotationExample.class)) {
                MyAnnotationExample annotation = method.getAnnotation(MyAnnotationExample.class);
                System.out.println("\nMethod: " + method.getName());
                System.out.println("Annotation Value: " + annotation.value());
                System.out.println("Annotation Priority: " + annotation.priority());

                try {
                    // Step 4: Create object dynamically
                    AnnotatedClass instance = obj.getDeclaredConstructor().newInstance();

                    // Step 5: Invoke method via reflection
                    method.invoke(instance);
                } catch (InstantiationException | IllegalAccessException |
                         InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
