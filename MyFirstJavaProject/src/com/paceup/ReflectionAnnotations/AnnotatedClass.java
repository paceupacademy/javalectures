package com.paceup.ReflectionAnnotations;

/**
 * AnnotatedClass:
 * ----------------
 * Demonstrates usage of the custom annotation `@MyAnnotationExample`.
 *
 * Key Concepts:
 * -------------
 * - Annotations provide metadata about the program.
 * - Do not directly affect logic but can be processed by compilers/tools/reflection.
 * - JVM keeps annotation metadata available at runtime if RetentionPolicy.RUNTIME is used.
 *
 * In this example:
 * - A custom annotation `@MyAnnotationExample` is applied to a class and a method.
 * - Metadata (value, priority) is attached to both.
 */
@MyAnnotationExample(value = "Class Annotation", priority = 5)
public class AnnotatedClass {

    @MyAnnotationExample(value = "Method Annotation", priority = 2)
    public void annotatedMethod() {
        System.out.println("Executing annotated method...");
    }
}
